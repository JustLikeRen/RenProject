package com.peisia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.peisia.util.Db;

public class Db {
	static public Connection con = null;
	static public Statement st = null;
	static public ResultSet result = null;
	static public void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	static public void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			Cw.wn("처리된 행 수:"+resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public void dbPostCount() {	
		try {
			result = st.executeQuery("select count(*) from board where b_delno=0");
			result.next();
			String count = result.getString("count(*)");
			Cw.wn("글 수:"+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public int getPostCount() {
		String count = "";
		try {
			result = st.executeQuery("select count(*) from board where b_delno=0");
			result.next();
			count = result.getString("count(*)");
			Cw.wn("글 수:"+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		return intCount;
	}
	static public void dbExecuteQuery(String query) {
		try {
			result = st.executeQuery(query);
			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				String number = result.getString("b_no");	// b_number 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println("글번호: "+number);
				String id12 = result.getString("b_id");	// b_id 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println("ID: "+id12);
				String title1 = result.getString("b_title");	// b_title 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println("글제목: "+title1);
				String text1 = result.getString("b_text");	// b_text 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println("글내용: "+text1);
				String date1 = result.getString("b_datetime");	// b_datetime 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println("업로드시간: "+date1);
				String hit1 = result.getString("b_hit");	// b_hit 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println("조회수: "+hit1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public int getPostCountSearch(String searchWord) {
		String count = "";
		try {
			Db.result = Db.st.executeQuery(
					"select count(*) from board where b_reply_ori is null"
					+
					" and b_title like '%"+searchWord+"%'"
			);
			Db.result.next();
			count = Db.result.getString("count(*)");
			Cw.wn("글 수:"+count);
		} catch (Exception e) { e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		return intCount;
	}
	/* 로그인 처리 */
	static public boolean isProcLogin(String id, String pw) {
		String count = "";
		try {
			Db.result = Db.st.executeQuery(
					"select count(*) from sign where c_id='"
					+id+
					"' and c_pw='"
					+pw+
					"'"
					);
			Db.result.next();
			count = Db.result.getString("count(*)");
			Cw.wn("찾은 회원 수:"+count);
		} catch (Exception e) { e.printStackTrace();
		}
		if(count.equals("1")) {
			Cw.wn("[로그인 성공]");
			return true;	//로그인 성공
		}else {
			Cw.wn("[로그인 실패]");
			return false;	//로그인 실패
		}
	}
}

