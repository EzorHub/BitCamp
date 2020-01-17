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
	/*�������� �� Ȯ�θ޽��� ����(��ũ��Ʈ)
	 * ������ ��ȣ�� �Է¹޾�(bitCamp)��ġ�ϸ� ����
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
		SqlSession session = factory.openSession(true);// boolean���� �־� ����Ŀ��? 0830**
		re = session.update("book.updateBook", b);
		
		session.close();

		return re;
	}

	public static int insert(BookVo b) {
		int re = -1;
		SqlSession session = factory.openSession(); 

		re = session.insert("book.insertBook", b);
		// db������ �ִ� ����� �����Ҷ���(���� ���� ����) - commit�������**
		session.commit();
		// -------------------------------------------
		session.close();
		return re;
	}

	public static BookVo getBook(int bookid) {
		HashMap map = new HashMap();
		map.put("bookid", bookid);// ""�� db �̸��� ���ƾ���
		BookVo b = null;
		SqlSession session = factory.openSession();
		b = session.selectOne("book.getBook", map); // �˻��� ����� vo�� �������ֹǷ� b�� ��ƾ���
		session.close();
		return b;
	}

	public static List<BookVo> listAll() {
		List<BookVo> list = null;
		// ���Ǿ��;���
		SqlSession session = factory.openSession();
		list = session.selectList("book.selectAll"); // "" �ڸ��� id�Է�
		session.close();
		return list;
	}

}
