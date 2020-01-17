package com.bit.dept.vo;

public class EmpVo {

	private int ENO;
	private String ENAME;
	private String ADDR;
	private int SAL;
	private int COMM;
	private String JOB;
	private String TEL;
	private int HIREDATE;
	private int MGR;
	private int DNO;
	public int getENO() {
		return ENO;
	}
	public void setENO(int eNO) {
		ENO = eNO;
	}
	public String getENAME() {
		return ENAME;
	}
	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}
	public String getADDR() {
		return ADDR;
	}
	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}
	public int getSAL() {
		return SAL;
	}
	public void setSAL(int sAL) {
		SAL = sAL;
	}
	public int getCOMM() {
		return COMM;
	}
	public void setCOMM(int cOMM) {
		COMM = cOMM;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public int getHIREDATE() {
		return HIREDATE;
	}
	public void setHIREDATE(int hIREDATE) {
		HIREDATE = hIREDATE;
	}
	public int getMGR() {
		return MGR;
	}
	public void setMGR(int mGR) {
		MGR = mGR;
	}
	public int getDNO() {
		return DNO;
	}
	public void setDNO(int dNO) {
		DNO = dNO;
	}
	public EmpVo(int eNO, String eNAME, String aDDR, int sAL, int cOMM, String jOB, String tEL, int hIREDATE, int mGR,
			int dNO) {
		super();
		ENO = eNO;
		ENAME = eNAME;
		ADDR = aDDR;
		SAL = sAL;
		COMM = cOMM;
		JOB = jOB;
		TEL = tEL;
		HIREDATE = hIREDATE;
		MGR = mGR;
		DNO = dNO;
	}
	public EmpVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
