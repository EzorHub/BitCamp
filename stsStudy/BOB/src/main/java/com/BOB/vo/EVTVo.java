package com.BOB.vo;

public class EVTVo {

	private int evt_no;
	private String evt_title;
	private String evt_content;
	private int discount;
	private String evt_start;
	private String evt_end;
	private int man_no;
	public int getEvt_no() {
		return evt_no;
	}
	public void setEvt_no(int evt_no) {
		this.evt_no = evt_no;
	}
	public String getEvt_title() {
		return evt_title;
	}
	public void setEvt_title(String evt_title) {
		this.evt_title = evt_title;
	}
	public String getEvt_content() {
		return evt_content;
	}
	public void setEvt_content(String evt_content) {
		this.evt_content = evt_content;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getEvt_start() {
		return evt_start;
	}
	public void setEvt_start(String evt_start) {
		this.evt_start = evt_start;
	}
	public String getEvt_end() {
		return evt_end;
	}
	public void setEvt_end(String evt_end) {
		this.evt_end = evt_end;
	}
	public int getMan_no() {
		return man_no;
	}
	public void setMan_no(int man_no) {
		this.man_no = man_no;
	}
	public EVTVo(int evt_no, String evt_title, String evt_content, int discount, String evt_start, String evt_end,
			int man_no) {
		super();
		this.evt_no = evt_no;
		this.evt_title = evt_title;
		this.evt_content = evt_content;
		this.discount = discount;
		this.evt_start = evt_start;
		this.evt_end = evt_end;
		this.man_no = man_no;
	}
	public EVTVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
