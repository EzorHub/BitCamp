package com.ajaxTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajaxTest.dao.GoodsDao;
import com.ajaxTest.vo.GoodsVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BitController {
	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	 @ResponseBody
	 @RequestMapping("/listGoods.json")
	 public String listGoods() {
		 
		 String str = "";
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			 str = mapper.writeValueAsString(dao.listAll());
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 
		 System.out.println("JSON"+str);
		 return str;
	 }
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/listGoods.do") public String listGoods() { List<GoodsVo>
	 * list = dao.listAll(); String str = ""; int cnt = 1; str += "["; for (GoodsVo
	 * g : list) { int no = g.getNo(); String name = g.getName(); int price =
	 * g.getPrice(); int qty = g.getQty(); String fname = g.getFname(); str +=
	 * "{no:" + no + ", name:'" + name + "', price:" + price + ", qty:" + qty +
	 * ", fname:'" + fname + "'},"; if (cnt == list.size()) { str = str.substring(0,
	 * str.lastIndexOf(",")); } } str += "]"; System.out.println("str: "+str);
	 * 
	 * 
	 * String str = ""; str += "["; str +=
	 * "{no:1, name:'오뎅', price:2500, qty:1, fname:'od.jpg'},"; str +=
	 * "{no:2, name:'순대', price:3000, qty:1, fname:'sd.jpg'},"; str +=
	 * "{no:3, name:'떡볶이', price:3000, qty:1, fname:'tbbk.jpg'},"; str +=
	 * "{no:4, name:'강서맥주', price:4000, qty:1, fname:'gs.jpg'},"; str +=
	 * "{no:5, name:'진로백', price:3500, qty:1, fname:'soju.jpg'}"; str += "]";
	 * 
	 * 
	 * return str; }
	 */

	@ResponseBody
	@RequestMapping("/member.do")
	public String memeber() {
		String str = "{name:'tiger',age:20}";
		return str;// 객체로반환
	}

	@ResponseBody // 내가 반환하는게 응답할 내용이다
	@RequestMapping("/bit.do")
	public String bit() {

		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "hello, bit";
	}
}
