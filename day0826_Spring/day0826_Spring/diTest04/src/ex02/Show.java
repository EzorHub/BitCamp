package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Show {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ApplicationContext context 
		= new ClassPathXmlApplicationContext("ex02/dept.beans.xml");
		Dept d = (Dept)context.getBean("d");
		d.info();
	}

}
