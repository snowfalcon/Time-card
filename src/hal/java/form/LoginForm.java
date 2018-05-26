package hal.java.form;

import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm{

	private String inputId = null;
	private String inputPass = null;
	private String auth = null;

	public LoginForm(){
	  System.out.println("LoginForm");
	}

	public String getInputId() {
		return inputId;
	}

	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	public String getInputPass() {
		return inputPass;
	}

	public void setInputPass(String inputPass) {
		this.inputPass = inputPass;
	}
	public String getInputAuth() {
		return auth;
	}

	public void setInputAuth(String Auth) {
		this.auth = Auth;
	}
}