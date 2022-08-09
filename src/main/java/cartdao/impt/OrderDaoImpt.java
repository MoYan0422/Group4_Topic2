package cartdao.impt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import bean.CartItem;
import bean.CourseBean;
import bean.OrderItem;
import bean.OrderUser;
import cartdao.BaseDAO;

import cartdao.impt.*;
import cartdao.OrderDAO;

public class OrderDaoImpt extends BaseDAO<OrderUser> implements OrderDAO {
	OrderItemDaoImpt daoImpt = new OrderItemDaoImpt();

	@Override
	public void addOrder(List<CartItem> cart) {
		int count = 0;
		double price = 0;
		for (CartItem item : cart) {
			count += item.getCount();
			price += item.getPrice();
		}
		OrderUser order = new OrderUser();
		Date date = new Date();
		String orderID = String.valueOf(date.getTime() + String.valueOf(cart.get(0).getUser_id()));
		order.setOrder_id(orderID);
		order.setUser_id(cart.get(0).getUser_id());
		order.setDate(date);
		order.setStatus(0);
		order.setTotoalcount(count);
		order.setTotoalprice(price);
		String sql = "insert into Order_user values(?,?,?,?,?,?,?)";
		update(sql, order.getOrder_id(), order.getUser_id(), order.getDate(), order.getStatus(), order.getTotoalcount(),
				null, order.getTotoalprice());
		daoImpt.addOrderItem(orderID, cart);
	}

	@Override
	public void deleteOrder(String orderID) {
		daoImpt.deleteOrderItem(orderID);
		String sql = "delete from Order_user where order_id = ?";
		update(sql, orderID);
	}

	@Override
	public void updateOrder(OrderUser user) {
		String sql = "update Order_user set status = ? where order_id = ?";
		update(sql, user.getStatus(), user.getOrder_id());
	}

	@Override
	public List<OrderUser> orderList(int id) {//找用戶的訂單
		String sql = "select  m.user_id , m.account, m.name , m.email,m.cellphone, o.order_id, o.date, o.status, o.totoalcount, o.discount, o.totoalprice from Order_user o join member m on  o.user_id = m.user_id where o.user_id = ?";
		List<OrderUser> queryForList = QueryForList(sql, OrderUser.class,id);
		return queryForList;
	}
	public List<OrderUser> orderList() {
		String sql = "select m.user_id , m.account, m.name , m.email, m.cellphone,o.order_id, o.date, o.status, o.totoalcount, o.discount, o.totoalprice from Order_user o join member m on  o.user_id = m.user_id ";
		List<OrderUser> queryForList = QueryForList(sql, OrderUser.class);
		return queryForList;
	}

	@Override
	public OrderUser orderUser(String orderID) {//找訂單的用戶
		String sql = "select m.user_id , m.account, m.name , m.email, m.cellphone,o.order_id, o.date, o.status, o.totoalcount, o.discount, o.totoalprice from Order_user o join member m on  o.user_id = m.user_id where o.order_id = ?";
		OrderUser queryForList = QueryForOne(sql, OrderUser.class, orderID);
		return queryForList;
	}

	public List<OrderUser> orderSearch(String search) {
		System.out.println(search);
		String sql = "select m.user_id , m.account, m.name , m.email,o.order_id, o.date, o.status, o.totoalcount, o.discount, o.totoalprice from Order_user o join member m on  o.user_id = m.user_id"
				+ " where m.account like ? or m.name like ? or o.order_id like ?";
		List<OrderUser> queryForList = QueryForList(sql, OrderUser.class, search, search, search);
		return queryForList;
	}

	public List<CourseBean>  queryUserItem(int userID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select order_id from Order_user where user_id = ? and status = 2";
		List<Object[]> queryForObject = QueryForObjectArray(sql, userID);
		CourseDao dao = new CourseDao();
		List<CourseBean> courses = new ArrayList<>();
		for (Object[] o : queryForObject) {
			List<Object[]> orderItemIDList = daoImpt.orderItemIDList((String) o[0]);
			for (Object[] item : orderItemIDList) {
				CourseBean course = dao.selectById((int)item[0]);
				courses.add(course);
			}
		}
		return courses;
	}

}
