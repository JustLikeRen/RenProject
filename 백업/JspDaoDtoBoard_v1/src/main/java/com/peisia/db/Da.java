package com.peisia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Da {
	Connection con=null;
	PreparedStatement ps = null;
	protected void connect(String x) {
		try {
			////고정 1
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			////고정 2
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////고정 3
			ps=con.prepareStatement(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void update(String sql) {
		try {
			ps.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void close() {
		try {
			////고정 4
			ps.close();
			////고정 5
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
