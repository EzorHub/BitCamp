package com.BOB.vo;

public class PassVo {

	private int pass_no;
	private String pass_content;
	private int price;
	private int cafe_no;
	public int getPass_no() {
		return pass_no;
	}
	public void setPass_no(int pass_no) {
		this.pass_no = pass_no;
	}
	public String getPass_content() {
		return pass_content;
	}
	public void setPass_content(String pass_content) {
		this.pass_content = pass_content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public PassVo(int pass_no, String pass_content, int price, int cafe_no) {
		super();
		this.pass_no = pass_no;
		this.pass_content = pass_content;
		this.price = price;
		this.cafe_no = cafe_no;
	}
	public PassVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
