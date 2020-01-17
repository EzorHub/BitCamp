package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chat.dao.GoodsDao;
import com.chat.dao.ScheduleDao;
import com.chat.vo.ScheduleVo;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class IndexController {
	
	
	
	//---------------2019/09/25-----------------------
	
	/*
	 * @RequestMapping("/ex2") public void ex2() {
	 * 
	 * }
	 */ /*
		 * @RequestMapping("/ex3") public void ex3() {
		 * 
		 * }
		 */
		@RequestMapping("/ex4")
		public void ex4() {
			
		}
		@RequestMapping("/ex5")
		public void ex5() {
			
		}
		@Autowired
		private GoodsDao gdao;
		public void setGdao(GoodsDao gdao) {
			this.gdao = gdao;
		}
		
		@ResponseBody
		@RequestMapping("/goodsInfo")
		public String goodsInfo() {
			String str = "";
			try {
				ObjectMapper mapper = new ObjectMapper();
				str = mapper.writeValueAsString(gdao.goodsInfo());
			}catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	//-------------------------------------------------
	
	
	
	
	
	//----------------2019/09/24------------------------
	@Autowired
	private ScheduleDao sdao;
	public void setSdao(ScheduleDao sdao) {
		this.sdao = sdao;
	}
	@RequestMapping("/ex01")
	public void ex1() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertSchedule", method = RequestMethod.POST)	
	public String insert(ScheduleVo s) {
		String str = "";
		int re = sdao.insert(s);
		
		return str;
	}
	@ResponseBody
	@RequestMapping("/listSchedule")
	public String list() {
		String str = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(sdao.listAll());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	
	
	//-----------------------------------------------
	@RequestMapping("/index.do")
	public void index() {
		
	}
	
	
	
	
	
}
