package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex01/beans.xml");
		

		WriteArticleServiceImple wa 
		= (WriteArticleServiceImple)context.getBean("wa");
		wa.insert();
	}

}
