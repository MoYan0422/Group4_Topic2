package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cartdao.BaseDAO;
import dao.logindao;
import memberbean.User;
import util.JdbcUtil;

/**
 * Servlet implementation class loginservlet1
 */
@WebServlet("/loginservlet1")
public class loginservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	logindao logindao = new logindao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginservlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try {
			
			
			
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			System.out.println(account);
			System.out.println(password);
			PrintWriter out = response.getWriter();
			String sql = "select * from member where account =? and password = ? ";
//			PreparedStatement prestate = conn
//					.prepareStatement("select * from member where account =? and password = ? ");
			User user = logindao.checkAccount(account, password);
//			prestate.setString(1, account);
//			prestate.setString(2, password);
//			ResultSet rs = prestate.executeQuery();
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				User u = (User)session.getAttribute("user");
				System.out.println(u.getUser_id());
				String path = request.getParameter("path");
				System.out.println(path);
				request.getRequestDispatcher("/Index.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("login.jsp").include(request, response);
				out.println("<font color=red size=8 >帳號或密碼有誤!!</font>");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
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
