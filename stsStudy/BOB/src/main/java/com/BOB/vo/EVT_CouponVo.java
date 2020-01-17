package com.BOB.vo;

public class EVT_CouponVo {

	private int coupon_no;
	private String isused;
	private int evt_no;
	private int cust_no;
	public int getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
	}
	public String getIsused() {
		return isused;
	}
	public void setIsused(String isused) {
		this.isused = isused;
	}
	public int getEvt_no() {
		return evt_no;
	}
	public void setEvt_no(int evt_no) {
		this.evt_no = evt_no;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public EVT_CouponVo(int coupon_no, String isused, int evt_no, int cust_no) {
		super();
		this.coupon_no = coupon_no;
		this.isused = isused;
		this.evt_no = evt_no;
		this.cust_no = cust_no;
	}
	public EVT_CouponVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
