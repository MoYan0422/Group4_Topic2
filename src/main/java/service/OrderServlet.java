package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.platform.engine.support.descriptor.CompositeTestSource;

import bean.CartItem;
import bean.CourseBean;
import bean.MemberBean;
import bean.OrderItem;
import bean.OrderUser;
import cartdao.OrderDAO;
import cartdao.impt.CartDaoImpt;
import cartdao.impt.CourseDao;
import cartdao.impt.OrderDaoImpt;
import cartdao.impt.OrderItemDaoImpt;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import mail.JavaMail;
import memberbean.User;
import util.WebUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDaoImpt order = new OrderDaoImpt();
	CartDaoImpt cartDaoImpt = new CartDaoImpt();
	OrderItemDaoImpt orderItem = new OrderItemDaoImpt();
	CourseDao courseDao = new CourseDao();
	static AllInOne allInOne = new AllInOne("");
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html; charset=UTF-8");
		MemberBean user =(MemberBean)request.getSession().getAttribute("user");
		if(user == null) {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		String command = request.getParameter("command");
		if (command == null) {
			orderList(request, response);
		}
		PrintWriter out = response.getWriter();
		System.out.println(command);
		try {
			switch (command) {
			case "ORDERLIST":
				out.print("清單");
				orderList(request, response);
				break;
			case "ADD":
				out.print("新增");
				addOrder(request, response);
				break;
			case "DELETE":
				out.print("刪除");
				deleteOrder(request, response);
				break;
			case "UPDATE":
				out.print("更新");
				updateOrder(request, response);
				break;
			case "ITEMLIST":
				out.print("品項清單");
				orderItemList(request, response);
				break;
			case "SEARCH":
				out.print("搜尋");
				orderSearch(request, response);
				break;
			case "LEARN":
				searchLearn(request, response);
				break;
			case "ECPAY":
				ecPay(request, response);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ecPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderID = request.getParameter("orderID");
		OrderUser orderUser = order.orderUser(orderID);	
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateToStr = dateFormat.format(orderUser.getDate());
		
		AioCheckOutALL obj = new AioCheckOutALL();
		obj.setMerchantTradeNo(orderID+String.valueOf((int)(Math.random()*10000)));
		obj.setMerchantTradeDate(dateToStr);
		obj.setTotalAmount(String.valueOf((int)orderUser.getTotoalprice()));
		obj.setTradeDesc("test Description");
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		obj.setItemName("線上課程");
		String url =request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + request.getServletPath();
		obj.setClientBackURL(url+"?command=UPDATE&status=1&orderID="+orderID);
		String form = allInOne.aioCheckOut(obj, null);
		request.setAttribute("ecpay", form);
		request.getRequestDispatcher("/ecpay.jsp").forward(request, response);
//		String status = request.getParameter("status");
//		orderUser.setStatus(WebUtils.paseInt(status));
//		order.updateOrder(orderUser);
	}
	public static boolean cmprChkMacValue() {
		Hashtable<String, String> dict = new Hashtable<String, String>();
		dict.put("MerchantID", "2000132");
		dict.put("CheckMacValue", "50BE3989953C1734E32DD18EB23698241E035F9CBCAC74371CCCF09E0E15BD61");
		return allInOne.compareCheckMacValue(dict);
	}
	private void searchLearn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//String id = request.getParameter("user");
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		System.out.println(user.getUser_id());
		List<CourseBean> queryUserItem = order.queryUserItem(user.getUser_id());
		int ran = (int)(Math.random()* 5 + 1);
		request.setAttribute("ran",ran);
		for(CourseBean bean : queryUserItem) {
			System.out.println(bean);
		}
		request.setAttribute("myItem", queryUserItem);
		request.getRequestDispatcher("/myLearn.jsp").forward(request, response);
	}

	private void orderSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("search");
		search = "%" + search.trim() + "%";
		List<OrderUser> orderSearch = order.orderSearch(search);
		if(orderSearch.size() == 0) {
			request.setAttribute("nan","found");
		}
		request.setAttribute("order", orderSearch);
		request.getRequestDispatcher("/order.jsp").forward(request, response);
	}

	private void orderItemList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("cartID");
		List<OrderItem> orderItemList = orderItem.orderItemList(id);
		request.setAttribute("itemList", orderItemList);
		String user_id = request.getParameter("userID");
		OrderUser orderUser = order.orderUser(id);
		request.setAttribute("user", orderUser);
		request.getRequestDispatcher("/orderUpdate.jsp").forward(request, response);
	}

	private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("cartID");
		order.deleteOrder(id);
		orderList(request, response);
	}

	private void updateOrder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		String status = request.getParameter("status");
		String orderID = request.getParameter("orderID");
		OrderUser orderUser = order.orderUser(orderID);
		orderUser.setStatus(WebUtils.paseInt(status));
		order.updateOrder(orderUser);
		if (user.getStatus() == 3) {
			List<Object[]> orderItemIDList = orderItem.orderItemIDList(orderID);
			for(Object[] item : orderItemIDList) {
				CourseBean courseBean = courseDao.selectById((int)item[0]);
				courseDao.updateEnrollment(courseBean.getEnrollment() + 1, courseBean.getCourse_id());
			}
			orderList(request, response);
		} else {
			String txt = "<h2>"+"訂單編號: " + orderUser.getOrder_id() + "<br>"
					+"訂單生成日期: " +orderUser.getDate() + "<br>"
					+"購買人姓名: " + orderUser.getName() + "<br>"
					+"購買人信箱" + orderUser.getEmail() + "<br>"
					+"總金額: " + orderUser.getTotoalprice()+"<h2>";
			orderList(request, response);
			JavaMail javaMail = new JavaMail();
			javaMail.setCustomer("ggyy45529441@gmail.com");
			javaMail.setSubject("訂單");
			javaMail.setTxt(txt);
			javaMail.sendMail();
		}
	}

	private void addOrder(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		List<CartItem> carList = cartDaoImpt.carList(user.getUser_id());
		order.addOrder(carList);
		cartDaoImpt.clearCard();
		orderList(request, response);
	}

	private void orderList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		List<OrderUser> orderList = null;
		if(user.getStatus() != 3) {
			 orderList = order.orderList(user.getUser_id());
		}else {
			 orderList = order.orderList();
		}
		request.setAttribute("order", orderList);
		request.getRequestDispatcher("/order.jsp").forward(request, response);
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + request.getServletPath();
		
		// HTTP://localhost:8080/learn-project/OrderServlet
		// http://localhost/8080/learn-project/OrderServlet
		System.out.println(request.getScheme());
		System.out.println(request.getServerName());
		System.out.println(path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
