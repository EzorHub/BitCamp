package ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex06/beans.xml");
		BookStore bs = (BookStore)context.getBean("bs");
		bs.pro();
	}
}
