package com.BOB.vo;

public class CafeVo {

	private int cafe_no;
	private String license_num;
	private String main_img;
	private String cafe_name;
	private String cafe_info;
	private String cafe_loc;
	private String cafe_phone;
	private String cafe_hrs;
	private String cafe_notice;
	private String cafe_cp;
	private String cafe_rp;
	private int seats;
	private int provider_no;
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public String getLicense_num() {
		return license_num;
	}
	public void setLicense_num(String license_num) {
		this.license_num = license_num;
	}
	public String getMain_img() {
		return main_img;
	}
	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	public String getCafe_info() {
		return cafe_info;
	}
	public void setCafe_info(String cafe_info) {
		this.cafe_info = cafe_info;
	}
	public String getCafe_loc() {
		return cafe_loc;
	}
	public void setCafe_loc(String cafe_loc) {
		this.cafe_loc = cafe_loc;
	}
	public String getCafe_phone() {
		return cafe_phone;
	}
	public void setCafe_phone(String cafe_phone) {
		this.cafe_phone = cafe_phone;
	}
	public String getCafe_hrs() {
		return cafe_hrs;
	}
	public void setCafe_hrs(String cafe_hrs) {
		this.cafe_hrs = cafe_hrs;
	}
	public String getCafe_notice() {
		return cafe_notice;
	}
	public void setCafe_notice(String cafe_notice) {
		this.cafe_notice = cafe_notice;
	}
	public String getCafe_cp() {
		return cafe_cp;
	}
	public void setCafe_cp(String cafe_cp) {
		this.cafe_cp = cafe_cp;
	}
	public String getCafe_rp() {
		return cafe_rp;
	}
	public void setCafe_rp(String cafe_rp) {
		this.cafe_rp = cafe_rp;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getProvider_no() {
		return provider_no;
	}
	public void setProvider_no(int provider_no) {
		this.provider_no = provider_no;
	}
	public CafeVo(int cafe_no, String license_num, String main_img, String cafe_name, String cafe_info, String cafe_loc,
			String cafe_phone, String cafe_hrs, String cafe_notice, String cafe_cp, String cafe_rp, int seats,
			int provider_no) {
		super();
		this.cafe_no = cafe_no;
		this.license_num = license_num;
		this.main_img = main_img;
		this.cafe_name = cafe_name;
		this.cafe_info = cafe_info;
		this.cafe_loc = cafe_loc;
		this.cafe_phone = cafe_phone;
		this.cafe_hrs = cafe_hrs;
		this.cafe_notice = cafe_notice;
		this.cafe_cp = cafe_cp;
		this.cafe_rp = cafe_rp;
		this.seats = seats;
		this.provider_no = provider_no;
	}
	public CafeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
