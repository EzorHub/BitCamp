package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {
	@Autowired
	private DeptDao dao;
	
	
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}



	@RequestMapping("/listDept.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<DeptVo> list = dao.listAll();
		System.out.println("데이터 수: "+list.size());
		mav.addObject("list", list);
		return mav;
	}

}
