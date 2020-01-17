package com.bit.dept.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.dept.vo.SearchVo;

public class DBManager {

	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("com/bit/dept/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<SearchVo> searchList(String name){
		List<SearchVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("emp.searchEmp", name);
		session.close();
		return list;
	}
}
