package ex16;

public class Person {

	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void info() {
		System.out.println(name+" , "+age);
	}
}