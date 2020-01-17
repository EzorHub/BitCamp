package com.chat.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chat.dao.GoodsDao;
import com.chat.vo.Jumun;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GoodsController {
	
	@Autowired
	public GoodsDao dao;
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/goods.do")
	public void goods() {
		
	}
	@ResponseBody
	@RequestMapping("/getTotalProduct")
	public String getTotalProductionCount() {
		String str = "";
		try{
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(dao.goodsCount());			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	@ResponseBody
	@RequestMapping("/getPagingProductList")
	public String getPagingProductList(int nowPage,int perPage) { //한 화면에 보여지는 레코드 수
		/*시작레코드, 마지막레코드
		 * sql뽑는 것
		 * */		
		String str = "";
		//------------------------------
		int start = (nowPage-1)*perPage+1;
		int end = start+perPage-1;
		//------------------------------
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		try {
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("1");
			str = mapper.writeValueAsString(dao.listPage(map));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
		
	}
	

	/*ajax통신으로*/
	@ResponseBody
	@RequestMapping("/getProductList")
	public String listGoods() {
		String str = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(dao.listGoods());
		}catch (Exception e) {			
			e.printStackTrace();
		}
		return str;
	}
	
	
	//-----------------0926------------------
	@ResponseBody  
    @RequestMapping(value = "/insertJumun", method = RequestMethod.POST)
    public String insertJumun(Jumun jumun)
    {   
        System.out.println(jumun.getCustid());
        System.out.println(jumun.getJumunList().size());
         
        String str = "0";
        str = dao.insertJumun(jumun)+"";
        return str;         
    }
	
	//-----------------0930------------------	
	@RequestMapping("/ex2")
	public void ex2() {
		
	}
	@RequestMapping("/ex3")
	public void ex3() {
		
	}

}
