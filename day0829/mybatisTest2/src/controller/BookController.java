package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.BookDao;
import vo.BookVo;

@Controller
public class BookController {

	@Autowired
	private BookDao dao;

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/deleteBook.do")
	public ModelAndView deleteSubmit(int bookid) {
		ModelAndView mav = new ModelAndView("redirect:/listBook.do");

		int re = -1;

		re = dao.deleteBook(bookid);
		if (re != 1) {
			mav.addObject("msg", "도서 삭제에 실패했습니다.");
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping(value = "/updateBook.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int bookid) {// get
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.getBook(bookid));
		return mav;
	}

	@RequestMapping(value = "/updateBook.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(BookVo b) { // post - 폼태그에 입력한 객체를 커멘드객체
		ModelAndView mav = new ModelAndView("redirect:/listBook.do");
		int re = dao.updateBook(b);
		System.out.println("re값: " + re);
		if (re != 1) { // 특정개수이거나 1보다 큰 경우도 있음
			mav.addObject("msg", "도서수정에 실패했습닌다.");
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping("/listBook.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;
	}

	@RequestMapping("/detailBook.do")
	public ModelAndView get(int bookid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.getBook(bookid));
		return mav;
	}

	@RequestMapping(value = "insertBook.do", method = RequestMethod.GET)
	public void insertForm() {

	}

	@RequestMapping(value = "insertBook.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(BookVo b) {// 커맨드오브젝트
		ModelAndView mav = new ModelAndView("redirect:/listBook.do");
		int re = dao.insertBook(b);
		if (re != 1) {
			mav.addObject("msg", "도서등록에 실패했습니다.");
			mav.setViewName("error");
		}

		return mav;
	}

}
