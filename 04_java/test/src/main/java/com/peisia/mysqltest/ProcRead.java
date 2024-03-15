package com.peisia.mysqltest;

import com.peisia.util.Db;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcRead {
	public static void run() {
		String cmd;
		String readNo;
		while (true) {
			readNo = Ci.r("읽으실 글 번호를 입력해주세요");
			try {
				if (!readNo.matches("\\d+")) {
					Cw.wn("유효하지 않는 번호입니다.");
					continue;
				}
				Db.dbExecuteQuery("select * from board where b_delno=0 and b_no=" + readNo);
				ProcReply.list(Integer.parseInt(readNo));
				break;
				
			} catch (NumberFormatException e) {
				Cw.wn("숫자형식이 아닙니다.");
			}
		}
		loop: while (true) {
			cmd = Ci.r("명령[x:나가기 / r:댓글쓰기]");
			switch (cmd) {
			case "x":
				break loop;
			case "r":
				ProcReply.write(Integer.parseInt(readNo));
				break;
			default:
				Cw.wn("잘못된 입력입니다.");
			}
		}
	}
}
