package ex16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		ApplicationContext context
		= new AnnotationConfigApplicationContext(BitConfig.class); //clsName
		Person p = (Person)context.getBean("p1");		
		
		p.info();
	}
}
