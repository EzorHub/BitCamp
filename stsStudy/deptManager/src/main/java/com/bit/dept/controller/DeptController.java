package com.bit.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dept.dao.EmpDao;

@Controller
public class DeptController {

	@Autowired
	private EmpDao dao;
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/searchEmp.do", method = RequestMethod.GET)
	public ModelAndView searchForm() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	@RequestMapping(value = "/searchEmp.do", method = RequestMethod.POST)
	public ModelAndView searchSubmit(@RequestParam(value = "name", defaultValue = "") String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.searchEmp(name));
		return mav;
	}
}
