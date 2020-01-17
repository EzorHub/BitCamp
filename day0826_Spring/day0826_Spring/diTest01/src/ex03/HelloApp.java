package ex03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageBean ob = null;
		
		//xml�� �ִ� ��ü�� ���
		Resource resource = new FileSystemResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		ob = (MessageBean)factory.getBean("mb");
		
		ob.sayHello("Zoe");
		
	}

}
