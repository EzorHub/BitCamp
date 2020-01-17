package com.BOB.vo;

public class ManagerVo {

	private int man_no;
	private String id;
	private String pwd;
	public int getMan_no() {
		return man_no;
	}
	public void setMan_no(int man_no) {
		this.man_no = man_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public ManagerVo(int man_no, String id, String pwd) {
		super();
		this.man_no = man_no;
		this.id = id;
		this.pwd = pwd;
	}
	public ManagerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
