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

	private static SqlSessionFactory factory; // mybaties�� �����ϱ�����
	static { // ���ø����̼� ������ ���ÿ�!
		try {
			Reader reader // mybaties ������ �о�鿩��,,,,,
					= Resources.getResourceAsReader("db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader); // factory��ü ����
			reader.close(); // reader��볡
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<BoardVo> listAll() {
		// TODO Auto-generated method stub
		List<BoardVo> list = null;
		SqlSession session = factory.openSession(); // mybaties�� �����ϱ� ����
		list = session.selectList("board.selectAll"); // session�� ���� CRUD ���۷��̼� ����� list�� �����
		session.close(); // ��볡
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

	public static int getNextNo() { // ����غ�!
		SqlSession session = factory.openSession();
		int no = session.selectOne("board.nextNo");
		session.close();
		return no;
	}

	public static BoardVo detailBoard(int no) {
		BoardVo b = null;
		SqlSession session = factory.openSession();
		b = session.selectOne("board.detailBoard", no);// ******�Ű�����********
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
