package ex_dept;

public class Dept {
	private int dno;
	private String dname;
	private String dloc;
	
	public void info() {
		System.out.println("�μ���ȣ: "+dno+"\n�μ���: "+dname+"\n�μ���ġ: "+dloc);
	}
	public Dept(int dno, String dname, String dloc) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dloc = dloc;
	}

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
