package com.BOB.vo;

public class STDVo {
	private int std_no;
	private String std_image;
	private String std_name;
	private String std_intro;
	private String std_start;
	private String std_end;
	private String std_time;
	private String std_loc;
	private String std_close;
	private int std_limit;
	private String std_content;
	private int std_hits;
	private String founder_info;
	private int founder_no;
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public String getStd_image() {
		return std_image;
	}
	public void setStd_image(String std_image) {
		this.std_image = std_image;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_intro() {
		return std_intro;
	}
	public void setStd_intro(String std_intro) {
		this.std_intro = std_intro;
	}
	public String getStd_start() {
		return std_start;
	}
	public void setStd_start(String std_start) {
		this.std_start = std_start;
	}
	public String getStd_end() {
		return std_end;
	}
	public void setStd_end(String std_end) {
		this.std_end = std_end;
	}
	public String getStd_time() {
		return std_time;
	}
	public void setStd_time(String std_time) {
		this.std_time = std_time;
	}
	public String getStd_loc() {
		return std_loc;
	}
	public void setStd_loc(String std_loc) {
		this.std_loc = std_loc;
	}
	public String getStd_close() {
		return std_close;
	}
	public void setStd_close(String std_close) {
		this.std_close = std_close;
	}
	public int getStd_limit() {
		return std_limit;
	}
	public void setStd_limit(int std_limit) {
		this.std_limit = std_limit;
	}
	public String getStd_content() {
		return std_content;
	}
	public void setStd_content(String std_content) {
		this.std_content = std_content;
	}
	public int getStd_hits() {
		return std_hits;
	}
	public void setStd_hits(int std_hits) {
		this.std_hits = std_hits;
	}
	public String getFounder_info() {
		return founder_info;
	}
	public void setFounder_info(String founder_info) {
		this.founder_info = founder_info;
	}
	public int getFounder_no() {
		return founder_no;
	}
	public void setFounder_no(int founder_no) {
		this.founder_no = founder_no;
	}
	public STDVo(int std_no, String std_image, String std_name, String std_intro, String std_start, String std_end,
			String std_time, String std_loc, String std_close, int std_limit, String std_content, int std_hits,
			String founder_info, int founder_no) {
		super();
		this.std_no = std_no;
		this.std_image = std_image;
		this.std_name = std_name;
		this.std_intro = std_intro;
		this.std_start = std_start;
		this.std_end = std_end;
		this.std_time = std_time;
		this.std_loc = std_loc;
		this.std_close = std_close;
		this.std_limit = std_limit;
		this.std_content = std_content;
		this.std_hits = std_hits;
		this.founder_info = founder_info;
		this.founder_no = founder_no;
	}
	public STDVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
