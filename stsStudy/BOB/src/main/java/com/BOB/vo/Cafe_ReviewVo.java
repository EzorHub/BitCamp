package com.BOB.vo;

public class Cafe_ReviewVo {

	private int review_no;
	private String review_content;
	private int grade;
	private int cafe_no;
	private int cust_no;
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public Cafe_ReviewVo(int review_no, String review_content, int grade, int cafe_no, int cust_no) {
		super();
		this.review_no = review_no;
		this.review_content = review_content;
		this.grade = grade;
		this.cafe_no = cafe_no;
		this.cust_no = cust_no;
	}
	public Cafe_ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
