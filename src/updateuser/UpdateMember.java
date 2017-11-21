package updateuser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hoons.User;
import Hoons.UserDao;

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/UpdateMember")
public class UpdateMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Connection conn=(Connection) session.getAttribute("conn");
		User u=new User();
		UserDao UDao=UserDao.getInstance();
		u.setId((String)session.getAttribute("id"));
		u.setPwd((String)request.getParameter("pw"));
		u.setName((String)request.getParameter("username"));
		u.setEmail((String)request.getParameter("email"));
		request.setCharacterEncoding("utf-8");
		
		UDao.updateUser(u);
		
		
		response.sendRedirect("myWebSite/index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
