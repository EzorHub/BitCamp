package com.bit.goods.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.goods.vo.GoodsVo;

public class DBManager {

	private static SqlSessionFactory factory;
	static {
		try {
		Reader reader
		= Resources.getResourceAsReader("com/bit/goods/db/dbConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<GoodsVo> listAll(){
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.listAll");
		session.close();
		return list;
	}
	
	public static GoodsVo getGoods(int no) {
		GoodsVo g = null;
		SqlSession session = factory.openSession();
		g = session.selectOne("goods.getGoods", no);
		session.close();
		return g;
	}

	public static int insertGoods(GoodsVo g) {
		// TODO Auto-generated method stub
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insertGoods", g);
		session.close();
		return re;
	}

	public static int getNextNo() {
		// TODO Auto-generated method stub
		int no = 0;
		SqlSession session = factory.openSession();
		no = session.selectOne("goods.getNextNo");
		session.close();
		return no;
	}
	
	public static void insertLog(String methodName, String call, long runTime) {
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put(methodName, "methodName");
		map.put(call, "call");
		map.put(runTime, "runTime");
		session.insert("log.insertLog");
	}
	
}
