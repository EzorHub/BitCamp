package com.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ParkController {
	
	@RequestMapping("/park.do")
	public void park() {
		
	}
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/GetParkInfo.json") public String getTotalProductionCount()
	 * { String str = ""; try{ ObjectMapper mapper = new ObjectMapper(); str =
	 * mapper.writeValueAsString();
	 * 
	 * }catch (Exception e) { e.printStackTrace(); } return str; }
	 */

}
