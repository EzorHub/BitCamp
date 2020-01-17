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
		/* ���ǿ��� �޾ƿ��� �˻�� ������ ���� ���� ���� null�� �� �־� String���� �ٷ� �޾ƿ� �� ����� */
		if (session.getAttribute("keyword") != null) {
			s_keyword = (String) session.getAttribute("keyword");
		}
		if (s_keyword != null && !s_keyword.equals("")) { // ������ �˻��� ���� �ִ���?
			map.put("type", session.getAttribute("type"));
			map.put("op", session.getAttribute("op"));
			map.put("keyword", session.getAttribute("keyword"));
		}
		// ���ǿ� �Ǹ� �������� �Ķ���ͷ� Ÿ�� ���� ����(���ο�˻���)�� �켱���̾����! - **��������**
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
		System.out.println("�˻��÷�: " + type);
		System.out.println("�˻�������: " + op);
		System.out.println("�˻���: " + keyword);
		System.out.println("�����÷�: " + colName);
		System.out.println("--------------------");
		return mav;
	}

}
