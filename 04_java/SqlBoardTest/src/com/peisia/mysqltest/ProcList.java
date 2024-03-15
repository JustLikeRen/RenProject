package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.mysqlconsoleboard.Display;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcList {
	static public final int PER_PAGE = 10;
	
	static public void run() {

		int startIndex = 0;
		int currentPage = 1;

		int totalPage = 0;
		if(Db.getPostCount() % PER_PAGE > 0) {
			totalPage = Db.getPostCount() / PER_PAGE + 1;
		}else {
			totalPage = Db.getPostCount() / PER_PAGE;
		}
		
	Cw.wn("총 페이지 수:"+totalPage);
	
	String cmd;
	while(true) {
		cmd = Ci.r("페이지 번호입력 [1~"+totalPage+"] / 이전 메뉴로 [b]");
		if(cmd.equals("b")) {
			break;
		}
		try {
		currentPage = Integer.parseInt(cmd);
		if(currentPage > totalPage || currentPage < 1) {
			Cw.wn("페이지 범위에 맞는 값을 넣으세요");
			continue;	// 페이지 범위를 초과하거나 0이하의 숫자를 입력할경우 if문을 반복하도록
			}
		} catch(NumberFormatException e) {
			Cw.wn("제대로된 숫자를 입력해주세요");
			continue; //문자열을 입력했을때 Exception이 나오는것을 해결해서 if문을 반복
		}
		
		
		startIndex = (currentPage - 1) * PER_PAGE;
		Display.titleList();
//		String sql1 = "select * from board limit "+startIndex+","+PER_PAGE;
		String sql1 = "select * from board where b_delno=0 and b_reply_ori is null limit "+startIndex+","+PER_PAGE;
	
		try {
//			System.out.println("전송한sql문:"+sql1);
			Db.result = Db.st.executeQuery(sql1);
			while(Db.result.next()) {
				String no  = Db.result.getString("b_no");
				String title  = Db.result.getString("b_title");
				String datetime  = Db.result.getString("b_datetime");
				String text = Db.result.getString("b_text");
				String id  = Db.result.getString("b_id");
				
				System.out.println(no+" "+title+" "+id+" "+text+" "+datetime);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	}
}
