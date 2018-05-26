package hal.java.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hal.java.common.DatabaseConnection;
import hal.java.form.RevisionForm;
import hal.java.util.Check;

public class RevisionAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("RevisionAction");
		HttpSession session = request.getSession();
		if (Check.isCheck(session)) {
			RevisionForm revisionForm = (RevisionForm) form;
			Connection con = DatabaseConnection.getConnection();
			Statement smt = con.createStatement();
			String sql = "SELECT time_start,time_end FROM t_timecard WHERE shain_no = " + session.getAttribute("CId")
					+ " AND timecard_date = \"" + request.getParameter("YEAR") + "-0" + request.getParameter("MONTH")
					+ "-02\"";
			System.out.println(sql);
			ResultSet rs = smt.executeQuery(sql);
			rs.absolute(1);
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			session.setAttribute("s", rs.getString(1));
			session.setAttribute("e", rs.getString(2));
			session.setAttribute("revisionForm", revisionForm);
			// session確認
			Enumeration<String> e = session.getAttributeNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				System.out.println(key + "：" + session.getAttribute(key));
			}
			return mapping.findForward("success");
		} else {
			return mapping.findForward("error");
		}
	}
}