package ex02;
//생성자 동작 실험
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p = null;
		System.out.println("1");
		ApplicationContext context
		= new ClassPathXmlApplicationContext("ex02/beans02.xml");
		System.out.println("2");		
		p = (Person)context.getBean("p");
		System.out.println("3");
		p.pro();
		System.out.println("4");
	}

}
