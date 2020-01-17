package com.chat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chat.db.DBManager;
import com.chat.vo.ChatVo;

@Repository
public class ChatDao {

	/*
	 * public List<ChatVo> listAll(){ return DBManager.listAll(); }
	 */
	
	public int insertChat(ChatVo c) {
		return DBManager.insertChat(c);
	}
}
