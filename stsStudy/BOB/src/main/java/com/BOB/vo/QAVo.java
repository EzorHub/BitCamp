package com.BOB.vo;

public class QAVo {

	private int qa_no;
	private String qa_title;
	private String qa_content;
	private String qa_write_date;
	private int b_ref;
	private int b_level;
	private int b_step;
	private int cust_no;
	private int man_no;
	public int getQa_no() {
		return qa_no;
	}
	public void setQa_no(int qa_no) {
		this.qa_no = qa_no;
	}
	public String getQa_title() {
		return qa_title;
	}
	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public String getQa_write_date() {
		return qa_write_date;
	}
	public void setQa_write_date(String qa_write_date) {
		this.qa_write_date = qa_write_date;
	}
	public int getB_ref() {
		return b_ref;
	}
	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}
	public int getB_level() {
		return b_level;
	}
	public void setB_level(int b_level) {
		this.b_level = b_level;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public int getMan_no() {
		return man_no;
	}
	public void setMan_no(int man_no) {
		this.man_no = man_no;
	}
	public QAVo(int qa_no, String qa_title, String qa_content, String qa_write_date, int b_ref, int b_level, int b_step,
			int cust_no, int man_no) {
		super();
		this.qa_no = qa_no;
		this.qa_title = qa_title;
		this.qa_content = qa_content;
		this.qa_write_date = qa_write_date;
		this.b_ref = b_ref;
		this.b_level = b_level;
		this.b_step = b_step;
		this.cust_no = cust_no;
		this.man_no = man_no;
	}
	public QAVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
