package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {

	private DeptDao dao;

	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value =  "/insertDept.do", method = RequestMethod.GET)
	public void insertForm() { // void해도됨 int 노상관
		
	}
//	@RequestMapping("/insertDeptConfirm.do")
	@RequestMapping(value =  "/insertDept.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(DeptVo d) {
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(d);
		if(re>0) {
			mav.setViewName("redirect:/listDept.do");//redirect:/요청이름.do
		}else {
			mav.addObject("msg", "부서등록에 실패했습니다.");
			mav.setViewName("error.jsp");
		}
		//mav.addObject(re, re);
		return mav;
	}

	@RequestMapping("/listDept.do")
	public ModelAndView mav() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}
	
	@RequestMapping("/getDept.do")	 
	public ModelAndView mav(int no) {	//-생략가능
	//public ModelAndView mav(@RequestParam("no")int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("d", dao.getDept(no));
		mav.setViewName("getDept");
		return mav;
	}

}
