package hal.java.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hal.java.common.DatabaseConnection;

public class TimecardUtil extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POSTメソッドでアクセスが来てもGETメソッドで全部処理します。
		doGet(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html; charset=Shift_JIS");
		HttpSession session = request.getSession();
		Connection conn = null;
		PrintWriter out = response.getWriter();
		// リクエストの取得
		String MyAction = request.getParameter("MySubmit");
		// 処理の実行
		if (MyAction.equals("Start")) {
			session.setAttribute("Start", "disabled='disabled'");
			session.setAttribute("End", "");
			session.setAttribute("Hello", "おはようございます。");
			try {
				conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "insert into t_timecard (shain_no, timecard_date, kintai_kbn, time_start) values ('"
						+ session.getAttribute("Id") + "', cast( now() as date), '01',cast( now() as datetime))";
				stmt.executeUpdate(sql);
				response.sendRedirect("LoginAction.do");
				stmt.close();
			} catch (SQLException e) {
				session.setAttribute("Start", "");
				session.setAttribute("End", "disabled='disabled'");
				session.setAttribute("Hello", "本日の営業は終了しました。");
				response.sendRedirect("LoginAction.do");
			}
		}
		if (MyAction.equals("End")) {
			session.setAttribute("End", "disabled='disabled'");
			session.setAttribute("Start", "");
			session.setAttribute("Hello", "おつかれさまでした。");
			try {
				conn = DatabaseConnection.getConnection();

				Statement stmt = conn.createStatement();
				String sql = "SELECT time_end FROM t_timecard WHERE  shain_no = '" + session.getAttribute("Id")
						+ "' AND timecard_date = cast( now() as date)";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String s = rs.getString("time_end");
					if (s != null) {
						response.sendRedirect("LoginAction.do");
					} else {
						sql = "UPDATE t_timecard SET time_end = cast( now() as datetime) WHERE shain_no = '"
								+ session.getAttribute("Id") + "' AND  timecard_date = cast( now() as date)";
						stmt.executeUpdate(sql);
						response.sendRedirect("LoginAction.do");
					}
				}
				stmt.close();
			} catch (SQLException e) {
				out.println("SQLException:" + e.getMessage());
			} catch (Exception e) {
				out.println("Exception:" + e.getMessage());
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					out.println("SQLException:" + e.getMessage());
				}
			}
		}
	}
}
