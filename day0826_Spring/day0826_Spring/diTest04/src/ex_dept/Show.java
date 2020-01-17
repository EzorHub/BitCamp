package ex_dept;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Show {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ApplicationContext context 
		= new ClassPathXmlApplicationContext("ex_dept/dept.beans.xml");
		Dept dept = (Dept)context.getBean("dept");
		dept.info();
	}

}
