package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex04/beans.xml");
		JobExcutor je = (JobExcutor)context.getBean("je");
		je.pro();
	}

}
