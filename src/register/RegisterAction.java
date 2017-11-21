package register;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hoons.User;
import Hoons.UserDao;
/**
 * Servlet implementation class ResgisterAction
 */
@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Connection conn=(Connection) session.getAttribute("conn");
		User u=new User();
		UserDao UD=UserDao.getInstance();
		u.setId(request.getParameter("id"));
		u.setPwd(request.getParameter("pw"));
		u.setName(request.getParameter("username"));
		u.setEmail(request.getParameter("email"));
		System.out.println(u.getId());
		
		UD.insertUser(u);
		response.sendRedirect("myWebSite/index.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
