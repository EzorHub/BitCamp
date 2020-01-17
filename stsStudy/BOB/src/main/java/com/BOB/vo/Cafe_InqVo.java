package com.BOB.vo;

public class Cafe_InqVo {

	private int inq_no;
	private int cafe_no;
	private String inq_content;
	private String inq_reply;
	private String issecret;
	private int cust_no;
	public int getInq_no() {
		return inq_no;
	}
	public void setInq_no(int inq_no) {
		this.inq_no = inq_no;
	}
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public String getInq_content() {
		return inq_content;
	}
	public void setInq_content(String inq_content) {
		this.inq_content = inq_content;
	}
	public String getInq_reply() {
		return inq_reply;
	}
	public void setInq_reply(String inq_reply) {
		this.inq_reply = inq_reply;
	}
	public String getIssecret() {
		return issecret;
	}
	public void setIssecret(String issecret) {
		this.issecret = issecret;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public Cafe_InqVo(int inq_no, int cafe_no, String inq_content, String inq_reply, String issecret, int cust_no) {
		super();
		this.inq_no = inq_no;
		this.cafe_no = cafe_no;
		this.inq_content = inq_content;
		this.inq_reply = inq_reply;
		this.issecret = issecret;
		this.cust_no = cust_no;
	}
	public Cafe_InqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
