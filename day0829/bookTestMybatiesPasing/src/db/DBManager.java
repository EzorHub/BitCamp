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
			= Resources.getResourceAsReader("db/dbConfig.xml"); //세션만들준비 - 파일열어줌
			factory = new SqlSessionFactoryBuilder().build(reader); //세션생성
			reader.close(); //파일사용은 끝이므로 닫아줌
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<BookVo> listAll(HashMap map) {//각각의 메소드에 접근하기위함
		// TODO Auto-generated method stub
		List<BookVo> list = null;
		SqlSession session = factory.openSession();//접근!
		list = session.selectList("book.listAll", map); //map!!!!!!!!!!!!!!!!!!!!!!전달
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
