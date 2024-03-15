package com.peisia.mysqltest;

import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcModify {
	static public void run() {
		String cmd;
		while(true) {
			cmd = Ci.r("수정하기 [1] / 이전 메뉴로 [b]");
			if(cmd.equals("b")) {
				break;
			}
			if(cmd.equals("1")) {
				try {
			        String editNo = Ci.r("수정할 글번호를 입력해주세요:");
			        
			        // 예외 처리를 위한 추가적인 조건 검사
			        if (!editNo.matches("\\d+")) {
			            System.out.println("유효하지 않은 글번호 형식입니다.");
			            continue; // 다음 반복으로 넘어감
			        }

			        int editNoInt = Integer.parseInt(editNo);

			        String edTitle = Ci.rl("제목을 입력해주세요:");
			        String edId = Ci.rl("작성자id를 입력해주세요:");
			        String edContent = Ci.rl("글내용을 입력해주세요:");
			        
			        Db.dbExecuteUpdate("update board set b_title='"+edTitle+"',b_id='"+edId+"',b_datetime=now(),b_text='"+edContent+"' where b_no="+editNoInt);
			    } catch (NumberFormatException e) {
			        System.out.println("숫자로 변환할 수 없는 글번호 형식입니다.");
			    } catch (Exception e) {
			        System.out.println("오류가 발생했습니다: " + e.getMessage());
			    }
			}
		}
	}
}