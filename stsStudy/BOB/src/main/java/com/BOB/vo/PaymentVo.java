package com.BOB.vo;

public class PaymentVo {

	private int pay_no;
	private String pay_name;
	private int reser_no;
	private int get_pass_no;
	private String coupon_no;
	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}
	public String getPay_name() {
		return pay_name;
	}
	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}
	public int getReser_no() {
		return reser_no;
	}
	public void setReser_no(int reser_no) {
		this.reser_no = reser_no;
	}
	public int getGet_pass_no() {
		return get_pass_no;
	}
	public void setGet_pass_no(int get_pass_no) {
		this.get_pass_no = get_pass_no;
	}
	public String getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(String coupon_no) {
		this.coupon_no = coupon_no;
	}
	public PaymentVo(int pay_no, String pay_name, int reser_no, int get_pass_no, String coupon_no) {
		super();
		this.pay_no = pay_no;
		this.pay_name = pay_name;
		this.reser_no = reser_no;
		this.get_pass_no = get_pass_no;
		this.coupon_no = coupon_no;
	}
	public PaymentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
