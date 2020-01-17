package ex02;

public class Dept {
	private int dno;
	private String dname;
	private String dloc;
	
	
	
	public void setDno(int dno) {
		this.dno = dno;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}



	public void setDloc(String dloc) {
		this.dloc = dloc;
	}



	public void info() {
		System.out.println("부서번호: "+dno+"\n부서명: "+dname+"\n부서위치: "+dloc);
	}
	
	
}
