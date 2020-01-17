package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	//�޼ҵ� ������� - listBoardAction ���� ��
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		//mav�� ���������� req.setAttribute();		
		mav.addObject("msg", "�ȳ��ϼ���!");
		mav.addObject("year", 2019);
		//mav.setViewName("/WEB-INF/Views/hello.jsp"); - viewReslover�� ���ٰ���
		mav.setViewName("hello");
		return mav;
	}
}
