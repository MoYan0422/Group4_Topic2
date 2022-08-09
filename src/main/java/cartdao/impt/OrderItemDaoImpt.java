package cartdao.impt;

import java.util.List;

import bean.CartItem;
import bean.OrderItem;
import cartdao.BaseDAO;
import cartdao.OrderItemDAO;

public class OrderItemDaoImpt extends BaseDAO<OrderItem> implements OrderItemDAO {

	@Override
	public void addOrderItem(String orderID , List<CartItem> cart) {
		String sql = "insert into OrderItem values(?,?,?,?,?)";
		for(CartItem item : cart) {
			update(sql,orderID,item.getItem_id(),item.getItemName(),item.getCount(),item.getPrice() );
		}
	}
	public void deleteOrderItem(String orderID) {
		// TODO Auto-generated method stub
		String sql = "delete from OrderItem where order_id = ?";
		update(sql, orderID);
	}

	public List<OrderItem> orderItemList(String orderID) {
		String sql = "select * from OrderItem where order_id = ?";
		List<OrderItem> queryForList = QueryForList(sql, OrderItem.class,orderID);
		return  queryForList;
	}
	public List<Object[]> orderItemIDList(String orderID) {
		String sql = "select item_id from OrderItem where order_id = ?";
		 List<Object[]> queryForObjectArray = QueryForObjectArray(sql, orderID);
		return  queryForObjectArray;
	}
	
}
