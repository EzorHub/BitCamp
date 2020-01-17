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

	private int pageGroup = 1; //한 화면에 보여줄 페이지의 수
	
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
		// 파일 삭제
		String fname = dao.detailGoods(no).getFname();
		String path = request.getRealPath("img");
		// --------------------------------------------

		if (!pwd.equals("bitcamp")) {
			msg = "올바른 암호가 아닙니다.";
		} else {
			re = dao.deleteGoods(no);
			if (re != 1) {
				msg = "상품 삭제에 실패했습니다.";
			}
			// --------------------------------------
			String suc = "";
			if (re == 1) {
				suc = "상품삭제에 성공했습니다.";
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

				FileOutputStream fos = new FileOutputStream(path + "/" + fname); // 파일 복사할 위치
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
			msg = "상품 수정에 실패했습니다.";
		}
		session.setAttribute("msg", msg);
		// --------------------------------------
		String suc = "";
		if (re == 1) {
			suc = "상품수정에 성공했습니다.";
			if (fname != null && !fname.equals("")) { // 업로드한 파일이 있다면
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
		// - 파일은 vo로 실려옴 , 여기서는 img 실경로를 찾아 파일복사
		// ---------------------------------------------
		String path = request.getRealPath("img"); // 실제경로폴더 이름

		System.out.println(path);
		// 파일이 올라갔는지 확인
		// 실행중에 클라이언트가 업로드한 파일확인은 이클립스에서 안되고 실경로(탐색기)에서 됨

		MultipartFile file = g.getUpload(); // vo에서 파일을 가져옴
		String fname = file.getOriginalFilename(); // file 이름
		g.setFname(fname); // 파일이름을 vo에 실어넣음 - 그 전까지 vo의 fname은 null이었음
		try {
			// 파일이라 예외안고있음
			byte data[] = file.getBytes();// file 내용 - byte배열로 줌-배열로 받음
			FileOutputStream fos = new FileOutputStream(path + "/" + fname); // 파일객체를 생성
			fos.write(data);// 업로드한 파일 내용을 보내줌
			fos.close(); // 파일쓰기 끝나서 닫아줌

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ---------------------------------------------

		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		/*
		 * System.out.println("---------------------------------"); for(int
		 * i=31;i<=60;i++) { System.out.println("insert into goods values("+i+",'주녁"+i+
		 * "',10000,1,'jh.jpg');"); }
		 * 
		 * System.out.println("---------------------------------");
		 */
		int re = -1;
		re = dao.insertGoods(g);
		String msg = "";

		if (re != 1) {
			msg = "상품등록에 실패했습니다.";
		}
		// --------------------------------------
		String suc = "";
		if (re == 1) {
			suc = "상품등록에 성공했습니다.";

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
		// HttpServletRequest request - 세션값 유지시키려고!0903-
		System.out.println("정렬컬럼: " + column);
		HashMap map = new HashMap(); // map을 미리 선언
		System.out.println("검색컬럼: " + type);
		System.out.println("검색연산자: " + op);
		System.out.println("검색어: " + keyword);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       

		map.put("column", column);

		System.out.println("세션에 설정된 검색어: |" + session.getAttribute(keyword) + "|");
		String s_keyword = null;

		if (session.getAttribute("keyword") != null) { // 검색했으면
			s_keyword = (String) session.getAttribute("keyword"); // 검색어 저장
		}
//		
//		if (s_keyword != null && !s_keyword.equals("")) { // 검색한 적이 있으면, 0906 없어도 상태유지 됨?
//			// map에 등록해주기
//			map.put("type", session.getAttribute("type"));
//			map.put("keyword", session.getAttribute("keyword"));
//			map.put("op", session.getAttribute("op"));
//			
//
//		}
		
		if (keyword != null && !keyword.equals("") ||search==1 && keyword.equals("")) { 
			// 새로운 파라미터 키워드가 오면(우선순위 높음)
			//추가된 조건: 전체목록보고싶음 키워드는 비어있고 검색버튼을 눌렀을때
			map.put("type", type);
			map.put("keyword", keyword);
			map.put("op", op);
			
			session.setAttribute("type", type);
			session.setAttribute("keyword", keyword);
			session.setAttribute("op", op);
			
		}
		map.put("column", column); //따로 담기
		
		//--------------------------------------------------------------------------------------------
		
		totalRecord = dao.getCount(map);		
		totalPage = (int)Math.ceil(totalRecord/(double)pageSIZE)+1;
		String pageStr = "";
		
		String prePAGE = "<a href='listGoods.do?pageGroup="+(startPage-1)+"'>[이전]</a>&nbsp&nbsp&nbsp&nbsp";
		String afterPAGE = "<a href='listGoods.do?pageGroup="+(lastPage+1)+"'>[다음]</a>";
		
		int startPage = 1;
		int lastPage = startPage+(pageGroup-1);
		
		//전체레코드 수가 32개 = 5개씩 보여줌 - 전체페이지의 수 7 현재 페이지 6 endPage는 10이 되는 오류!
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
