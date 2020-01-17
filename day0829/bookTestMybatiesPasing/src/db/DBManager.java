package db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import vo.BookVo;

public class DBManager {

	public static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("db/dbConfig.xml"); //���Ǹ����غ� - ���Ͽ�����
			factory = new SqlSessionFactoryBuilder().build(reader); //���ǻ���
			reader.close(); //���ϻ���� ���̹Ƿ� �ݾ���
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<BookVo> listAll(HashMap map) {//������ �޼ҵ忡 �����ϱ�����
		// TODO Auto-generated method stub
		List<BookVo> list = null;
		SqlSession session = factory.openSession();//����!
		list = session.selectList("book.listAll", map); //map!!!!!!!!!!!!!!!!!!!!!!����
		return list;
	}
	public static int getCount(HashMap map) {
		int cnt = 0;
		SqlSession session = factory.openSession();
		cnt = session.selectOne("book.getCount", map);
		session.close();
		return cnt;
	}
	
}
