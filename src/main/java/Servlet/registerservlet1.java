package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import memberbean.User;

/**
 * Servlet implementation class registerservlet1
 */
@WebServlet("/register")
public class registerservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private registerdao registerdao=new registerdao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerservlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String account=request.getParameter("account");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	
	 User user=new User();
	 user.setAccount(account);
	 user.setPassword(password);
	 user.setEmail(email);
	try {
		
		registerdao.registeruser(user);
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 response.sendRedirect("");
	 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
