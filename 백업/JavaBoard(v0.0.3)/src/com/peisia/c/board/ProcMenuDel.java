package com.peisia.c.board;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuDel {
	static void run() {
	    Cw.wn("삭제임");
        String cmd = Ci.r("삭제할 글 번호");
        ////    1.삭제할 글 찾기(바로 삭제하지 말고)  ////
        // *주의* 바로 삭제 시 문제가 생길 수 있음 //
        //// 옛날 for문 방식 ////
        int tempSearchIndex = -1;
        for(int i=0;i<Data.posts.size();i=i+1) {
            if(cmd.equals(Data.posts.get(i).instanceNo+"")) {
                tempSearchIndex = i;
                break; // 찾았으면 반복문 탈출
            }
        }
        ////    2.삭제하기(바로 삭제하지 말고)  ////
        if (tempSearchIndex!=-1) {
            // temSearchIndex가 유효한 범위 내에 있는 경우에만 삭제
        Data.posts.remove(tempSearchIndex);
        Cw.wn("글 수:"+Data.posts.size());
        } else {
            // 유효한 범위 내에 업는 경우에 대한 처리
            Cw.wn("삭제할 글이 존재하지 않습니다.");
        }
	}

}
