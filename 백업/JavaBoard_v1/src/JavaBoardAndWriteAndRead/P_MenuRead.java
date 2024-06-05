package JavaBoardAndWriteAndRead;

import JavaFunsionData.BoradFunsion;
import JavaFunsionData.DataForBorad;
import JavaFunsionData.Product;
import Util.Ci;
import Util.Cw;

public class P_MenuRead {

	public static void menureadrun() {

		readstart: 
			while (true) {
			String cmd = Ci.r("[번호입력]적혀있는 내용보기 [b]뒤로가기");
			boolean foundd = false;
			int read_number = 0;
			switch (cmd) {
			case "b":
				foundd = true;
				break readstart;

			}
			for (int i = 0; i < BoradFunsion.countdata.size(); i++) {
				Product read_list = BoradFunsion.listdata.get(i);
				read_number = i + 1;

				// int 변수 +"" 하면 equals 문에서 문자열로 반환됨
				if (cmd.equals(read_number + "")) {
					Cw.wn("No." + read_number + " ");
					Cw.w("제목:" + read_list.title + " ");
					Cw.wn("작성자:" + read_list.write);
					Cw.w("작성일:" + DataForBorad.date +"/");
					Cw.wn("조회수:" + DataForBorad.view_limit);
					Cw.wn("내용:" + read_list.content);
					foundd = true;
					break;
				}
			}
			if(!foundd) {
				Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println("저장되어있지 않은 글입니다.");
				Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");
			}
		}
	}

}
