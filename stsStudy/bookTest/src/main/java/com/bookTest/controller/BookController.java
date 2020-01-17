package com.bookTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookTest.dao.BookDao;
import com.bookTest.dao.CustomerDao;
import com.bookTest.vo.BookVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BookController {

	@Autowired
	public BookDao dao;
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	@Autowired
	public CustomerDao custDao;
	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}
	

	@RequestMapping("/index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();		
		return mav;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertBook.do", method = RequestMethod.POST)
	public String insertBook(BookVo b) {
		System.out.println("와라라라라");
		System.out.println("등록"+b);
		dao.insertBook(b);
		
		
		return "ok";
		
	}
	
	
	@ResponseBody //에이작
	@RequestMapping("/listBook.json")
	public String listBook() {
		System.out.println("컨트롤러 요청됨");
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(dao.listAll());
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("json: "+str);
		return str;
	}
	
	@ResponseBody
	@RequestMapping
	public String listBuyer(int bookid) {
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(custDao.listBuyer(bookid));
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("cust_json: "+str);
		return str;
		
	}
	
}
