package Hoons;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class BoardDao extends Dao { // Ŀ�ؼ��� ��ӹ��� ������ ���ٺ��� ���� ����� �ȳѾ�� �� �ִ�.
	// conn�� ���ڷ� �޾ƿ� Dao�� �־� ��ü ����
	BoardDao(/*Connection conn*/) {
		super("BOARD");
	}

	// Singleton ��� ��ü����
	private static BoardDao instance = null;

	public static BoardDao getInstance(/*Connection conn*/) {// �ν��Ͻ� ��ü ����
		if (instance == null)// �ν��Ͻ��� ���ٸ� ���ο� �ν��Ͻ� ����
			instance = new BoardDao(/*conn*/);
		else { // �ν��ͽ��� �ִٸ� ������ �ִ� ��ü�� conn�� �ٲ۴�
		/*	instance.setConnection(conn);*/
		}
		return instance;
	}

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int insertWriting(Writing w) {// �� ��ü�� �޾ƿ� DB�� ����

		// �������� ����Ͽ� �� ����
		String query = "INSERT INTO BOARD (ID,TITLE, WRITER, CONTENT,COUNT)" + " VALUES(table_seq.nextval,?,?,?,?)";
		System.out.println(query);
		try {
			System.out.println();
			pstmt = conn.prepareStatement(query); // Statement�� �����´�.

			// pstmt�� �۵����� ����
			pstmt.setString(1, w.getTitle());
			pstmt.setString(2, w.getWriter());
			pstmt.setString(3, w.getContent());
			pstmt.setInt(4, w.getCount());
			pstmt.executeUpdate();// ������ ����
			System.out.println("���� ����~");
			/*
			 * while (rs.next()) { String curDate = rs.getString(1);
			 * System.out.println(curDate); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {// �������� �ݾ��ش�.
				pstmt.close();
				/*conn.close();*/
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return 0;

	}

	public Writing selectWriting(String title) {// ������ �޾ƿ� DB�� ���� ��ȸ
		Writing w=new Writing();
		String query = "SELECT * FROM BOARD WHERE TITLE='" + title + "'";
		System.out.println(query);
		int index=0;
		String writer="";
		Date date=new java.sql.Date(new java.util.Date().getTime());
		int count=0;
		String content="";
		try {
			pstmt = conn.prepareStatement(query); // Statement�� �����´�.
			
			
			// SQL���� �����Ѵ�
			rs = pstmt.executeQuery();
			System.out.println("���� ����~");
			
			while(rs.next()){
			//rs���� �����͸� ������ �����Ѵ�.
			index = rs.getInt("ID");
			writer = rs.getString("WRITER");
			date = rs.getDate("W_DATE");
			count = rs.getInt("COUNT");
			content = rs.getString("CONTENT");
		
			}
			count++;//selectWriting�޼��� ����� ��ȸ�� ����
			
			//������ ��ȸ���� ������Ʈ�Ѵ�.
			//������Ʈ �������� �ݺ����� ������ ������ �߻��Ѵ�. 
			query = "UPDATE BOARD SET COUNT=? WHERE TITLE='" + title + "'";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, count);
			rs = pstmt.executeQuery();
			
			//Writing ���������� writing�� ��´�.
			w = new Writing(index, title, writer, date, count, content);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//����� DB��� ��ü�� �ݴ´�.
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
			System.out.println("���Ⱑ������1");
			pstmt = conn.prepareStatement(query); // Statement�� �����´�.
			System.out.println("���Ⱑ������2");
			// SQL���� �����Ѵ�.

			rs = pstmt.executeQuery();

			System.out.println("���� ����~");

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
			pstmt = conn.prepareStatement(query); // Statement�� �����´�.

			pstmt.executeUpdate();// SQL���� �����Ѵ�.

			System.out.println("���� ����~");

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

			pstmt = conn.prepareStatement(query); // Statement�� �����´�.
			pstmt.setString(1, w.getTitle());
			pstmt.setString(2, w.getContent());
			pstmt.executeUpdate();// SQL���� �����Ѵ�.

			System.out.println("���� ����~");

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
