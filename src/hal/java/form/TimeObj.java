package hal.java.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeObj implements java.io.Serializable{

	private int day = 0;
	private String week = null;
	private String date = null;
	private String start = null;
	private String end = null;
	private String rest = null;
	private String work = null;

	public TimeObj(){
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day + 1;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start.substring(11, 16);
	}

	public String getEnd() {
		return end;
	}

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}


	public void setEnd(String end) {
		if(end!=null){
		this.end = end.substring(11, 16);
		}
	}

	public String getWork() {
		return work;
	}

	public void setWork(String start,String end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date fromDate = sdf.parse(start);
		if(end != null){
		Date toDate = sdf.parse(end);
		long from = fromDate.getTime();
		long to = toDate.getTime();
		long diff = (to - from) / (1000 * 60);
														/*↓休憩時間*/
		String hour = String.valueOf(((int) (diff)  / 60) -1);
		String min = String.valueOf(((int) ((diff % 60) / 30)) * 5);
		String work = hour + "." + min;
		this.work = work;
		}
	}
}