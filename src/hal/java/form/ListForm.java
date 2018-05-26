package hal.java.form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.struts.validator.ValidatorForm;

import hal.java.common.DatabaseConnection;

public class ListForm extends ValidatorForm {

	private TimeObj[] timeObj = null;
	private UserObj[] userObj = null;

	// 配列を初期化する数
	private int arry = 31;

	public ListForm() {
		System.out.println("TimecardForm");
	}

	// null を返却しないよう、ここでは 初期化数を 設定 します
	public TimeObj[] getTimeObj() throws SQLException {
		// arryの数だけ配列番号割り当て
		if (this.timeObj == null) {
			this.timeObj = new TimeObj[arry];
			for (int i = 0; i < this.timeObj.length; i++) {
				this.timeObj[i] = new TimeObj();
			}
		}
		return timeObj;
	}

	public void setTimeObj(TimeObj[] timeObj) {
		this.timeObj = timeObj;
	}

	// UserObj
	public UserObj[] getUserObj() {
		Connection con;
		try {
			con = DatabaseConnection.getConnection();
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT shain_name FROM mt_shain");
			int arry2 = 0;
			while (rs.next()) {
				arry2++;
			}
			// arryの数だけ配列番号割り当て
			if (this.userObj == null) {
				this.userObj = new UserObj[arry2];
				for (int i = 0; i < this.userObj.length; i++) {
					this.userObj[i] = new UserObj();
				}
			}
			con.close();
			smt.close();
		} catch (SQLException e) {
		}
		return userObj;
	}

	public void setUserObj(UserObj[] userObj) {
		this.userObj = userObj;
	}
}