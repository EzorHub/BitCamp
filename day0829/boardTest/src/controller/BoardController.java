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

import dao.BoardDao;
import vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBoard.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll());
		return mav;

	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public ModelAndView insertForm(@RequestParam(value = "no", defaultValue = "0") int no) { // void�� �Ϲ� mav�� ����� ����!
		// 1.��۸� �޴� ���, int�� �ƴ϶� String ����!
		// 2.�����尪�� �޴� ���!**
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);
		return mav;
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(BoardVo b, HttpServletRequest requset, HttpSession session) {

		String path = requset.getRealPath("files");// �ǰ��
		System.out.println(path);
		b.setIp(requset.getRemoteAddr());

		// ���-�����̶�� ����--------------------------------------------------
		int no = dao.getNextNo();
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;

		// ----------------------------------------------------------------
		int pno = b.getNo(); // �θ���� �۹�ȣ - ���/�������� �Ǵ�
		System.out.println("pno: " + pno);
		if (pno != 0) { // ���
			BoardVo p = dao.detail(pno);
			b_ref = p.getB_ref();
			System.out.println("b_ref: " + b_ref);
			b_level = p.getB_level();
			b_step = p.getB_step();
			dao.updateStep(b_ref, b_step); // �����ִ� ��� ����?
			b_step++;
			b_level++;

		}
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		// -----------------------------------------------------------------

		// ����ó�� - 0903- �������� �ִٴ� ������ �����ؾ���!
		MultipartFile multi = b.getUpload();
		try {
			byte data[] = multi.getBytes();// file���� �о����
			String fname = multi.getOriginalFilename();

			if (fname != null && !fname.equals("")) {
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				b.setFname(fname);
			} else { //[���1]������ ���ٸ�! 0903 - ������ �����ؾ���
				b.setFname("");				
				//[���2]������ �ʼ��� �Է¹ް��ϰ� �ʹٸ�, 0903 
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		int re = dao.insert(b);

		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String msg = "";
		if (re != 1) {
			msg = "�Խù� ��Ͽ� �����߽��ϴ�.";
			session.setAttribute("msg", msg); // mav�� redirect�������� �浹�Ǿ� msg������ �� ���� - session���� �ذ�~!

		}
		return mav;
	}

	@RequestMapping("/detailBoard.do")
	public ModelAndView detail(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.detail(no));
		return mav;
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.detail(no)); // ������ �Խù� ��������
		return mav;
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(BoardVo b, String pwd, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String msg = "";
		String path = request.getRealPath("files");
		String origin = b.getFname();
		String fname = "";

		System.out.println("pwd: " + pwd);
		System.out.println("������Ʈ~");
		int re = -1;
		MultipartFile upload = b.getUpload();
		System.out.println("upload: " + upload);
		fname = upload.getOriginalFilename();
		System.out.println("fname: " + fname);
		System.out.println("origin: " + origin);

		if (fname != null && !fname.equals("")) { // fname���� �Ǵ��ϵ���
			System.out.println("������ �����Ұſ���!");
			try {
				byte data[] = upload.getBytes();
				fname = upload.getOriginalFilename();
				b.setFname(fname);
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { //������ ���� ������ ���-0904
			MultipartFile multi = b.getUpload();
			try {
				byte data[] = multi.getBytes();
				fname = multi.getOriginalFilename();
				if (fname != null && !fname.equals("")) {
					FileOutputStream fos = new FileOutputStream(path + "/" + fname);
					fos.write(data);
					fos.close();
					b.setFname(fname);
				} else { 
					b.setFname("");					
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		re = dao.updateBoard(b);
		System.out.println("re��: " + re);
		if (re != 1) {
			msg = "�Խù� ������ �����߽��ϴ�.";
			session.setAttribute("msg", msg);
		} else {
			// ������ Ȥ�� �����ߴٸ�?
			if (fname != null && !fname.equals("")) {
				File file = new File(path + "/" + origin);
				file.delete();
			}
		}

		return mav;
	}

	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);
		return mav;
	}

	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.POST)
	public ModelAndView delete(int no, String pwd, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		System.out.println("no: " + no);
		String msg = "";
		String path = request.getRealPath("files");
		String origin = dao.detail(no).getFname();
		int re = dao.deleteBoard(no, pwd);
		System.out.println("re: " + re);
		if (re != 1) {
			msg = "�Խù� ������ �����߽��ϴ�.";
		} else {
			File file = new File(path + "/" + origin);
			file.delete();
		}
		session.setAttribute("msg", msg);
		return mav;
	}

	@RequestMapping(value = "/listBoard.do", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam(value = "type", defaultValue = "") String type,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		System.out.println("�˻�Į��: " + type);
		System.out.println("�˻���: " + keyword);
		ModelAndView mav = new ModelAndView();
		HashMap map = new HashMap();
		map.put("type", type);
		map.put("keyword", keyword);
		mav.addObject("list", dao.searchBoard(map));
		return mav;
	}

}
