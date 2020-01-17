package com.bit.goods.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.goods.dao.GoodsDao;
import com.bit.goods.vo.GoodsVo;

@Controller
@Component
public class GoodsController {

	@Autowired
	private GoodsDao dao;
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listGoods.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}
	
	@RequestMapping("/getGoods.do")
	public ModelAndView get(int no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
//		try {
//			GoodsVo vo = dao.getGoods(no);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		mav.addObject("g", dao.getGoods(no));
		return mav;
		
	}
	
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public ModelAndView insertForm() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(GoodsVo g, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		int no = dao.getNextNo();
		g.setNo(no);
		System.out.println("no 받았니?: "+no);
		int re = -1;
		//------------------------------------------
		String path = request.getRealPath("img");
		try {
		MultipartFile file = g.getUpload();
		String fname = file.getOriginalFilename();
		g.setFname(fname);
		
		byte []data = file.getBytes();
		FileOutputStream fos = new FileOutputStream(path+"/"+fname);
		fos.write(data);
		fos.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		//------------------------------------------
		
		String msg = "";
		
		System.out.println("---------vo정보------------");
		System.out.println(g.getNo());
		System.out.println(g.getName());
		System.out.println(g.getPrice());		
		System.out.println("----------------------------");
		re = dao.insertGoods(g);
		if(re != 1) {
			msg = "상품등록에 실패했습니다.";
		}else {
			msg = "상품등록에 성공했습니다.";
		}
		session.setAttribute("msg", msg);
		
		return mav;
	}
	
}
