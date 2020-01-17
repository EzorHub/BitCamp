package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import db.BookManager;
import vo.BookVo;

@Repository
public class BookDao {

	public List<BookVo> listAll(){		
		return BookManager.listAll();
	}
	
	public int updateBook(BookVo b) {
		return BookManager.update(b);
	}
	
	public int insertBook(BookVo b) {
		return BookManager.insert(b);
	}
	
	public BookVo getBook(int bookid){
		
		return BookManager.getBook(bookid);
	}
	
	public int deleteBook(int bookid) {
		return BookManager.delete(bookid);
	}
}
