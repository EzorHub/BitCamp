package com.bit.goodsTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.goodsTest.dao.GoodsDao;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDao dao;	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/listGood.do")
	public ModelAndView listAll() {
		System.out.println("컨트롤러 동작함!");
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}

}
