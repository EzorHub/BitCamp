package com.BOB.vo;

public class Cafe_ImgVo {

	private int cafe_img_no;
	private String cafe_img_name;
	private int cafe_no;
	public int getCafe_img_no() {
		return cafe_img_no;
	}
	public void setCafe_img_no(int cafe_img_no) {
		this.cafe_img_no = cafe_img_no;
	}
	public String getCafe_img_name() {
		return cafe_img_name;
	}
	public void setCafe_img_name(String cafe_img_name) {
		this.cafe_img_name = cafe_img_name;
	}
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public Cafe_ImgVo(int cafe_img_no, String cafe_img_name, int cafe_no) {
		super();
		this.cafe_img_no = cafe_img_no;
		this.cafe_img_name = cafe_img_name;
		this.cafe_no = cafe_no;
	}
	public Cafe_ImgVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
