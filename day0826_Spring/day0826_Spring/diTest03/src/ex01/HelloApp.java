package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*1. ����Ŭdb�� �̿��Ͽ� ȸ������� ����*/

public class HelloApp {

	public static void main(String[] args) {
		String configLocation = "ex01/beans.xml";
		ApplicationContext context
		= new ClassPathXmlApplicationContext(configLocation);
		
		MemberDao dao = (MemberDao)context.getBean("member");
		dao.insertMember();

	}

}
