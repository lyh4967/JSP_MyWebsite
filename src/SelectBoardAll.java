

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hoons.BoardDao;
import Hoons.Writing;

@WebServlet("/SelectBoardAll")
public class SelectBoardAll extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Connection conn=(Connection) session.getAttribute("conn");
		System.out.println(conn);
		
		BoardDao BD=BoardDao.getInstance(/*conn*/);
		List<Writing> list=new ArrayList();
		list=BD.selectAllWritings();
		session.setAttribute("list", list);
		response.sendRedirect("/myWebSite/Table.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
