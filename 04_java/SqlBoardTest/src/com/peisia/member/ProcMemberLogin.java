package com.peisia.member;

import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcMemberLogin {
	static public String run() {
		Cw.wn("======== 로그인 =========");
		String id="";
		String pw="";
		while(true) {
			id=Ci.r("아이디");
			if(id.length()>0) {
				break;
			}else {
				Cw.wn("장난x");
			}
		}
		while(true) {
			pw=Ci.r("암호");
			if(pw.length()>0) {
				break;
			}else {
				Cw.wn("장난x");
			}
		}
		if(Db.isProcLogin(id,pw)) {
			return id;
		} else {
			Cw.wn("로그인 실패");
			return null;
		}
	}
}
