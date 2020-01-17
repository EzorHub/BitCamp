package ex14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//---------------------------------------------------------
		//객체생성되는 시점 - .xml 동작 
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex14/beans.xml");
		//---------------------------------------------------------		
		Person p1 = (Person)context.getBean("p");
		Person p2 = (Person)context.getBean("p");
		
		if(p1==p2) {
			System.out.println("같은 객체입니다.");
		}else {
			System.out.println("다른 객체입니다.");
		}
		p1.info();
		p2.info();
	}
}
