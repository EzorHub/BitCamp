package com.chat.vo;

import java.util.ArrayList;
import java.util.Date;

public class JumunVo {
	private int no;
	private String custid;
	private int total;
	private Date order_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public JumunVo(int no, String custid, int total, Date order_date) {
		super();
		this.no = no;
		this.custid = custid;
		this.total = total;
		this.order_date = order_date;
	}
	public JumunVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
