package ex06;

public class BookStore {
	private Book book;
	private Customer customer;
	
	
	
	public void setBook(Book book) {
		this.book = book;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public void pro() {
		book.info();
		customer.info();
	}
}
