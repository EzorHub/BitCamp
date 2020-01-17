package com.chat.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.chat.db.DBManager;
import com.chat.vo.BitMemberVo;

@Repository
public class BitMemberDao {
	
	
	public List<BitMemberVo> listAll(){
		return DBManager.listAll();
	}

}
