package gomibako;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hal.java.common.DatabaseConnection;

public class StartTime extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html; charset=Shift_JIS");
		HttpSession session = request.getSession();
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into t_timecard (shain_no, timecard_date, kintai_kbn, time_start) values (" + session.getAttribute("Id")
					+ ", cast( now() as date), '01',cast( now() as datetime))";
			stmt.executeUpdate(sql);
			response.sendRedirect("LoginAction.do");
			stmt.close();
		} catch (SQLException e) {
			response.sendRedirect("LoginAction.do");
		}
	}
}