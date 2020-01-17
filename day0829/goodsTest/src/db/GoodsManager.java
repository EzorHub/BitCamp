package db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.GoodsVo;

public class GoodsManager {

	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("db/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public static int insertGoods(GoodsVo g) {
		int re =-1;
		SqlSession session = factory.openSession();
		re = session.insert("goods.insertGoods", g);
		session.commit();
		session.close();
		
		return re;
	}
	
	public static GoodsVo detailGoods(int no) {
		HashMap map = new HashMap();
		map.put("no", no);
		GoodsVo g = null;
		SqlSession session = factory.openSession();
		g = session.selectOne("goods.detailGoods", map);
		session.close();
		return g;
	}
	
	public static int updateGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.update("goods.updateGoods", g);
		session.commit();
		session.close();				
		return re;
	}
	
	public static int deleteGoods(int no) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.delete("goods.deleteGoods", no);
		session.commit();
		session.close();
		return re;
	}

	public static List<GoodsVo> listAll() {
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.listAll");
		session.close();		
		return list;
	}
	public static List<GoodsVo> search(HashMap map) {
		// TODO Auto-generated method stub
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();		
		//map.put("column", "price");
		list = session.selectList("goods.listAll", map);		
		session.close();
		return list;
	}

	public static int getCount(HashMap map) {
		// TODO Auto-generated method stub
		int cnt =0;
		SqlSession session = factory.openSession();
		cnt = session.selectOne("goods.getCount", map);
		session.close();
		return cnt;
	}

//	 getNextNo 처리해보기
//	public static int getNextNo() {
//		// 
//		return null;
//	}
	
}
