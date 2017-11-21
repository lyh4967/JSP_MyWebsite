package Hoons;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class BoardDao extends Dao { // 커넥션을 상속받은 값으로 쓰다보면 값이 제대로 안넘어올 수 있다.
	// conn을 인자로 받아와 Dao에 넣어 객체 생성
	BoardDao(/*Connection conn*/) {
		super("BOARD");
	}

	// Singleton 사용 객체생성
	private static BoardDao instance = null;

	public static BoardDao getInstance(/*Connection conn*/) {// 인스턴스 객체 생성
		if (instance == null)// 인스턴스가 없다면 새로운 인스턴스 생성
			instance = new BoardDao(/*conn*/);
		else { // 인스터스가 있다면 기존에 있던 객체의 conn을 바꾼다
		/*	instance.setConnection(conn);*/
		}
		return instance;
	}

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int insertWriting(Writing w) {// 글 객체를 받아와 DB에 삽입

		// 시퀀스를 사용하여 글 삽입
		String query = "INSERT INTO BOARD (ID,TITLE, WRITER, CONTENT,COUNT)" + " VALUES(table_seq.nextval,?,?,?,?)";
		System.out.println(query);
		try {
			System.out.println();
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.

			// pstmt에 글데이터 셋팅
			pstmt.setString(1, w.getTitle());
			pstmt.setString(2, w.getWriter());
			pstmt.setString(3, w.getContent());
			pstmt.setInt(4, w.getCount());
			pstmt.executeUpdate();// 쿼리문 실행
			System.out.println("쿼리 성공~");
			/*
			 * while (rs.next()) { String curDate = rs.getString(1);
			 * System.out.println(curDate); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {// 수동으로 닫아준다.
				pstmt.close();
				/*conn.close();*/
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return 0;

	}

	public Writing selectWriting(String title) {// 제목을 받아와 DB에 정보 조회
		Writing w=new Writing();
		String query = "SELECT * FROM BOARD WHERE TITLE='" + title + "'";
		System.out.println(query);
		int index=0;
		String writer="";
		Date date=new java.sql.Date(new java.util.Date().getTime());
		int count=0;
		String content="";
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			
			
			// SQL문을 실행한다
			rs = pstmt.executeQuery();
			System.out.println("쿼리 성공~");
			
			while(rs.next()){
			//rs에서 데이터를 가져와 세팅한다.
			index = rs.getInt("ID");
			writer = rs.getString("WRITER");
			date = rs.getDate("W_DATE");
			count = rs.getInt("COUNT");
			content = rs.getString("CONTENT");
		
			}
			count++;//selectWriting메서드 수행시 조회수 증가
			
			//증가한 조회수를 업데이트한다.
			//업데이트 쿼리까지 반복문에 넣으면 에러가 발생한다. 
			query = "UPDATE BOARD SET COUNT=? WHERE TITLE='" + title + "'";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, count);
			rs = pstmt.executeQuery();
			
			//Writing 참조변수에 writing를 담는다.
			w = new Writing(index, title, writer, date, count, content);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//사용한 DB사용 객체를 닫는다.
			DBUtil.close(pstmt, conn, rs);
		}
		
		return w;

	}

	public List<Writing> selectAllWritings() {
		int index = 0;
		String title = "";
		String writer = "";
		Date date = new Date(index);
		int count = 0;
		String content = "";

		List arrWriting = new ArrayList();

		String query = "SELECT * FROM BOARD ORDER BY W_DATE DESC";
		System.out.println(query);
		try {
			System.out.println("여기가문제냐1");
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			System.out.println("여기가문제냐2");
			// SQL문을 실행한다.

			rs = pstmt.executeQuery();

			System.out.println("쿼리 성공~");

			while (rs.next()) {
				index = rs.getInt("ID");
				title = rs.getString("TITLE");
				writer = rs.getString("WRITER");
				date = rs.getDate("W_DATE");
				count = rs.getInt("COUNT");
				content = rs.getString("CONTENT");

				Writing w = new Writing(index, title, writer, date, count, content);

				arrWriting.add(w);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return arrWriting;
	}

	public void deleteWriting(String title) {
		String query = "DELETE FROM BOARD  WHERE title='" + title + "'";
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query); // Statement를 가져온다.

			pstmt.executeUpdate();// SQL문을 실행한다.

			System.out.println("쿼리 성공~");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	public int updateUser(Writing w) {

		String query = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE TITLE='" + w.getTitle() + "'";
		System.out.println(query);
		try {

			pstmt = conn.prepareStatement(query); // Statement를 가져온다.
			pstmt.setString(1, w.getTitle());
			pstmt.setString(2, w.getContent());
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
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return 0;
	}
}
