package ex03;

public class BookStore {
	private Book book;
	private Customer customer;
	
	public BookStore(Book book, Customer customer) {
		super();
		this.book = book;
		this.customer = customer;
	}
	
	public void pro() {
		book.info();
		customer.info();
	}
}
