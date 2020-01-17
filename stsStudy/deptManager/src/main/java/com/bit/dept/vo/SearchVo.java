package com.bit.dept.vo;

import java.util.Date;

public class SearchVo {

	private int eno;
	private String ename;
	private String dname;
	private String dloc;
	private int income;
	private Date hiredate;
	private int m; //근속개월

	
	public SearchVo(int eno, String ename, String dname, String dloc, int income, Date hiredate, int m) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dname = dname;
		this.dloc = dloc;
		this.income = income;
		this.hiredate = hiredate;
		this.m = m;
	}


	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getDloc() {
		return dloc;
	}


	public void setDloc(String dloc) {
		this.dloc = dloc;
	}


	public int getIncome() {
		return income;
	}


	public void setIncome(int income) {
		this.income = income;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public SearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
