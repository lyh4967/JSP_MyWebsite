package Hoons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao{

	private static UserDao instance=null;
	private UserDao(){super();}
	
	public static  UserDao getInstance(){
		if(instance==null)
			instance=new UserDao();
		else{
			/*instance.setConnection();*/
		}
		return instance;
	}
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public List<User> selectAllUsers(){
		String id="";
		String pw="";
		String username="";
		String email="";
		
		List arrMember=new ArrayList();
		
		String query = "SELECT * FROM tbl_member ";
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			// SQL문을 실행한다.

			rs = pstmt.executeQuery();

			System.out.println("쿼리 성공~");

			while (rs.next()) {
				id=rs.getString("userid");
				pw = rs.getString("userpw");
				username = rs.getString("username");
				email = rs.getString("email");
				
				User u=new User(id,username,pw,email);
				
				arrMember.add(u);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt,rs);
		}
		return arrMember;
	}
	public void deleteUser(String userId){	
		String query = "DELETE FROM tbl_member  WHERE userid='" + userId + "'";
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
		
	
			pstmt.executeUpdate();// SQL문을 실행한다.

			System.out.println("쿼리 성공~");

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt,rs);
		}
	}
	public int updateUser(User u) {

		String query = "UPDATE tbl_member SET PASSWORD=?,NAME=?,EMAIL=? WHERE userid='" + u.getId() + "'";
		System.out.println(query);
		try {
			
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			pstmt.setString(1, u.getPwd());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getEmail());

			pstmt.executeUpdate();// SQL문을 실행한다.

			System.out.println("쿼리 성공~");

			/*
			 * while (rs.next()) { pw = rs.getString("PASSWORD"); name =
			 * rs.getString("NAME"); email = rs.getString("EMAIL");
			 * 
			 * }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
		}
		return 0;
	}

	public int insertUser(User u) {

		String query = "INSERT INTO tbl_member (userid, userpw, username, email)" + " VALUES(?,?,?,?)";
		System.out.println(query);
		try {
																				
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			// SQL문을 실행한다.
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getPwd());
			pstmt.setString(3, u.getName());
			pstmt.setString(4, u.getEmail());
			pstmt.executeUpdate();
			System.out.println("쿼리 성공~");
			/*
			 * while (rs.next()) { String curDate = rs.getString(1);
			 * System.out.println(curDate); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
		}
		return 0;

	}
	public User selectUser(String userId) {

		String pw = "";
		String username = "";
		String email = "";
		String query = "SELECT * FROM tbl_member WHERE userid='" + userId + "'";
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			// SQL문을 실행한다.

			rs = pstmt.executeQuery();

			System.out.println("쿼리 성공~");

			while (rs.next()) {
				pw = rs.getString("userpw");
				username = rs.getString("username");
				email = rs.getString("eamil");

			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt,rs);
		}
		User u = new User(userId, username, pw, email);
		return u;
	}

}