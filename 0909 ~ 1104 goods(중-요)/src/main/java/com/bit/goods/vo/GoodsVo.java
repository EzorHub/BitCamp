package com.bit.goods.vo;

import org.springframework.web.multipart.MultipartFile;

//vo는 반드시 여기 없어도 되지만 오토스캔 필요한 것들은 반드시 하위패키지에 있어야함

public class GoodsVo {
	private int no;
	private String name;
	private int price;
	private int qty;
	private String fname;
	private MultipartFile upload;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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

	public GoodsVo(int no, String name, int price, int qty, String fname, MultipartFile upload) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.fname = fname;
		this.upload = upload;
	}

	public GoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
