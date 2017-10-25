package model;

public class BookInfo {
	private int id;
	//关联图书类型
	private BookTypeInfo bookTypeInfo;
	private String bookName;
	private String author;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BookTypeInfo getBookTypeInfo() {
		return bookTypeInfo;
	}
	public void setBookTypeInfo(BookTypeInfo bookTypeInfo) {
		this.bookTypeInfo = bookTypeInfo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
