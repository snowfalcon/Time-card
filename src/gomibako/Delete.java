package gomibako;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = response.getWriter();

		Connection conn = null;
		String url = "jdbc:mysql://localhost/KintaiSys";
		String user = "hal";
		String password = "21";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();
			String sql = "delete from t_timecard where shain_no = '00001'";
			stmt.executeUpdate(sql);

			response.sendRedirect("LoginAction.do");

			stmt.close();
		} catch (ClassNotFoundException e) {
			out.println("ClassNotFoundException:" + e.getMessage());
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
