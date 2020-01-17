package ex02;

public class Member {
	private String name;
	private int age;
	
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public void info() {
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
	}
	
}
