package Hoons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection(){
		Connection conn = null;
		
		String DB_DRIVER="com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://127.0.0.1:3306/book_ex?useSSL=false";
		String DB_USER = "zerock"; // DB의 userid와 pwd를 알맞게 변경
		String DB_PASSWORD = "zerock";
		try{
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	static void rollback(Connection conn){
		if(conn!=null){
			try{
				conn.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	static void close(AutoCloseable... acs){
		try{
		if(acs!=null){
				for(AutoCloseable a:acs){
					a.close();
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
}
