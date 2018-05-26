package hal.java.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;

import hal.java.common.DatabaseConnection;
public class Check extends Action {
	public static boolean isCheck(HttpSession session) {
	try {
		Connection con = DatabaseConnection.getConnection();
		Statement smt = con.createStatement();
		String sql = "SELECT login_password FROM mt_shain WHERE shain_no = " + session.getAttribute("Id")
				+ " AND login_password = " + session.getAttribute("Pass");
		ResultSet rs = smt.executeQuery(sql);
		rs.absolute(1);
		String pass = rs.getString(1);
		rs.close();
		smt.close();
		return pass.equals(session.getAttribute("Pass"));
	} catch (SQLException e) {
		System.out.println("社員番号がないか、パスワードが違います。");
	}
	return false;
}}