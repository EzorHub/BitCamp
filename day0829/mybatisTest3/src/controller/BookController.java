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
	public ModelAndView deleteForm(int bookid) { //왜 mav?
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookid", bookid);
		return mav;
	}
	@RequestMapping(value = "/deleteBook.do", method = RequestMethod.POST)
	public ModelAndView deleteSubmit(int bookid, String pwd, HttpSession session) { //그래서 세션처리!
		
		ModelAndView mav = new ModelAndView("redirect:/listBook.do") ; //mav는 상태유지안됨
		String msg = "";
		int re =-1;
		if(pwd.equals("bitcamp")) {
			re = dao.deleteBook(bookid);
			if(re != 1) {
				System.out.println("도서삭제 실패!");
				//mav.addObject("msg", "도서 삭제에 실패했습니다.");
				msg = "도서삭제에 실패했습니다.";			
			}
			
		}else {
			mav.addObject("msg", "관리자 암호가 다릅니다.");
			msg = "도서삭제에 실패했습니다.";
		}
		session.setAttribute("msg", msg); //세션 상태유지
		
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
