package com.bit.goods.controller;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bit.goods.dao.GoodsDao;
import com.bit.goods.vo.MemberVo;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDao dao;
	
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	
	@RequestMapping("/insertMember.do")
	public void insertMember(  MultipartHttpServletRequest request)
	{
		Map<String, MultipartFile> map = request.getFileMap();
		
		System.out.println("이름:" + request.getParameter("name"));		
		
		String path = request.getRealPath("data");
		System.out.println("path:"+path);
		
		
		if(map != null)
		{
			System.out.println(map.size());
			Iterator<String> keys = map.keySet().iterator();
			while(keys.hasNext())
			{
				String key = keys.next();
				MultipartFile mf = map.get(key);
				String fname  = mf.getOriginalFilename();
				try {
					byte data[]=mf.getBytes();
					FileOutputStream fos = new FileOutputStream(path + "/"+fname);
					fos.write(data);
					fos.close();
					System.out.println(fname + "파일업로드 완료");
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
			
		}
		else
		{
			System.out.println("file empty");
		}
		
		
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public String insert(String name)
	{
		System.out.println("이름:"+name);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public String insertGet(String name)
	{
		System.out.println("이름:"+name);
		return "ok";
	}
	
	

	@RequestMapping("/listGoods.do")
	public ModelAndView list()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}
}






