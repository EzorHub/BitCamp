package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(PersonConfig.class, DaoConfig.class);
		
		Person person= (Person)context.getBean("person");
		person.info();		
		MemberDao member = (MemberDao)context.getBean("member");
		member.insert();
		BoardDao board = (BoardDao)context.getBean("board");
		board.insert();
	}
}
