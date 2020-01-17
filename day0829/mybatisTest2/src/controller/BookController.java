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
			mav.addObject("msg", "���� ������ �����߽��ϴ�.");
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
	public ModelAndView updateSubmit(BookVo b) { // post - ���±׿� �Է��� ��ü�� Ŀ��尴ü
		ModelAndView mav = new ModelAndView("redirect:/listBook.do");
		int re = dao.updateBook(b);
		System.out.println("re��: " + re);
		if (re != 1) { // Ư�������̰ų� 1���� ū ��쵵 ����
			mav.addObject("msg", "���������� �����߽��Ѵ�.");
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
	public ModelAndView insertSubmit(BookVo b) {// Ŀ�ǵ������Ʈ
		ModelAndView mav = new ModelAndView("redirect:/listBook.do");
		int re = dao.insertBook(b);
		if (re != 1) {
			mav.addObject("msg", "������Ͽ� �����߽��ϴ�.");
			mav.setViewName("error");
		}

		return mav;
	}

}
