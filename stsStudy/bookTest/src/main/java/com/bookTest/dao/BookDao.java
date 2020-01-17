package com.bookTest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookTest.db.DBManager;
import com.bookTest.vo.BookVo;

@Repository
public class BookDao {

	public List<BookVo> listAll(){
		return DBManager.listAll();
	}

	public void insertBook(BookVo b) {
		// TODO Auto-generated method stub
		 DBManager.insertBook(b);
		
	}
}
