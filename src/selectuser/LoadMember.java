package selectuser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hoons.User;
import Hoons.UserDao;

/**
 * Servlet implementation class LoadMember
 */
@WebServlet("/LoadMember")
public class LoadMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
	
		User u=new User();
		UserDao UD=UserDao.getInstance();
		String id=(String)session.getAttribute("id");
		u=UD.selectUser(id);
		
		session.setAttribute("u",u);
		
		response.sendRedirect("myWebSite/updatemember/UpdateMember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
