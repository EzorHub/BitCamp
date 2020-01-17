package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex02/beans.xml");
		MemberService ms = (MemberService)context.getBean("ms");
		ms.service();
	}

}
