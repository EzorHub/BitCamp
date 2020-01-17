package ex04;
//다음 오버로딩된 생성자중 어떤 생성자가 동작하는지 실험
public class JobExcutor {
	
	public JobExcutor(String name, int seconds) {
		System.out.println("생성자호출1");
	}
	public JobExcutor(String name, long miliseconds) {
		System.out.println("생성자호출2");
	}
	public JobExcutor(String name, String seconds) {
		System.out.println("생성자호출3");
	}
	
	public void pro() {
		System.out.println("JobExcutor의 pro입니다.");
	}
}
