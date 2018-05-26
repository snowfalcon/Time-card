package gomibako;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import hal.java.common.DatabaseConnection;

public class List {

	public static void main(String[] args)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		Connection con = DatabaseConnection.getConnection();

		int[] calendarDay = new int[31];
		int count = 0;
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);

		/* 今月が何曜日から開始されているか確認する */
		calendar.set(year, month, 1);
		int startWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("表示月の曜日は" + startWeek + "から");

		/* 今月が何日までかを確認する */
		calendar.set(year, month + 1, 0);
		int thisMonthlastDay = calendar.get(Calendar.DATE);
		System.out.println("表示月は" + thisMonthlastDay + "日まで\r\n");

		/* 今月分の日付を格納する */
		for (int i = 1; i <= thisMonthlastDay; i++) {
			calendarDay[count++] = i;
		}

		/* 日付とスケジュールの作成 */
		for (int i = 0; i < count; i++) {
			/* スケジュールの日付画面を作成する */
			System.out.println(calendarDay[i] + " ");
			/* スケジュールの表示 */
			try {
				String sql = "SELECT * FROM t_timecard WHERE shain_no = ? and timecard_date = ? ORDER BY time_start";
				PreparedStatement pstmt = con.prepareStatement(sql);

				String startDateStr = year + "-" + (month + 1) + "-" + calendarDay[i];
				pstmt.setInt(1, 1);
				pstmt.setString(2, startDateStr);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					String start = rs.getString("time_start");
					String end = rs.getString("time_end");

					if (start == null || end == null) {
					} else {
						String startStr = start.substring(11, 16);
						String endStr = end.substring(11, 16);
						System.out.println(startStr + "～" + endStr);
					}
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
			}
		}
	}
}
