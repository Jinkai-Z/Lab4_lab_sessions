package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private AccountService accountService=new AccountService();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("loginUser");
		request.getSession().setAttribute("error_msg", "you havae succefully logged out");
		response.sendRedirect("/Week04Lab_Sessions_and_Authentication/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		if(username==null||password==null) {
			request.getSession().setAttribute("error_msg", "please input right username or password!");
			return;
		}
		
		User loginUser=accountService.login(username, password);
		
		if(loginUser==null) {
			request.getSession().setAttribute("error_msg", "user doesn't exist!");
			return;
		}
		
		request.getSession().setAttribute("loginUser", loginUser);
		
		response.sendRedirect("/Week04Lab_Sessions_and_Authentication/HomeServlet");
	}

}