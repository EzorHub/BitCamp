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
		System.out.println("�μ���ȣ: "+dno+"\n�μ���: "+dname+"\n�μ���ġ: "+dloc);
	}
	
	
}