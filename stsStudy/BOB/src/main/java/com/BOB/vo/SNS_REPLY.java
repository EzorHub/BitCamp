package com.BOB.vo;

public class SNS_REPLY {

	private int reply_no;
	private String reply_content;
	private int sns_no;
	private int cust_no;
	private int provider_no;
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public int getSns_no() {
		return sns_no;
	}
	public void setSns_no(int sns_no) {
		this.sns_no = sns_no;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public int getProvider_no() {
		return provider_no;
	}
	public void setProvider_no(int provider_no) {
		this.provider_no = provider_no;
	}
	public SNS_REPLY(int reply_no, String reply_content, int sns_no, int cust_no, int provider_no) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.sns_no = sns_no;
		this.cust_no = cust_no;
		this.provider_no = provider_no;
	}
	public SNS_REPLY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
