package ex12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex12/beans.xml");
		SystemMonitor sm  = (SystemMonitor)context.getBean("sm");
		sm.monitor();
	}

}
