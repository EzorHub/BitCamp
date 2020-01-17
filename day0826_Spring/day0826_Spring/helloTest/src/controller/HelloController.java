package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	//메소드 만들거임 - listBoardAction 같은 것
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		//mav에 상태유지함 req.setAttribute();		
		mav.addObject("msg", "안녕하세요!");
		mav.addObject("year", 2019);
		//mav.setViewName("/WEB-INF/Views/hello.jsp"); - viewReslover가 해줄거임
		mav.setViewName("hello");
		return mav;
	}
}
