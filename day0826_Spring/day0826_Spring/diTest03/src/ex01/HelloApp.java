package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*1. 오라클db를 이용하여 회원등록을 구현*/

public class HelloApp {

	public static void main(String[] args) {
		String configLocation = "ex01/beans.xml";
		ApplicationContext context
		= new ClassPathXmlApplicationContext(configLocation);
		
		MemberDao dao = (MemberDao)context.getBean("member");
		dao.insertMember();

	}

}
