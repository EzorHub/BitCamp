package com.bookstore.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.dao.BookDao;
import com.bookstore.vo.BookVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BookController {

	@Autowired
	public BookDao bookdao;
	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}
	
	//-----------------------------------------
	@ResponseBody
	@RequestMapping("/getTotalBook")
	public String getTotalBookCount() {
		String str = "";
		try{
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(bookdao.getCount());			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	//-----------------------------------------
	@ResponseBody
	@RequestMapping("/editBooks")
	public String editBooks(String oper, BookVo b) {
		System.out.println("oper: "+oper);
		String r = "";
		switch(oper) {
			case"add":r=bookdao.insertBook(b)+"";break;
			case"edit":r=bookdao.updateBook(b)+"";break;
			case"del":r=bookdao.deleteBook(b)+"";break;
		}
		return r;
	}
	
	
	
	
	//jqgrid - p52
	@ResponseBody
	@RequestMapping("/getBooks")	
	public ModelAndView getBooks(int page, int rows, Boolean _search,
									String searchField, String searchString, String searchOper) { //크롬-개발자도구-네트워크에서 파람이름 알게됨
		System.out.println("page: "+page);
		System.out.println("rows: "+rows);	
		
		ModelAndView mav = new ModelAndView();
		int totalRecord = bookdao.getCount();
		int totalPage = (int)Math.ceil(totalRecord/(double)rows);
		int start = (page-1)*rows+1;
		int end = start +rows-1;
		List<BookVo> list = bookdao.listAll(start, end);
		if(_search) {
			System.out.println("searchField: "+searchField);
			System.out.println("searchString: "+searchString);
			System.out.println("searchOper: "+searchOper);
			list = bookdao.searchBook(searchField, searchString, searchOper);
		}
		System.out.println("controller: start, end; "+start+", "+end);
		System.out.println("bookdao.listAll: "+bookdao.listAll(start, end).toString());
		mav.addObject("list", list);
		mav.addObject("page", page); //현재페이지		
		mav.addObject("totalRecord", totalRecord); //전체레코드 수
		mav.addObject("totalPage", totalPage); //전체 페이지
		return mav;
	}
	
	//-----------------------------------------
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/listAllBook") public String list(int start, int end) {
	 * String str = ""; try { ObjectMapper mapper = new ObjectMapper(); str =
	 * mapper.writeValueAsString(bookdao.listAll(start, end)); }catch (Exception e)
	 * { e.printStackTrace(); } return str; }
	 */
	@RequestMapping("/index.do")
	public void index() {
	
	}
	//------------------------------------0930--------------------
	
	@RequestMapping("/textLightBox")
	public void light() {
		
	}
	@RequestMapping("/ex2")
	public void ex2() {
		
	}
	@RequestMapping("/ex3")
	public void ex3() {
		
	}

	
}
