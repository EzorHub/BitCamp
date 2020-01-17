package db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.DeptVo;

public class DeptManager {
	private static SqlSessionFactory factory;
	static {
		try {
			
			Reader reader
			= Resources.getResourceAsReader("db/a.xml"); //환경설정파일명위치 전달 - sql명령어들을 담고있음
			//그 환경파일 요청 - 세션으로 받아옴
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close(); //reader할일 끝
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<DeptVo> listAll(){ //list에 담아올거야
		List<DeptVo> list = null;
		//sql세션을 얻어오려면 팩토리를 통해 얻어와야함
		SqlSession session = factory.openSession(); 
		list = session.selectList("dept.selectAll");
		session.close();
		return list;
	}
}
