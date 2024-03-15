package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcDel {
	static public void run() {
		String cmd;
		String postDel; 
		String postRestore;
			
	loop:while (true) {
		cmd = Ci.r("명령[1:글삭제 / 2:글복구 / x:뒤로가기]");
		switch (cmd) {
		case "1":
			postDel = Ci.r("삭제할 굴번호를 입력하세요:");
			String dbdel = "update board set b_delno=1 where b_no="+postDel;
			System.out.println(dbdel);
			Db.dbExecuteUpdate(dbdel);
			
		break;
		case "2":
			String sql2 = "select * from board where b_delno=1";
			
			try {
//				System.out.println("전송한sql문:"+sql1);
				Db.result = Db.st.executeQuery(sql2);
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
			postRestore = Ci.r("복구할 글번호를 입력하세요");
			String dbRestore = "update board set b_delno=0 where b_no="+postRestore;
			Db.dbExecuteUpdate(dbRestore);
			break;
		case "x" :
			break loop;
		default :
			Cw.wn("잘못된 입력입니다.");
			}
		}
	}
}
