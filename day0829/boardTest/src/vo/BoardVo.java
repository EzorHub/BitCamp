package vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVo {
	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String content;
	private int hit;
	private Date regdate;
	private int b_ref;
	private int b_level;
	private int b_step;
	private String ip;
	private String fname;
	private MultipartFile upload;


	public BoardVo(int no, String title, String writer, String pwd, String content, int hit, Date regdate, int b_ref,
			int b_level, int b_step, String ip, String fname, MultipartFile upload) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.content = content;
		this.hit = hit;
		this.regdate = regdate;
		this.b_ref = b_ref;
		this.b_level = b_level;
		this.b_step = b_step;
		this.ip = ip;
		this.fname = fname;
		this.upload = upload;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getB_ref() {
		return b_ref;
	}


	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}


	public int getB_level() {
		return b_level;
	}


	public void setB_level(int b_level) {
		this.b_level = b_level;
	}


	public int getB_step() {
		return b_step;
	}


	public void setB_step(int b_step) {
		this.b_step = b_step;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public MultipartFile getUpload() {
		return upload;
	}


	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}


	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}