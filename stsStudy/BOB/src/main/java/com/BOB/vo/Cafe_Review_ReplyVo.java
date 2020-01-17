package com.BOB.vo;

public class Cafe_Review_ReplyVo {
	private int reply_no;
	private String reply;
	private int review_no;
	private int cust_no;
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public Cafe_Review_ReplyVo(int reply_no, String reply, int review_no, int cust_no) {
		super();
		this.reply_no = reply_no;
		this.reply = reply;
		this.review_no = review_no;
		this.cust_no = cust_no;
	}
	public Cafe_Review_ReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
