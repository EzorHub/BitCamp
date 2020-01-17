package com.BOB.vo;

import java.util.Date;

public class SNSVo {

	private int sns_no;
	private String sns_content;
	private int sns_like;
	private String sns_write_date;
	private int cust_no;
	private int provider_no;
	public int getSns_no() {
		return sns_no;
	}
	public void setSns_no(int sns_no) {
		this.sns_no = sns_no;
	}
	public String getSns_content() {
		return sns_content;
	}
	public void setSns_content(String sns_content) {
		this.sns_content = sns_content;
	}
	public int getSns_like() {
		return sns_like;
	}
	public void setSns_like(int sns_like) {
		this.sns_like = sns_like;
	}
	public String getSns_write_date() {
		return sns_write_date;
	}
	public void setSns_write_date(String sns_write_date) {
		this.sns_write_date = sns_write_date;
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
	public SNSVo(int sns_no, String sns_content, int sns_like, String sns_write_date, int cust_no, int provider_no) {
		super();
		this.sns_no = sns_no;
		this.sns_content = sns_content;
		this.sns_like = sns_like;
		this.sns_write_date = sns_write_date;
		this.cust_no = cust_no;
		this.provider_no = provider_no;
	}
	public SNSVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
