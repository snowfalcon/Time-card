package hal.java.util;

import java.io.IOException;
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

public class ListUtil extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POSTメソッドでアクセスが来てもGETメソッドで全部処理します。
		doGet(req, resp);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("Shift_JIS");
		HttpSession session = request.getSession();
		String namae = (String) request.getParameter("namae");
		System.out.println(namae);
		Connection con;
		try {
			con = DatabaseConnection.getConnection();
			Statement smt = con.createStatement();
			String sql = "SELECT shain_no FROM mt_shain WHERE shain_name = '" + namae + "'";
			System.out.println(sql);
			ResultSet rs = smt.executeQuery(sql);
			rs.absolute(1);
			String cid = rs.getString(1);
			System.out.println(cid);
			// cidをsessionに
			session.setAttribute("CId", cid);
			Object year = session.getAttribute("Year");
			Object month = session.getAttribute("Month");
			response.sendRedirect("ListAction.do?YEAR="+ year +"&MONTH="+ month);
		} catch (SQLException e) {
		}
	}
}
