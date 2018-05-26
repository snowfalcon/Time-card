package hal.java.form;

import org.apache.struts.validator.ValidatorForm;

public class RevisionForm extends ValidatorForm{

	private String time_start = null;
	private String time_end = null;

	public RevisionForm(){
	  System.out.println("RevisionForm");
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
}