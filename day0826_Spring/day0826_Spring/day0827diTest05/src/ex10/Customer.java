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
		System.out.println("*** ������ ***");
		System.out.println("����ȣ: "+custid);
		System.out.println("�̸�: "+name);
		System.out.println("�ּ�: "+addr);
		System.out.println("��ȭ: "+phone);
	}
	
	
}
