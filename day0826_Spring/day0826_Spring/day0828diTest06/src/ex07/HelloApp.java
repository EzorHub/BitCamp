package ex07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(SystemConfig.class);
		
		//SystemMonitor sm = (SystemMonitor)context.getBean("sm");
		//따로 객체 생성하지않아도 config에 의해 init됨!
		
		//default - singleton
		SystemMonitor sm1 = (SystemMonitor)context.getBean("sm");
		SystemMonitor sm2 = (SystemMonitor)context.getBean("sm");
		
		if(sm1==sm2) {
			System.out.println("동일");	
		}else {
			System.out.println("비동비동");
		}
		
		
	}
}
