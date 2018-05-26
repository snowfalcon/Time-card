package gomibako;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EndTime extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html; charset=Shift_JIS");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		Connection conn = null;
		String url = "jdbc:mysql://localhost/KintaiSys";
		String user = "hal";
		String password = "21";

		try {
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			String sql = "SELECT time_end FROM t_timecard WHERE  shain_no = " + session.getAttribute("Id")
					+ " AND timecard_date = cast( now() as date)";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String s = rs.getString("time_end");
				System.out.println(s);
				if (s != null) {
					response.sendRedirect("LoginAction.do");
				} else {
					sql = "UPDATE t_timecard SET time_end = cast( now() as datetime) WHERE shain_no = '00001' AND  timecard_date = cast( now() as date)";
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