

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
		
		
		//Writer.jsp에서 날아온 파라미터를 받아온다
		String title=request.getParameter("title");
		String writer=(String)session.getAttribute("id");
		String content=request.getParameter("textarea");
		System.out.println("title: "+title+" writer: "+writer+" content: "+content);
		
		//글 객체에 setter를 사용한다
		w.setTitle(title);
		w.setWriter(writer);
		w.setContent(content);
		
		//DB에 입력  BoardDao=>insertWriting(w)
		BD.insertWriting(w);  
		
		response.sendRedirect("/myWebSite/table/Table.jsp");// 데이터베이스에 글 등록후 게시판으로 리다이렉트
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
