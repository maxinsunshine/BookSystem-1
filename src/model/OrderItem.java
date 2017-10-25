package model;

public class OrderItem {

	private String order_id; // 订单号
	private String books_id; // 图书号
	private int lendnum; // 购买数量

	// 要查询订单中商品信息时，可以将商品信息封装到OrderItem中.
	private String name;//图书名称
	private double price;//价格

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getBooks_id() {
		return books_id;
	}

	public void setBooks_id(String books_id) {
		this.books_id = books_id;
	}

	public int getLendnum() {
		return lendnum;
	}

	public void setLendnum(int lendnum) {
		this.lendnum = lendnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
