package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(BitConfig.class);
		MemberService ms = (MemberService)context.getBean("ms");
		ms.service();
	}
	
}
