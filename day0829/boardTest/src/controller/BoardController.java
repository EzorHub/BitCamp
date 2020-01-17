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
	public ModelAndView insertForm(@RequestParam(value = "no", defaultValue = "0") int no) { // void는 일반 mav는 답글을 위해!
		// 1.답글만 받는 경우, int가 아니라 String 으로!
		// 2.디폴드값을 받는 경우!**
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);
		return mav;
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(BoardVo b, HttpServletRequest requset, HttpSession session) {

		String path = requset.getRealPath("files");// 실경로
		System.out.println(path);
		b.setIp(requset.getRemoteAddr());

		// 답글-새글이라고 가정--------------------------------------------------
		int no = dao.getNextNo();
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;

		// ----------------------------------------------------------------
		int pno = b.getNo(); // 부모글의 글번호 - 답글/새글인지 판단
		System.out.println("pno: " + pno);
		if (pno != 0) { // 답글
			BoardVo p = dao.detail(pno);
			b_ref = p.getB_ref();
			System.out.println("b_ref: " + b_ref);
			b_level = p.getB_level();
			b_step = p.getB_step();
			dao.updateStep(b_ref, b_step); // 원래있던 답글 증가?
			b_step++;
			b_level++;

		}
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		// -----------------------------------------------------------------

		// 파일처리 - 0903- 없을수도 있다는 것으로 수정해야함!
		MultipartFile multi = b.getUpload();
		try {
			byte data[] = multi.getBytes();// file내용 읽어오기
			String fname = multi.getOriginalFilename();

			if (fname != null && !fname.equals("")) {
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				b.setFname(fname);
			} else { //[방법1]파일이 없다면! 0903 - 수정도 수정해야함
				b.setFname("");				
				//[방법2]파일을 필수로 입력받게하고 싶다면, 0903 
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		int re = dao.insert(b);

		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		String msg = "";
		if (re != 1) {
			msg = "게시물 등록에 실패했습니다.";
			session.setAttribute("msg", msg); // mav는 redirect때문인지 충돌되어 msg전달할 수 없음 - session으로 해결~!

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
		mav.addObject("b", dao.detail(no)); // 수정할 게시물 상태유지
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
		System.out.println("업데이트~");
		int re = -1;
		MultipartFile upload = b.getUpload();
		System.out.println("upload: " + upload);
		fname = upload.getOriginalFilename();
		System.out.println("fname: " + fname);
		System.out.println("origin: " + origin);

		if (fname != null && !fname.equals("")) { // fname으로 판단하도록
			System.out.println("사진도 수정할거에여!");
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
		} else { //파일이 원래 없었던 경우-0904
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
		System.out.println("re값: " + re);
		if (re != 1) {
			msg = "게시물 수정에 실패했습니다.";
			session.setAttribute("msg", msg);
		} else {
			// 사진도 혹시 수정했다면?
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
			msg = "게시물 삭제에 실패했습니다.";
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
		System.out.println("검색칼럼: " + type);
		System.out.println("검색어: " + keyword);
		ModelAndView mav = new ModelAndView();
		HashMap map = new HashMap();
		map.put("type", type);
		map.put("keyword", keyword);
		mav.addObject("list", dao.searchBoard(map));
		return mav;
	}

}
