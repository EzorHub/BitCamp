package com.ajaxTest.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.ajaxTest.vo.GoodsVo;

public class DBManager {

	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			=Resources.getResourceAsReader("com/ajaxTest/db/goodsConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public static List<GoodsVo> listAll() {
			List<GoodsVo> list = null;
			SqlSession session = factory.openSession();
			list = session.selectList("goods.listAll");
			session.close();
			return list;		
		
	}
}
