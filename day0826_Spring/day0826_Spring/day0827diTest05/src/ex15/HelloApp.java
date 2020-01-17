package ex15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		ApplicationContext context
		= new AnnotationConfigApplicationContext(BitConfig.class); //클래스이름
//		MemberService ms = context.getBean("member1", MemberService.class); 
		MemberService ms = (MemberService)context.getBean("member1"); //메소드이름
		ms.update("hoit");
	}
}
