package ex03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageBean ob = null;
		
		//xml�� �ִ� ��ü�� ��� - applicationContext ���ֻ��!
		String configLocation = "ex03/beans.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		ob = (MessageBean)context.getBean("mb");
			
		ob.sayHello("Zoe");
		
	}

}
