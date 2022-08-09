package cartdao;

import java.util.List;


import bean.CartItem;

public interface CartDAO {
	public List<CartItem> carList(int id);
	public void addCart(CartItem cart);
	public void deleteCart(int itemID);
	public void clearCard();
	public List getCountTotal(List<CartItem> cart);
}
