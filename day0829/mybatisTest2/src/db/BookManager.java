package db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.BookVo;

public class BookManager {
	/*도서삭제 전 확인메시지 띄우기(스크립트)
	 * 관리자 암호를 입력받아(bitCamp)일치하면 삭제
	 * */

	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("db/a.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int delete(int bookid) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.delete("book.deleteBook", bookid);
		session.commit();
		session.close();
		return re;
	}

	public static int update(BookVo b) {
		int re = -1;
		SqlSession session = factory.openSession(true);// boolean값을 주어 오토커밋? 0830**
		re = session.update("book.updateBook", b);
		
		session.close();

		return re;
	}

	public static int insert(BookVo b) {
		int re = -1;
		SqlSession session = factory.openSession(); 

		re = session.insert("book.insertBook", b);
		// db변동이 있는 명령을 실행할때는(삭제 수정 삽입) - commit해줘야함**
		session.commit();
		// -------------------------------------------
		session.close();
		return re;
	}

	public static BookVo getBook(int bookid) {
		HashMap map = new HashMap();
		map.put("bookid", bookid);// ""는 db 이름과 같아야함
		BookVo b = null;
		SqlSession session = factory.openSession();
		b = session.selectOne("book.getBook", map); // 검색할 결과를 vo로 포장해주므로 b에 담아야함
		session.close();
		return b;
	}

	public static List<BookVo> listAll() {
		List<BookVo> list = null;
		// 세션얻어와야함
		SqlSession session = factory.openSession();
		list = session.selectList("book.selectAll"); // "" 자리에 id입력
		session.close();
		return list;
	}

}
