package com.BOB.vo;

public class HashTagVo {

	private int tag_no;
	private String tag_content;
	private int std_no;
	public int getTag_no() {
		return tag_no;
	}
	public void setTag_no(int tag_no) {
		this.tag_no = tag_no;
	}
	public String getTag_content() {
		return tag_content;
	}
	public void setTag_content(String tag_content) {
		this.tag_content = tag_content;
	}
	public int getStd_no() {
		return std_no;
	}
	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}
	public HashTagVo(int tag_no, String tag_content, int std_no) {
		super();
		this.tag_no = tag_no;
		this.tag_content = tag_content;
		this.std_no = std_no;
	}
	public HashTagVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
