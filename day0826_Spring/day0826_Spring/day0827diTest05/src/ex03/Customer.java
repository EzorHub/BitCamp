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
		System.out.println("*** ������ ***");
		System.out.println("����ȣ: "+custid);
		System.out.println("�̸�: "+name);
		System.out.println("�ּ�: "+addr);
		System.out.println("��ȭ: "+phone);
	}
	
	
}
