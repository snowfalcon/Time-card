package hal.java.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hal.java.common.DatabaseConnection;
import hal.java.form.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("LoginAction");
		LoginForm param = (LoginForm) form;
		HttpSession session = request.getSession();
		if (isCheck(param)) {

			//挨拶初期化
			if (session.getAttribute("Hello") == null){
				session.setAttribute("Hello", "");
			};

			session.setAttribute("Id", param.getInputId());
			session.setAttribute("CId", param.getInputId());
			session.setAttribute("Pass", param.getInputPass());
			// 権限決定
			Connection con;
			con = DatabaseConnection.getConnection();
			Statement smt = con.createStatement();
			String sql = "SELECT kengen_kbn FROM mt_shain WHERE shain_no = " + param.getInputId()
					+ " AND login_password = " + param.getInputPass();
			ResultSet rs = smt.executeQuery(sql);
			rs.absolute(1);
			String auth = rs.getString(1);
			//authをsessionに
			session.setAttribute("Auth", auth);
			//authをFormに
			param.setInputAuth(auth);
			return mapping.findForward("success");
		} else {
			return mapping.findForward("error");
		}
	}

	private boolean isCheck(LoginForm param) {
		Connection con;
		try {
			con = DatabaseConnection.getConnection();
			Statement smt = con.createStatement();
			String sql = "SELECT login_password FROM mt_shain WHERE shain_no = " + param.getInputId()
					+ " AND login_password = " + param.getInputPass();
			ResultSet rs = smt.executeQuery(sql);
			rs.absolute(1);
			String pass = rs.getString(1);
			return pass.equals(param.getInputPass());
		} catch (SQLException e) {
			System.out.println("社員番号がないか、パスワードが違う");
		}
		return false;
	}
}