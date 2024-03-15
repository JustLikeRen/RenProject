package com.peisia.mysqltest;

import com.peisia.member.ProcMemberLogin;
import com.peisia.member.ProcMemberRegister;
import com.peisia.mysqltest.ProcBoard;
import com.peisia.mysqlconsoleboard.Display;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class siteMain {
	static private String cmd = "";
	static public String LoginedId = null;
	
	static public void run() {
		Db.dbInit();
		
		loop:while(true) {
			Display.showTitle();
			Display.showMainMenu();
			if(LoginedId==null) {
				cmd=Ci.r("[1]회원가입 [2]로그인 [e]프로그램종료");
			} else {
				Cw.wn(LoginedId+"님 어서오세요.");
				cmd=Ci.r("[2]로그아웃 [b]게시판 [a]관리자 [e]프로그램종료");
			}
			switch(cmd) {
			case "1":
				if(LoginedId==null) {
					ProcMemberRegister.run();
				} else {
					Cw.wn("장난x");
				}break;
			case "2":
				if(LoginedId==null) {
					LoginedId = ProcMemberLogin.run();
				} else {
					Cw.wn("[로그아웃 됨]");
					LoginedId = null;
				}break;
			case "a":
				break;
			case "e":
				Cw.wn("프로그램 종료");
				break loop;
			case "b":
				if(LoginedId==null) {
					Cw.wn("장난x");
				} else {
					ProcBoard.run();
				}break;
			default:
				Cw.wn("장난x");
			}
		}
	}
}
