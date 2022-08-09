package bean;

import java.io.Serializable;

public class CartItem implements Serializable{
	private String account;
	private String name;
	private String email;
	private int id;
	private int user_id;
	private int item_id;
	private String itemName;
	private int count ;
	private double price;
	
	public CartItem(int id, int user_id, int item_id, String itemName, int count,double price) {
		this.id = id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.itemName = itemName;
		this.count = count;
		this.price = price;
	}

	

	public CartItem(String account, String name, String email, int id, int user_id, int item_id, String itemName,
			int count, double price) {
		this.account = account;
		this.name = name;
		this.email = email;
		this.id = id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.itemName = itemName;
		this.count = count;
		this.price = price;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public CartItem() {
		
	}
	
	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
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
	
	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	@Override
	public String toString() {
		return "CartDto [user_id=" + user_id + ", item_id=" + item_id + ", itemName=" + itemName + ", count=" + count
				+ ", price=" + price + "]";
	}
	
	
}
