package ex03;

public class MemberService {

	private String name;
	private int age;
	private MemberDao dao;
	
	
	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberService(String name, int age, MemberDao dao) {
		super();
		this.name = name;
		this.age = age;
		this.dao = dao;
	}
	
	public void service() {
		System.out.println("�̸�: "+name);
		System.out.println("����: "+age);
		dao.info();
	}
}
