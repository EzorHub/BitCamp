package com.chat.vo;

public class JumunDetailVo {
	private int no;
	private int jumun_no;
	private int goods_no;
	private int qty;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getJumun_no() {
		return jumun_no;
	}
	public void setJumun_no(int jumun_no) {
		this.jumun_no = jumun_no;
	}
	public int getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public JumunDetailVo(int no, int jumun_no, int goods_no, int qty) {
		super();
		this.no = no;
		this.jumun_no = jumun_no;
		this.goods_no = goods_no;
		this.qty = qty;
	}
	public JumunDetailVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
