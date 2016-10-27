package esd.scos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidator
 */
@WebServlet("/LoginValidator")
public class LoginValidator extends HttpServlet {

	private static final String name = "wangcong";	// 用户名
	private static final String pwd = "123456";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		// 获取输入的客户端参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (this.name.equals(userName) && this.pwd.equals(password)) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}

}
