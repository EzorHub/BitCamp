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
	int pageSIZE = 5;
	// �� ȭ�鿡 ������ ���ڵ��� ��
	int totalRecord = 0;
	// ��ü ���ڵ��� �� ==������������ �˾Ƴ����ϴϲ�
	int totalPage = 1;
	// ��ü �������� �� ==���ڵ尡 0���̴��� ��� �������� 1������

	@Autowired
	private BookDao dao;

	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBook.do")
	public ModelAndView search(@RequestParam(value = "type", defaultValue = "") String type,
			@RequestParam(value = "op", defaultValue = "") String op,
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "colName", defaultValue = "") String colName,
			@RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM,

			HttpSession session) {

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
		
		
		System.out.println("��ü ���ڵ� ��: " + totalRecord);
		
		// ��ü������ ���� ����� �ٷ��غ���

		
	

		//������ ��ȣ�� ���� ���۷��ڵ�� ������ ���ڵ带 ����� ���		
		//���ȣ�� �ٿ���,,,,,,
		int start =(pageNUM-1)*pageSIZE+1;//���۷��ڵ� 
		int last =start+pageSIZE-1; //���������ڵ�
		
		
		
		map.put("start", start);
		map.put("last", last);		
		
		System.out.println("--------------------");
		System.out.println("�˻��÷�: " + type);
		System.out.println("�˻�������: " + op);
		System.out.println("�˻���: " + keyword);
		System.out.println("�����÷�: " + colName);
		System.out.println("--------------------");

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
		totalRecord = dao.getCount(map);
		
		totalPage = totalRecord / pageSIZE;
		if (totalRecord % pageSIZE != 0) { // ����������������� +1���ֱ�!
			totalPage++;
		}
		System.out.println("��ü������ ��: " + totalPage);
		System.out.println("���������� ��ȣ: " + pageNUM);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll(map));

		if (type.equals("")) {
			type = "bookname";
		}
		if (op.equals("")) {
			op = "=";
		}
//		mav.addObject("totalPage", totalPage);

		String pageStr = "";
		for (int i = 1; i <= totalPage; i++) {
			 pageStr = pageStr+"<a href=listBook.do?pageNUM="+i+">"+i+"</a>"+"&nbsp;&nbsp;";
		}
		mav.addObject("pageStr", pageStr);

		return mav;
	}

}
