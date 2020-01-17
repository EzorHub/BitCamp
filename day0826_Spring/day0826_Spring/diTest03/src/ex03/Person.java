package ex03;
//기본생성자 실험
public class Person {
	private String name;
	
	
	public Person(String name) {
		super();
		this.name = name;
		System.out.println("생성자 동작함");
		System.out.println(this.name);
	}
	public Person(){
		System.out.println("Person의 생성자 동작함");
	}
	public void pro() {
		System.out.println("Person의 pro입니다.");
	}
}
