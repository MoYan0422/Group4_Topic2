package cartdao.impt;

import java.util.ArrayList;
import java.util.List;

import bean.CartItem;
import bean.CourseBean;
import cartdao.BaseDAO;
import cartdao.CartDAO;

public class CartDaoImpt extends BaseDAO<CartItem> implements CartDAO {

	@Override
	public List<CartItem> carList(int id) {
		String sql = "select * from Cart where user_id = ?";
		List<CartItem> queryForList = QueryForList(sql, CartItem.class,id);
		return queryForList;
	}

	@Override
	public void addCart(CartItem cart) {
		// TODO Auto-generated method stub
		String sql = "insert into Cart values(?,?,?,?,?)";
		update(sql, cart.getUser_id(), cart.getItem_id(), cart.getItemName(), cart.getCount(), cart.getPrice());
	}

	@Override
	public void deleteCart(int paseInt) {
		String sql = "delete from Cart where id = ?";
		update(sql, paseInt);
	}

	@Override
	public void clearCard() {
		// TODO Auto-generated method stub
		String sql = "delete from Cart";
		update(sql);
	}

	public List getCountTotal(List<CartItem> cart) {
		List list = new ArrayList();
		int count = 0;
		double price = 0;
		for(CartItem item : cart) {
			count += item.getCount();
			price += item.getPrice();
		}
		list.add(price);
		list.add(count);
		return list;
	}
}
