package hal.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/kintaisys?autoReconnect=true&useSSL=false";
	final static String USER = "hal";
	final static String PASS = "21";

	public static Connection getConnection() throws SQLException{
		try{
			Class. forName(DRIVER);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			throw new IllegalStateException("クラスのロードに失敗しました: "+e.getMessage());
		}
		Connection con = DriverManager.getConnection(URL,USER, PASS);
		return con;
	}

	public static ResultSet rs() throws SQLException {
		try {
			Connection conn = DatabaseConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from t_timecard");
			stmt.close();
			rs.close();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
