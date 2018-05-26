package gomibako;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hal.java.form.ListForm;
import hal.java.form.TimeObj;

public class CsvAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ListForm listForm = (ListForm) session.getAttribute("listForm");
		TimeObj[] timeObj = listForm.getTimeObj();
		String day = null;
		String week = null;
		String start = null;
		String end = null;
		String rest = null;
		String work = null;
		String rows[][];
		int lastday = timeObj[30].getDay();
		if (lastday == 0){
			lastday = timeObj[29].getDay();
			if (lastday == 0){
				lastday = timeObj[28].getDay();

			}
		}
		rows = new String[lastday][6];
		for (int i = 0; i < lastday; i++) {
			day = Integer.toString(timeObj[i].getDay());
			rows[i][0] = day;
			week = timeObj[i].getWeek();
			rows[i][1] = week;
			start = timeObj[i].getStart();
			rows[i][2] = start;
			end = timeObj[i].getEnd();
			rows[i][3] = end;
			rest = timeObj[i].getRest();
			rows[i][4] = rest;
			work = timeObj[i].getWork();
			rows[i][5] = work;
		}

		// 文字コード設定
		response.setContentType("text/html; charset=UTF-8");
		// ファイル名設定（ファイル名を設定しないと、htmlとして画面に表示されてしまいます
		response.setHeader("Content-Disposition", "attachment; filename=\"strutscsv.csv\"");

		// CSVデータ作成
		StringBuffer sb = new StringBuffer();
		for (String[] row : rows) {

			for (int j = 0; j < row.length; j++) {
				if (j == 0) {
				} else {
					sb.append(",");
				}

				if (row[j] == null){
					row[j] = "";
				}

				sb.append(row[j]);

				if (j == row.length - 1) {
					sb.append("\n");
				}
			}
		}

		// レスポンスにCSV出力
		PrintWriter w = response.getWriter();
		w.print(session.getAttribute("Year") + "年" + session.getAttribute("Month") + "月\n");
		w.print((String) session.getAttribute("Name") + "\n");
		w.print("日付,曜日,開始時間,終了時間,休憩時間,作業時間\n");
		w.print(sb.toString());
		w.flush();
		w.close();
		return null;
	}
}
