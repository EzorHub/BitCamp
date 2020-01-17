package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import db.DBManager;
import vo.BookVo;

@Repository
public class BookDao {

	

	public List<BookVo> listAll(HashMap map) {
		// TODO Auto-generated method stub
		return DBManager.listAll(map);	
	}
	public int getCount(HashMap map) {
		return DBManager.getCount(map);
	}
}
