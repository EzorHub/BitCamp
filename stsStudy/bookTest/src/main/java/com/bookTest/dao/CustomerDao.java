package com.bookTest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookTest.db.DBManager;
import com.bookTest.vo.CustomerVo;

@Repository
public class CustomerDao {
	
	public List<CustomerVo> listBuyer(int bookid){
		return DBManager.listbuyer(bookid);
	}

}
