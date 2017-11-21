package Hoons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	Connection conn = null;

	String tableName = "";

	Dao() {
		this(null, "");
	}

	Dao(String tableName) {
		this(null, tableName);
	}

	Dao(Connection conn, String tableName) {
		this.tableName = tableName;
		if (conn == null) {
			this.conn = DBUtil.getConnection();
		} else {
			this.conn = conn;
		}
	}

	void setConnection(Connection conn) {
		this.conn = conn;
	}

	Connection getConnection() {
		return conn;
	}

}