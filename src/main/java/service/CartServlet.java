package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import bean.CartItem;
import bean.CourseBean;
import bean.MemberBean;
import dao.*;
import memberbean.User;
import cartdao.impt.CartDaoImpt;
import cartdao.impt.CourseDao;
import util.WebUtils;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	CartDaoImpt cartDaoImpt = new CartDaoImpt();
	CourseDao courseDao = new CourseDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		if (user != null) {
			System.out.println("會員在購物車");
		} else {
			String servletPath = request.getServletPath();
			System.out.println(servletPath);
			request.setAttribute("path", servletPath);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			return;
		}
		String command = request.getParameter("command");
		if (command == null) {
			cartList(request, response);
			return;
		}
		System.out.println(command);
		try {

			switch (command) {
			case "CARTLIST":
				cartList(request, response);
				break;
			case "ADD":
				cartAdd(request, response);
				break;
			case "DELETE":
				cartDelete(request, response);
				break;
			case "CLEAR":
				cartClear(request, response);
				break;
			case "COUNT":
				getCount(request, response);
				break;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void getCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		System.out.println(user.getUser_id());
		List<CartItem> carList = cartDaoImpt.carList(user.getUser_id());
		List countTotal = cartDaoImpt.getCountTotal(carList);
		Gson gson = new Gson();
		String JsonString = gson.toJson(countTotal);
		System.out.println(JsonString);
		response.getWriter().write(JsonString);
	}

	private void cartClear(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		cartDaoImpt.clearCard();
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		request.setAttribute("path", servletPath);
		cartList(request, response);
		// response.sendRedirect(request.getHeader("Referer"));
	}

	private void cartAdd(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		// TODO Auto-generated method stub
		String CartID = request.getParameter("courseID");
		// Course course = dao.queryCourseOne(WebUtils.paseInt(CartID));
		CourseBean course = courseDao.selectById(WebUtils.paseInt(CartID));
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		System.out.println(user.getUser_id() + "!!!!!!!!!!!!!!!!!");
		CartItem cart = new CartItem(0, user.getUser_id(), course.getCourse_id(), course.getCourse_name(), 1,
				course.getCourse_price());
		cartDaoImpt.addCart(cart);
		List<CartItem> cartList = cartDaoImpt.carList(user.getUser_id());
		List countTotal = cartDaoImpt.getCountTotal(cartList);
		request.getSession().setAttribute("count", countTotal.get(1));
		response.sendRedirect(request.getHeader("Referer"));

	}

	private void cartDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("cartID");
		cartDaoImpt.deleteCart(WebUtils.paseInt(id));
		// cartList(request, response);

		System.out.println(request.getContextPath());
		System.out.println(request.getHeader("Referer"));
		response.sendRedirect(request.getHeader("Referer"));
		// response.sendRedirect(request.getContextPath() + "/CartServle");
	}

	private void cartList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBean user = (MemberBean) request.getSession().getAttribute("user");
		System.out.println(user.getUser_id());
		List<CartItem> cartList = cartDaoImpt.carList(user.getUser_id());
		System.out.println(cartList.size());
		request.setAttribute("cartList", cartList);
		// List<Course> CourseList = dao.queryCourseList();
		List<CourseBean> CourseList = courseDao.selectAll();
		List countTotal = cartDaoImpt.getCountTotal(cartList);
		request.getSession().setAttribute("count", countTotal.get(1));
		request.setAttribute("countTotal", countTotal);
		request.setAttribute("course", CourseList);
		request.getRequestDispatcher("/Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
