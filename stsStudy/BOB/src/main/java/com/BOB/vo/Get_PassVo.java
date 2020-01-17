package com.BOB.vo;

public class Get_PassVo {

	private int get_pass_no;
	private int total;
	private int cust_no;
	private int pass_no;
	public int getGet_pass_no() {
		return get_pass_no;
	}
	public void setGet_pass_no(int get_pass_no) {
		this.get_pass_no = get_pass_no;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public int getPass_no() {
		return pass_no;
	}
	public void setPass_no(int pass_no) {
		this.pass_no = pass_no;
	}
	public Get_PassVo(int get_pass_no, int total, int cust_no, int pass_no) {
		super();
		this.get_pass_no = get_pass_no;
		this.total = total;
		this.cust_no = cust_no;
		this.pass_no = pass_no;
	}
	public Get_PassVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
