package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hoons.Cookies;
import Hoons.DBService;
import Hoons.DBUtil;
import Hoons.User;
import Hoons.UserDao;



@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		String idset=request.getParameter("idSet");
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(600);
		String target=request.getParameter("target");
		System.out.println(target);
		Cookie[] cookiearr=request.getCookies();
		request.setCharacterEncoding("utf-8");
		try{
			session.setAttribute("conn", DBUtil.getConnection());
		}catch(Exception e){
			e.printStackTrace();
		}
		UserDao UD=UserDao.getInstance();
        System.out.println(target);
        User u=UD.selectUser(id);
            if (u.getPwd()!=""){
    			session.setAttribute("id",id);
    			if(idset!=null){
    				response.addCookie(Cookies.createCookie("id", id,"/",3600*24*30));
    			}else{
    				for(int i=0;i<cookiearr.length;i++){
    					if(cookiearr[i].getName().equals("id")){
    						Cookie cookie=new Cookie("id","");
    						cookie.setMaxAge(0);
    						response.addCookie(cookie);
    					}
    				}
    			}
    			if(target.equals("null")||target.equals("")){
    				response.sendRedirect("/myWebSite/index.jsp");	
    			}else{
    				response.sendRedirect(target);
    			}
    		}
    		else {
    			/*response.sendRedirect(target);*/
				request.setAttribute("msg", "id 또는 비밀번호가 틀렸습니다.");		
				RequestDispatcher reqDis= request.getRequestDispatcher("/myWebSite/login/Login.jsp");
				 reqDis.forward(request, response);
    		}
       
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
