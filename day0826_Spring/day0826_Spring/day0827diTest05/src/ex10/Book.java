package ex10;

public class Book {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}



	public void setBookname(String bookname) {
		this.bookname = bookname;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public void info() {
		System.out.println("***도서정보***");
		System.out.println("도서번호: "+bookid);
		System.out.println("도서명: "+bookname);
		System.out.println("출판사: "+publisher);
		System.out.println("가격: "+price);
	}
	
}
