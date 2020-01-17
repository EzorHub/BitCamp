package com.bit.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.BoardDao;
import com.bit.dao.MemberDao;
import com.bit.util.HelloUtil;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/bit/main/beans.xml");
		
		BoardDao boardDao= (BoardDao)context.getBean("boardDao");
		MemberDao memberDao= (MemberDao)context.getBean("memberDao");
		HelloUtil helloUtil = (HelloUtil)context.getBean("helloUtil");
		
		List<String> list = memberDao.listMember();
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(0));
		}
		boardDao.insert();
		helloUtil.sayHello("¼ººó´Ô~!");
		
		
	}

}
