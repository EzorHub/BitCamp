package controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.BookDao;

@Controller
public class BookController {
	@Autowired
	private BookDao dao;

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBook.do")
	public ModelAndView search(@RequestParam(value = "type", defaultValue = "") String type,
			@RequestParam(value = "op", defaultValue = "") String op,
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "colName", defaultValue = "") String colName, HttpSession session) {

		HashMap map = new HashMap();

		String s_keyword = null;
		/* 세션에서 받아오는 검색어가 최초의 값이 없는 경우는 null일 수 있어 String으로 바로 받아올 수 없어용 */
		if (session.getAttribute("keyword") != null) {
			s_keyword = (String) session.getAttribute("keyword");
		}
		if (s_keyword != null && !s_keyword.equals("")) { // 이전에 검색한 적이 있는지?
			map.put("type", session.getAttribute("type"));
			map.put("op", session.getAttribute("op"));
			map.put("keyword", session.getAttribute("keyword"));
		}
		// 세션에 실린 정보보다 파라미터로 타고 오는 값들(새로운검색어)이 우선적이어야함! - **상태유지**
		if (keyword != null && !keyword.equals("")) {
			map.put("type", type);
			map.put("op", op);
			map.put("keyword", keyword);			

			session.setAttribute("type", type);
			session.setAttribute("op", op);
			session.setAttribute("keyword", keyword);
			session.setAttribute("colName", colName);

		}
//		else {
//			session.setAttribute("type", "bookname");
//			session.setAttribute("op", "=");
//			
//		}

		map.put("colName", colName);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll(map));

		if (type.equals("")) {
			type = "bookname";
		}
		if (op.equals("")) {
			op = "=";
		}

		System.out.println("--------------------");
		System.out.println("검색컬럼: " + type);
		System.out.println("검색연산자: " + op);
		System.out.println("검색어: " + keyword);
		System.out.println("정렬컬럼: " + colName);
		System.out.println("--------------------");
		return mav;
	}

}
