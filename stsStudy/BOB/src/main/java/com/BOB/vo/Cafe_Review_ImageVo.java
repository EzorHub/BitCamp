package com.BOB.vo;

public class Cafe_Review_ImageVo {
	
	private int review_img_no;
	private String review_img;
	private int review_no;
	public int getReview_img_no() {
		return review_img_no;
	}
	public void setReview_img_no(int review_img_no) {
		this.review_img_no = review_img_no;
	}
	public String getReview_img() {
		return review_img;
	}
	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public Cafe_Review_ImageVo(int review_img_no, String review_img, int review_no) {
		super();
		this.review_img_no = review_img_no;
		this.review_img = review_img;
		this.review_no = review_no;
	}
	public Cafe_Review_ImageVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
