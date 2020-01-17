package ex12;

public class SmsSender {
	private String from;
	private String to;
	
	
	public SmsSender() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SmsSender(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}


	public void send() {
		System.out.println(from +"가 "+to+"에게 메시지를 전송했습니다.");
	}
}
