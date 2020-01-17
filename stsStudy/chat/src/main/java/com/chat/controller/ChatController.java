package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chat.dao.ChatDao;
import com.chat.vo.ChatVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ChatController {
	@Autowired
	private ChatDao dao;
	public void setDao(ChatDao dao) {
		this.dao = dao;
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/getList", method = RequestMethod.POST) public
	 * String listChat() { String str = ""; try { ObjectMapper mapper = new
	 * ObjectMapper(); str = mapper.writeValueAsString(dao.listAll());
	 * 
	 * }catch (Exception e) { e.printStackTrace(); } return str;
	 * 
	 * }
	 */
	@ResponseBody
	@RequestMapping(value = "/addMsg", method = RequestMethod.POST)
	public String insertChat(ChatVo c) {
		String str = "";
		int re = dao.insertChat(c);
		str += re;
		return str;
		
	}
	

}
