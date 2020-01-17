package com.bookTest.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bookTest.vo.BookVo;
import com.bookTest.vo.CustomerVo;

public class DBManager {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			=Resources.getResourceAsReader("com/bookTest/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static List<BookVo> listAll() {
		List<BookVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("book.listAll");
		System.out.println("데이터수: "+list.size());
		return list;
	}
	
	public static List<CustomerVo> listbuyer(int bookid){
		List<CustomerVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("book.listBuyer", bookid);
		
		return list;
	}

	public static void insertBook(BookVo b) {
		// crud == commit필수
//		SqlSession session = factory.openSession(true);
		SqlSession session = factory.openSession();
		session.insert("book.insert",b);
		session.commit();
		session.close();		
	}

}
