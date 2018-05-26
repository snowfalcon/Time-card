package hal.java.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hal.java.common.DatabaseConnection;
import hal.java.form.ListForm;
import hal.java.form.TimeObj;
import hal.java.form.UserObj;
import hal.java.util.Check;

public class ListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("ListAction");
		HttpSession session = request.getSession();
		if (Check.isCheck(session)) {
			ListForm listForm = (ListForm) form;
			// TimeObj
			TimeObj[] timeObj = listForm.getTimeObj();
			Connection con = DatabaseConnection.getConnection();

			int[] calendarDay = new int[31];
			int count = 0;
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);

			// 月別プルダウン
			String param = request.getParameter("YEAR");
			if (param == null || param.length() == 0) {
				year = -999;
			} else {
				try {
					year = Integer.parseInt(param);
				} catch (NumberFormatException e) {
					year = -999;
				}
			}

			param = request.getParameter("MONTH");
			if (param == null || param.length() == 0) {
				month = -999;
			} else {
				try {
					month = Integer.parseInt(param);
					month = month - 1;
				} catch (NumberFormatException e) {
					month = -999;
				}
			}

			/* パラメータが指定されていない場合は本日の日付を設定 */
			if (year == -999 || month == -999) {
				year = calendar.get(Calendar.YEAR);
				month = calendar.get(Calendar.MONTH);
			} else {
				if (month == 12) {
					month = 0;
					year++;
				}

				if (month == -1) {
					month = 11;
					year--;
				}
			}
			//表示月をsessionに格納
			session.setAttribute("Year", year);
			session.setAttribute("Month", month + 1);

			/* 表示月が何日までかを確認する */
			calendar.set(year, month + 1, 0);
			int thisMonthlastDay = calendar.get(Calendar.DATE);
			session.setAttribute("Last", thisMonthlastDay);

			/* 表示月分の日付を格納する */
			for (int i = 1; i <= thisMonthlastDay; i++) {
				calendarDay[count++] = i;
			}

			/* 日付とスケジュールの作成 */
			for (int i = 0; i < count; i++) {
				// 日付
				timeObj[i].setDay(i);
				// 曜日
				calendar.set(year, month, i);
				int week = calendar.get(Calendar.DAY_OF_WEEK);
				String[] week_name = { "", "月", "火", "水", "木", "金", "土", "日" };
				timeObj[i].setWeek(week_name[week]);
				/* 勤怠管理の表示 */
				try {
					String sql = "SELECT * FROM t_timecard WHERE shain_no = ? and timecard_date = ? ORDER BY time_start";
					PreparedStatement pstmt = con.prepareStatement(sql);
					String startDateStr = year + "-" + (month + 1) + "-" + calendarDay[i];
					String sid = (String) session.getAttribute("Id");
					// 表示の変更
					String scid = (String) session.getAttribute("CId");
					if (scid == null) {
						scid = sid;
					}
					int cid = Integer.parseInt(scid);
					//
					pstmt.setInt(1, cid);
					pstmt.setString(2, startDateStr);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						timeObj[i].setDate(rs.getString("timecard_date"));
						timeObj[i].setStart(rs.getString("time_start"));
						timeObj[i].setEnd(rs.getString("time_end"));
						timeObj[i].setRest("01:00");
						timeObj[i].setWork(rs.getString("time_start"), rs.getString("time_end"));
					}
					rs.close();
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			listForm.setTimeObj(timeObj);
			// UserObj
			UserObj[] userObj = listForm.getUserObj();
			try {
				con = DatabaseConnection.getConnection();
				Statement smt = con.createStatement();
				ResultSet rs = smt.executeQuery("SELECT shain_name FROM mt_shain");
				int i = 0;
				while (rs.next()) {
					userObj[i].setUser(rs.getString("shain_name"));
					i++;
				}
			} finally {
			}
			listForm.setUserObj(userObj);
			// 名前をsessionに格納
			try {
				con = DatabaseConnection.getConnection();
				String sql = "SELECT * FROM mt_shain WHERE shain_no = ? ORDER BY shain_name";
				PreparedStatement pstmt = con.prepareStatement(sql);
				String sid = (String) session.getAttribute("Id");
				String scid = (String) session.getAttribute("CId");
				if (scid == null) {
					scid = sid;
				}
				int cid = Integer.parseInt(scid);
				pstmt.setInt(1, cid);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					session.setAttribute("Name", rs.getString("shain_name"));
				}
			} finally {
			}
			session.setAttribute("listForm", listForm);
			return mapping.findForward("success");
		} else {
			return mapping.findForward("error");
		}
	}
}