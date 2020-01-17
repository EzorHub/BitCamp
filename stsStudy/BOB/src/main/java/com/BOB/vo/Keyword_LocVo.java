package com.BOB.vo;

public class Keyword_LocVo {

	private String key_name;
	private int key_name_hit;
	private int cust_no;
	public String getKey_name() {
		return key_name;
	}
	public void setKey_name(String key_name) {
		this.key_name = key_name;
	}
	public int getKey_name_hit() {
		return key_name_hit;
	}
	public void setKey_name_hit(int key_name_hit) {
		this.key_name_hit = key_name_hit;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public Keyword_LocVo(String key_name, int key_name_hit, int cust_no) {
		super();
		this.key_name = key_name;
		this.key_name_hit = key_name_hit;
		this.cust_no = cust_no;
	}
	public Keyword_LocVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
