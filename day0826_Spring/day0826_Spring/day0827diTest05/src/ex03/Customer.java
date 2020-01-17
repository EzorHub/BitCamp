package ex03;

public class Customer {
	private int custid;
	private String name;
	private String addr;
	private String phone;
	
	public Customer(int custid, String name, String addr, String phone) {
		super();
		this.custid = custid;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	public void info() {
		System.out.println("*** 고객정보 ***");
		System.out.println("고객번호: "+custid);
		System.out.println("이름: "+name);
		System.out.println("주소: "+addr);
		System.out.println("전화: "+phone);
	}
	
	
}
