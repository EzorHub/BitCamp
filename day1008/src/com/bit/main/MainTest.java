package com.bit.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.BoardDao;
import com.bit.dao.MemberDao;
import com.bit.util.HelloUtil;


public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ApplicationContext context
		//= new ClassPathXmlApplicationContext("com/bit/main/beans.xml");
		= new AnnotationConfigApplicationContext(MainConfig.class);
		
		BoardDao boardDao= (BoardDao)context.getBean("boardDao");
		MemberDao memberDao= (MemberDao)context.getBean("memberDao");
		HelloUtil helloUtil = (HelloUtil)context.getBean("helloUtil");
		
		List<String> list = memberDao.listMember();
		for(String m : list) {
			System.out.println(m);
		}
		boardDao.insert();
		helloUtil.sayHello("¼ººó´Ô~!");

	}

}
