package controller;

import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/deleteBook.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int bookid) { //�� mav?
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookid", bookid);
		return mav;
	}
	@RequestMapping(value = "/deleteBook.do", method = RequestMethod.POST)
	public ModelAndView deleteSubmit(int bookid, String pwd, HttpSession session) { //�׷��� ����ó��!
		
		ModelAndView mav = new ModelAndView("redirect:/listBook.do") ; //mav�� ���������ȵ�
		String msg = "";
		int re =-1;
		if(pwd.equals("bitcamp")) {
			re = dao.deleteBook(bookid);
			if(re != 1) {
				System.out.println("�������� ����!");
				//mav.addObject("msg", "���� ������ �����߽��ϴ�.");
				msg = "���������� �����߽��ϴ�.";			
			}
			
		}else {
			mav.addObject("msg", "������ ��ȣ�� �ٸ��ϴ�.");
			msg = "���������� �����߽��ϴ�.";
		}
		session.setAttribute("msg", msg); //���� ��������
		
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
