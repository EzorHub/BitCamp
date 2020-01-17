package com.chat.vo;

public class BitMemberVo {

	private String id;
	private String email;
	private int pay;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public BitMemberVo(String id, String email, int pay) {
		super();
		this.id = id;
		this.email = email;
		this.pay = pay;
	}
	public BitMemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BitMemberVo [id=" + id + ", email=" + email + ", pay=" + pay + "]";
	}
	
	
}
