package ex07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(SystemConfig.class);
		
		//SystemMonitor sm = (SystemMonitor)context.getBean("sm");
		//���� ��ü ���������ʾƵ� config�� ���� init��!
		
		//default - singleton
		SystemMonitor sm1 = (SystemMonitor)context.getBean("sm");
		SystemMonitor sm2 = (SystemMonitor)context.getBean("sm");
		
		if(sm1==sm2) {
			System.out.println("����");	
		}else {
			System.out.println("�񵿺�");
		}
		
		
	}
}
