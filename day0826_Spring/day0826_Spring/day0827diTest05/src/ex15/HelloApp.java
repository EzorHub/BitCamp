package ex15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		ApplicationContext context
		= new AnnotationConfigApplicationContext(BitConfig.class); //Ŭ�����̸�
//		MemberService ms = context.getBean("member1", MemberService.class); 
		MemberService ms = (MemberService)context.getBean("member1"); //�޼ҵ��̸�
		ms.update("hoit");
	}
}
