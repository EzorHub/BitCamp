package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex08/beans.xml");
		ProtocolHandler ph  = (ProtocolHandler)context.getBean("ph");
		ph.service();
	}

}
