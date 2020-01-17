package com.BOB.vo;

public class RestaurantVo {
	private int rest_no;
	private String rest_name;
	private String rest_loc;
	private int man_no;
	public int getRest_no() {
		return rest_no;
	}
	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public String getRest_loc() {
		return rest_loc;
	}
	public void setRest_loc(String rest_loc) {
		this.rest_loc = rest_loc;
	}
	public int getMan_no() {
		return man_no;
	}
	public void setMan_no(int man_no) {
		this.man_no = man_no;
	}
	public RestaurantVo(int rest_no, String rest_name, String rest_loc, int man_no) {
		super();
		this.rest_no = rest_no;
		this.rest_name = rest_name;
		this.rest_loc = rest_loc;
		this.man_no = man_no;
	}
	public RestaurantVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
