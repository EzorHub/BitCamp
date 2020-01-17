package com.BOB.vo;

public class NoticeVo {

	private int notice_no;
	private String notice_title;
	private String notice_content;
	private String write_date;
	private int hits;
	private int man_no;
	public int getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getMan_no() {
		return man_no;
	}
	public void setMan_no(int man_no) {
		this.man_no = man_no;
	}
	public NoticeVo(int notice_no, String notice_title, String notice_content, String write_date, int hits,
			int man_no) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.write_date = write_date;
		this.hits = hits;
		this.man_no = man_no;
	}
	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
