package ex03;

public class Book {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
	public Book(int bookid, String bookname, String publisher, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
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
