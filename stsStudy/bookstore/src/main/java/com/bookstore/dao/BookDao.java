package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookstore.db.DBManager;
import com.bookstore.vo.BookVo;


@Repository
public class BookDao {
	
	
	//-------------------------------------
	
	public List<BookVo> listPage(HashMap map){
		
		return DBManager.listPage(map);
	}
	
	public int getCount() {
		
		return DBManager.getCount();
	}
	
	//-------------------------------------
	
	
	public List<BookVo> listAll(int start, int end){
		System.out.println("dao: start, end; "+start+", "+end);
		return DBManager.listAll(start, end);
	}

	public int insertBook(BookVo b) {
		return DBManager.insertBook(b);
	}
	public int updateBook(BookVo b) {
		return DBManager.updateBook(b);
	}
	public int deleteBook(BookVo b) {
		return DBManager.deleteBook(b);
	}
	
	public List<BookVo> searchBook(String searchField, String searchString, String searchOper){
		return DBManager.searchBook(searchField, searchString, searchOper);
	}
}
