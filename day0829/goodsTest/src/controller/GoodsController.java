package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.GoodsDao;
import vo.GoodsVo;

@Controller
public class GoodsController {
	private int pageSIZE = 5;
	private int totalRecord = 0; 
	private int totalPage = 1;

	private int pageGroup = 1; //�� ȭ�鿡 ������ �������� ��
	
	private int startPage = 1; 	
	private int lastPage =0; 	
	

	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/deleteGoods.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);
		return mav;
	}

	@RequestMapping(value = "/deleteGoods.do", method = RequestMethod.POST)
	public ModelAndView deleteSubmit(int no, String pwd, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		int re = -1;
		String msg = "";
		// --------------------------------------------
		// ���� ����
		String fname = dao.detailGoods(no).getFname();
		String path = request.getRealPath("img");
		// --------------------------------------------

		if (!pwd.equals("bitcamp")) {
			msg = "�ùٸ� ��ȣ�� �ƴմϴ�.";
		} else {
			re = dao.deleteGoods(no);
			if (re != 1) {
				msg = "��ǰ ������ �����߽��ϴ�.";
			}
			// --------------------------------------
			String suc = "";
			if (re == 1) {
				suc = "��ǰ������ �����߽��ϴ�.";
				// --------------------------------------------
				File file = new File(path + "/" + fname);
				file.delete();
				// --------------------------------------------

			}
			session.setAttribute("suc", suc);
			// --------------------------------------
		}

		session.setAttribute("msg", msg);

		return mav;
	}

	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.detailGoods(no));
		return mav;
	}

	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(GoodsVo g, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		int re = -1;
		String msg = "";
		// -----------------------------------------------
		String path = request.getRealPath("img");
		String origin = g.getFname();
		String fname = null;
		MultipartFile upload = g.getUpload();
		if (upload != null) {
			try {
				byte data[] = upload.getBytes();
				fname = upload.getOriginalFilename();

				FileOutputStream fos = new FileOutputStream(path + "/" + fname); // ���� ������ ��ġ
				fos.write(data);
				fos.close();
				g.setFname(fname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// -----------------------------------------------
		re = dao.updateGoods(g);
		if (re != 1) {
			msg = "��ǰ ������ �����߽��ϴ�.";
		}
		session.setAttribute("msg", msg);
		// --------------------------------------
		String suc = "";
		if (re == 1) {
			suc = "��ǰ������ �����߽��ϴ�.";
			if (fname != null && !fname.equals("")) { // ���ε��� ������ �ִٸ�
				File file = new File(path + "/" + origin);
				file.delete();
			}

		}
		session.setAttribute("suc", suc);
		// --------------------------------------
		return mav;
	}

	@RequestMapping("/detailGoods.do")
	public ModelAndView detail(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.detailGoods(no));
		return mav;
	}

	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public ModelAndView insertForm() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(GoodsVo g, HttpSession session, HttpServletRequest request) {

		// HttpServletRequest request
		// - ������ vo�� �Ƿ��� , ���⼭�� img �ǰ�θ� ã�� ���Ϻ���
		// ---------------------------------------------
		String path = request.getRealPath("img"); // ����������� �̸�

		System.out.println(path);
		// ������ �ö󰬴��� Ȯ��
		// �����߿� Ŭ���̾�Ʈ�� ���ε��� ����Ȯ���� ��Ŭ�������� �ȵǰ� �ǰ��(Ž����)���� ��

		MultipartFile file = g.getUpload(); // vo���� ������ ������
		String fname = file.getOriginalFilename(); // file �̸�
		g.setFname(fname); // �����̸��� vo�� �Ǿ���� - �� ������ vo�� fname�� null�̾���
		try {
			// �����̶� ���ܾȰ�����
			byte data[] = file.getBytes();// file ���� - byte�迭�� ��-�迭�� ����
			FileOutputStream fos = new FileOutputStream(path + "/" + fname); // ���ϰ�ü�� ����
			fos.write(data);// ���ε��� ���� ������ ������
			fos.close(); // ���Ͼ��� ������ �ݾ���

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ---------------------------------------------

		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		/*
		 * System.out.println("---------------------------------"); for(int
		 * i=31;i<=60;i++) { System.out.println("insert into goods values("+i+",'�ֳ�"+i+
		 * "',10000,1,'jh.jpg');"); }
		 * 
		 * System.out.println("---------------------------------");
		 */
		int re = -1;
		re = dao.insertGoods(g);
		String msg = "";

		if (re != 1) {
			msg = "��ǰ��Ͽ� �����߽��ϴ�.";
		}
		// --------------------------------------
		String suc = "";
		if (re == 1) {
			suc = "��ǰ��Ͽ� �����߽��ϴ�.";

		}
		session.setAttribute("suc", suc);
		// --------------------------------------
		session.setAttribute("msg", msg);

		return mav;
	}
//
//	@RequestMapping(value = "/listGoods.do", method = RequestMethod.GET)
//	public ModelAndView list() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list", dao.listAll());
//		return mav;
//	}

	@RequestMapping("/listGoods.do")
	public ModelAndView search(@RequestParam(value = "type", defaultValue = "") String type,
			@RequestParam(value = "op", defaultValue = "") String op,
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "column", defaultValue = "") String column, 
			@RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM, 
			@RequestParam(value = "search", defaultValue = "0") int search, 
			
			HttpServletRequest request,
			HttpSession session) {
		// HttpServletRequest request - ���ǰ� ������Ű����!0903-
		System.out.println("�����÷�: " + column);
		HashMap map = new HashMap(); // map�� �̸� ����
		System.out.println("�˻��÷�: " + type);
		System.out.println("�˻�������: " + op);
		System.out.println("�˻���: " + keyword);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       

		map.put("column", column);

		System.out.println("���ǿ� ������ �˻���: |" + session.getAttribute(keyword) + "|");
		String s_keyword = null;

		if (session.getAttribute("keyword") != null) { // �˻�������
			s_keyword = (String) session.getAttribute("keyword"); // �˻��� ����
		}
//		
//		if (s_keyword != null && !s_keyword.equals("")) { // �˻��� ���� ������, 0906 ��� �������� ��?
//			// map�� ������ֱ�
//			map.put("type", session.getAttribute("type"));
//			map.put("keyword", session.getAttribute("keyword"));
//			map.put("op", session.getAttribute("op"));
//			
//
//		}
		
		if (keyword != null && !keyword.equals("") ||search==1 && keyword.equals("")) { 
			// ���ο� �Ķ���� Ű���尡 ����(�켱���� ����)
			//�߰��� ����: ��ü��Ϻ������ Ű����� ����ְ� �˻���ư�� ��������
			map.put("type", type);
			map.put("keyword", keyword);
			map.put("op", op);
			
			session.setAttribute("type", type);
			session.setAttribute("keyword", keyword);
			session.setAttribute("op", op);
			
		}
		map.put("column", column); //���� ���
		
		//--------------------------------------------------------------------------------------------
		
		totalRecord = dao.getCount(map);		
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE)+1;
		String pageStr = "";
		
		String prePAGE = "<a href='listGoods.do?pageGroup="+(startPage-1)+"'>[����]</a>&nbsp&nbsp&nbsp&nbsp";
		String afterPAGE = "<a href='listGoods.do?pageGroup="+(lastPage+1)+"'>[����]</a>";
		
		int startPage = 1;
		int lastPage = startPage+(pageGroup-1);
		
		//��ü���ڵ� ���� 32�� = 5���� ������ - ��ü�������� �� 7 ���� ������ 6 endPage�� 10�� �Ǵ� ����!
		if(lastPage > totalPage) {
			lastPage = totalPage;
		}
		/*
		 * int i =1; for(;i<=totalRecord;i++) { for(int j= startPage;j<=lastPage;j++) {
		 * 
		 * pageStr +=
		 * "<a href='listGoods.do?pageNUM="+i+"'>"+i+"</a>&nbsp&nbsp&nbsp&nbsp"; if() {}
		 * }
		 * 
		 * 
		 * if() { pageStr = prePAGE+pageStr; }else if() { pageStr = pageStr+afterPAGE; }
		 * 
		 * 
		 * }
		 */
		int i = 1;
		while(true) {
			
			pageStr +=
					  "<a href='listGoods.do?pageNUM="+i+"'>"+i+"</a>&nbsp&nbsp&nbsp&nbsp";
			i++;
			if(i==totalPage) {
				break;	
			}
			
		}
		if(lastPage < totalPage) {
			pageStr += afterPAGE;
		}
		if(startPage >totalPage) {
			pageStr += prePAGE;
		}
		//--------------------------------------------------------------------------------------------
		System.out.println(pageNUM);
		System.out.println(totalRecord);
		System.out.println(totalPage);
		
		int start = (pageNUM-1)*pageSIZE+1;
		int last = start+pageSIZE-1;
		map.put("start", start);
		map.put("last", last);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", dao.searchGoods(map));
		mav.addObject("pageStr", pageStr);
		
		return mav;

	}

}
