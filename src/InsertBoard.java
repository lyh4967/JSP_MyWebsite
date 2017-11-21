

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hoons.BoardDao;
import Hoons.DBUtil;
import Hoons.Writing;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/InsertBoard")
public class InsertBoard extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
//		Connection conn=DBUtil.getConnection();
		BoardDao BD=BoardDao.getInstance();
		Writing w=new Writing();
		
		
		//Writer.jsp���� ���ƿ� �Ķ���͸� �޾ƿ´�
		String title=request.getParameter("title");
		String writer=(String)session.getAttribute("id");
		String content=request.getParameter("textarea");
		System.out.println("title: "+title+" writer: "+writer+" content: "+content);
		
		//�� ��ü�� setter�� ����Ѵ�
		w.setTitle(title);
		w.setWriter(writer);
		w.setContent(content);
		
		//DB�� �Է�  BoardDao=>insertWriting(w)
		BD.insertWriting(w);  
		
		response.sendRedirect("/myWebSite/table/Table.jsp");// �����ͺ��̽��� �� ����� �Խ������� �����̷�Ʈ
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
