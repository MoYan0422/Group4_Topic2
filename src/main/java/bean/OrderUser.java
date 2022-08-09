package bean;

import java.util.Date;

public class OrderUser {
	private String account;
	private String name;
	private String email;
	private String cellphone;
	private String order_id;
	private int user_id;
	private Date date;
	private int status;
	private int totoalcount = 1;
	private String discount;
	private double totoalprice;
	public OrderUser() {
		
	}
	
	public OrderUser(String order_id, int user_id, Date date, int status, int totoalcount, String discount,
			double totoalprice) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.date = date;
		this.status = status;
		this.totoalcount = totoalcount;
		this.discount = discount;
		this.totoalprice = totoalprice;
	}
	
	public OrderUser(String account, String name, String email, String order_id, int user_id, Date date, int status,
			int totoalcount, String discount, double totoalprice) {
		this.account = account;
		this.name = name;
		this.email = email;
		this.order_id = order_id;
		this.user_id = user_id;
		this.date = date;
		this.status = status;
		this.totoalcount = totoalcount;
		this.discount = discount;
		this.totoalprice = totoalprice;
	}
	

	public OrderUser(String account, String name, String email, String cellphone, String order_id, int user_id,
			Date date, int status, int totoalcount, String discount, double totoalprice) {
		this.account = account;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.order_id = order_id;
		this.user_id = user_id;
		this.date = date;
		this.status = status;
		this.totoalcount = totoalcount;
		this.discount = discount;
		this.totoalprice = totoalprice;
	}
	
	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTotoalcount() {
		return totoalcount;
	}
	public void setTotoalcount(int totoalcount) {
		this.totoalcount = totoalcount;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public double getTotoalprice() {
		return totoalprice;
	}
	public void setTotoalprice(double totoalprice) {
		this.totoalprice = totoalprice;
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

	@Override
	public String toString() {
		return "OrderUser [order_id=" + order_id + ", user_id=" + user_id + ", date=" + date + ", status=" + status
				+ ", totoalcount=" + totoalcount + ", discount=" + discount + ", totoalprice=" + totoalprice + "]";
	}
	
}
