package ex10;

public class Customer {
	private int custid;
	private String name;
	private String addr;
	private String phone;
	
	
	
	public void setCustid(int custid) {
		this.custid = custid;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public void setPhone(String phone) {
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
