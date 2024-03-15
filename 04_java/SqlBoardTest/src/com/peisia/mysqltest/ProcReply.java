package com.peisia.mysqltest;

import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcReply {
	static public void list(int oriNo) {
		Cw.wn("================= 댓글 리스트 ==================");
		String sql = "select * from board where b_delno=0 and b_no="+oriNo+" and b_reply_ori=" + oriNo;
		try {
			Cw.wn("전송한sql문:" + sql);
			Db.result = Db.st.executeQuery(sql);
			while (Db.result.next()) {
				String b_reply_text = Db.result.getString("b_reply_text");
				Cw.wn(b_reply_text);
			}
		} catch (Exception e) {

		}
	}

	static public void write(int b_reply_ori) {
		String b_reply_text = Ci.rl("댓글입력");
		Db.dbExecuteUpdate("insert into board (b_id,b_datetime,b_reply_ori,b_reply_text,b_delno) values('댓글러',now(),"
				+ b_reply_ori + ",'" + b_reply_text + "',0)");
	}
}
