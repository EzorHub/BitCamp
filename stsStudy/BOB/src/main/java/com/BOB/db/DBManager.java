package com.BOB.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.BOB.vo.ProviderVo;

public class DBManager {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("com/BOB/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession openSession() {
		SqlSession session = null;
		session = factory.openSession();
		return session;
				
	}
	public static List<ProviderVo> listProvider(){
		List<ProviderVo> list = null;
		list = openSession().selectList("provider.listProvider");
		return list;
	}

}
