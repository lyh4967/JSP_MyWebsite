package DBListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class DBCPInitListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce){
		try{
			ServletContext context=sce.getServletContext();
			String drivers=context.getInitParameter("jdbcdriver");
			Class.forName(drivers);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public void contextDestroyed(ServletContextEvent sce){
	}
}
