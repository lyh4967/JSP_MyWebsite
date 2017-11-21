package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpSession session=httpRequest.getSession(false);
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		boolean login=false;
		if(session!=null){
			if(session.getAttribute("id")!=null){
				login =true;
			}
		}
		if(login){
			chain.doFilter(request, response);
		}else{
			httpResponse.sendRedirect("/myWebSite/login/Login.jsp?target="+httpRequest.getRequestURI());

		}
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException{
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
}