package ex14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//---------------------------------------------------------
		//��ü�����Ǵ� ���� - .xml ���� 
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex14/beans.xml");
		//---------------------------------------------------------		
		Person p1 = (Person)context.getBean("p");
		Person p2 = (Person)context.getBean("p");
		
		if(p1==p2) {
			System.out.println("���� ��ü�Դϴ�.");
		}else {
			System.out.println("�ٸ� ��ü�Դϴ�.");
		}
		p1.info();
		p2.info();
	}
}
