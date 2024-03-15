package com.peisia.mysqltest;


import com.peisia.mysqlconsoleboard.Display;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcBoard {
	
	public static void run() {
		Display.showTitle();
		Display.showMainMenu();
//		Db.dbInit();
		Db.getPostCount();
		
		loop:
		while(true) {
			Db.dbPostCount();
			System.out.println("[1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정 [0]관리자 [e]프로그램종료");
			String cmd=Ci.r("명령입력:");
			switch(cmd) {
			case "1":	//글리스트
				ProcList.run();
				break;
			case "2":	//글읽기
				ProcRead.run();
				break;
			case "3":	//글쓰기
				ProcWrite.run();
				break;
			case "4":	//글삭제
				ProcDel.run();
				break;
			case "5": //글수정
				ProcModify.run();
				break;
			case "0":	//관리자
				break;
			case "e":	//프로그램 종료
				System.out.println("프로그램종료");
				break loop;
			}
		}
	}
}
//	private void dbInit() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	private void dbInit() {
//		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
//			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
		
//	private void dbExecuteUpdate(String query) {
//		try {
//			int resultCount = st.executeUpdate(query);
//			System.out.println("처리된 행 수:"+resultCount);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}	
////}