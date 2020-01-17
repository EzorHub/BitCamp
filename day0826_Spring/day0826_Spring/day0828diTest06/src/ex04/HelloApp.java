package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		ApplicationContext context
		= new AnnotationConfigApplicationContext(BitConfig.class);
		SystemMonitor sm = (SystemMonitor)context.getBean("sm");
		sm.monitor();
	}
}
