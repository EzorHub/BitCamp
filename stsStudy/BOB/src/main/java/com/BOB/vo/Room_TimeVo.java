package com.BOB.vo;

public class Room_TimeVo {

	private int time_no;
	private int start_time;
	private int end_time;	
	private int time_price;
	private int room_no;
	public int getTime_no() {
		return time_no;
	}
	public void setTime_no(int time_no) {
		this.time_no = time_no;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public int getEnd_time() {
		return end_time;
	}
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
	public int getTime_price() {
		return time_price;
	}
	public void setTime_price(int time_price) {
		this.time_price = time_price;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public Room_TimeVo(int time_no, int start_time, int end_time, int time_price, int room_no) {
		super();
		this.time_no = time_no;
		this.start_time = start_time;
		this.end_time = end_time;
		this.time_price = time_price;
		this.room_no = room_no;
	}
	public Room_TimeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
