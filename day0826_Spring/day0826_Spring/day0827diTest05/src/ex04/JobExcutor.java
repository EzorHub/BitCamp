package ex04;
//���� �����ε��� �������� � �����ڰ� �����ϴ��� ����
public class JobExcutor {
	
	public JobExcutor(String name, int seconds) {
		System.out.println("������ȣ��1");
	}
	public JobExcutor(String name, long miliseconds) {
		System.out.println("������ȣ��2");
	}
	public JobExcutor(String name, String seconds) {
		System.out.println("������ȣ��3");
	}
	
	public void pro() {
		System.out.println("JobExcutor�� pro�Դϴ�.");
	}
}
