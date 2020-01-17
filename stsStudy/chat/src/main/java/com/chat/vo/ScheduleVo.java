package com.chat.vo;

public class ScheduleVo {
	private int no;
	private String evt_name;
	private String evt_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEvt_name() {
		return evt_name;
	}
	public void setEvt_name(String evt_name) {
		this.evt_name = evt_name;
	}
	public String getEvt_date() {
		return evt_date;
	}
	public void setEvt_date(String evt_date) {
		this.evt_date = evt_date;
	}
	public ScheduleVo(int no, String evt_name, String evt_date) {
		super();
		this.no = no;
		this.evt_name = evt_name;
		this.evt_date = evt_date;
	}
	public ScheduleVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SccheduleVo [no=" + no + ", evt_name=" + evt_name + ", evt_date=" + evt_date + "]";
	}
	
	
}
