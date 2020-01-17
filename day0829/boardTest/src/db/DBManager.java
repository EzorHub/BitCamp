package db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.BoardVo;

public class DBManager {

	private static SqlSessionFactory factory; // mybaties에 접근하기위함
	static { // 어플리케이션 가동과 동시에!
		try {
			Reader reader // mybaties 파일을 읽어들여서,,,,,
					= Resources.getResourceAsReader("db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader); // factory객체 생성
			reader.close(); // reader사용끝
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<BoardVo> listAll() {
		// TODO Auto-generated method stub
		List<BoardVo> list = null;
		SqlSession session = factory.openSession(); // mybaties에 접근하기 위함
		list = session.selectList("board.selectAll"); // session을 통해 CRUD 오퍼레이션 결과를 list에 담아줌
		session.close(); // 사용끝
		return list;
	}

	public static int insertBoard(BoardVo b) {
		int re = -1;
		String msg = "";
		SqlSession session = factory.openSession(true);
		re = session.insert("board.insertBoard", b);
		session.close();
		return re;
	}

	public static int getNextNo() { // 답글준비!
		SqlSession session = factory.openSession();
		int no = session.selectOne("board.nextNo");
		session.close();
		return no;
	}

	public static BoardVo detailBoard(int no) {
		BoardVo b = null;
		SqlSession session = factory.openSession();
		b = session.selectOne("board.detailBoard", no);// ******매개변수********
		return b;
	}

	public static void updateStep(int b_ref, int b_step) {
		// TODO Auto-generated method stub

		HashMap map = new HashMap();
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);
		SqlSession session = factory.openSession(true);
		session.update("board.updateStep", map);
		session.close();
	}

	public static int updateBoard(BoardVo b) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("board.updateBoard", b);
		session.close();
		return re;
	}

	public static int deleteBoard(int no, String pwd) {
		int re = -1;		
		SqlSession session = factory.openSession(true);
		HashMap map = new HashMap();
		map.put("no", no);
		map.put("pwd", pwd);
		re = session.delete("board.deleteBoard", map);
		session.close();
		return re;
	}

	public static List<BoardVo> searchBoard(HashMap map) {
		List<BoardVo> list = null;		
		SqlSession session = factory.openSession();		
		list = session.selectList("board.search", map);
		session.close();
		return list;
	}
}
