package bean;

public class OrderItem {
	
	private int id;
	private String order_id;  
	private int item_id ;
	private String name; 
	private int count = 1; 
	private double price;
	
	public OrderItem() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OrderItem(int id, String order_id, int item_id, String name, int count, double price) {
		this.id = id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.name = name;
		this.count = count;
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order_id=" + order_id + ", item_id=" + item_id + ", name=" + name + ", count="
				+ count + ", price=" + price + "]";
	} 
	
}
