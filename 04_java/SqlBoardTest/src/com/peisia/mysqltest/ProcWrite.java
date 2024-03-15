package com.peisia.mysqltest;

import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcWrite {
	static public void run() {
	String cmd;
	while(true) {
		cmd = Ci.r("글쓰기 [1] / 이전 메뉴로 [b]");
		if(cmd.equals("b")) {
			break;
		}
		if(cmd.equals("1")) {
			try {
			String title = Ci.rl("제목을 입력해주세요:");
			String content = Ci.r("글내용을 입력해주세요:");
			String id = "select * from sign where c_id";
			String sql;
			sql = String.format("insert into board (b_title,b_id,b_datetime,b_text,b_hit,b_delno)"
					+" values ('"+title+"','"+id+"',now(),'"+content+"',0,0)");
			Db.dbExecuteUpdate(sql);
			} catch (Exception e) {
				}
			}else {
				Cw.wn("제대로 입력해주세요.");
			}
		}
	}
}