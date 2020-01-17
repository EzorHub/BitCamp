package com.BOB.vo;

public class STD_PickersVo {
	private int pickers_no;
	private int std_no;
	private int cust_no;
	public int getPickers_no() {
		return pickers_no;
	}
	public void setPickers_no(int pickers_no) {
		this.pickers_no = pickers_no;
	}
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public STD_PickersVo(int pickers_no, int std_no, int cust_no) {
		super();
		this.pickers_no = pickers_no;
		this.std_no = std_no;
		this.cust_no = cust_no;
	}
	public STD_PickersVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
