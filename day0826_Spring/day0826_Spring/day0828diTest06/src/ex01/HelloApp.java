package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		//= new ClassPathXmlApplicationContext("ex01/beans.xml"); - xmló��
		= new AnnotationConfigApplicationContext(SpringConfig.class); //annotationó��
		MemberService ms = (MemberService)context.getBean("ms");
		ms.update("ododong");
	}

}
