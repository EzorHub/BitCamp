package com.BOB.vo;

public class ProviderVo {
	private int provider_no;
	private String pro_name;
	private String pro_nick;
	private String pro_img;
	private String phone;
	private String email;
	private String id;
	private String pwd;
	private String pro_q;
	private String pro_a;
	public int getProvider_no() {
		return provider_no;
	}
	public void setProvider_no(int provider_no) {
		this.provider_no = provider_no;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_nick() {
		return pro_nick;
	}
	public void setPro_nick(String pro_nick) {
		this.pro_nick = pro_nick;
	}
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPro_q() {
		return pro_q;
	}
	public void setPro_q(String pro_q) {
		this.pro_q = pro_q;
	}
	public String getPro_a() {
		return pro_a;
	}
	public void setPro_a(String pro_a) {
		this.pro_a = pro_a;
	}
	public ProviderVo(int provider_no, String pro_name, String pro_nick, String pro_img, String phone, String email,
			String id, String pwd, String pro_q, String pro_a) {
		super();
		this.provider_no = provider_no;
		this.pro_name = pro_name;
		this.pro_nick = pro_nick;
		this.pro_img = pro_img;
		this.phone = phone;
		this.email = email;
		this.id = id;
		this.pwd = pwd;
		this.pro_q = pro_q;
		this.pro_a = pro_a;
	}
	public ProviderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
