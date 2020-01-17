package controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;
import vo.BoardVo;

@Controller
public class BoardController {
	private BoardDao dao;	
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/insertBoard.do")
	public ModelAndView insertBoard(BoardVo b) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("re", dao.insertBoard(b));
		mav.setViewName("insertBoard");
		return mav;
	}
	
	@RequestMapping("/listBoard.do")
	public ModelAndView listBoard() {		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.listAll());
		mav.setViewName("listBoard");
		return mav;
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(@RequestParam("no")int no) {
		ModelAndView mav = new ModelAndView();		
		mav.addObject("vo", dao.getboard(no));
		mav.setViewName("getBoard");
		return mav;
	}
	
}
