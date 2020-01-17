package ex10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex10/beans.xml");
		BookStore bs = (BookStore)context.getBean("bs");
		bs.pro();
	}
}
