package ex09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex09/beans.xml");
		WriteArticleServiceImple ws = (WriteArticleServiceImple)context.getBean("ws");
		ws.insert();
	}
}
