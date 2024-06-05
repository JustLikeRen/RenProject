package JavaBoardDelAndEdit;

import java.util.Scanner;

import JavaBoardAndWriteAndRead.P_MenuList;
import JavaFunsionData.BoradFunsion;
import JavaFunsionData.Product;
import Util.Ci;
import Util.Cw;

public class P_MenuEditPost {

	//글 수정하는곳
	static void menueditpostrun() {
		
		Scanner sc = new Scanner(System.in);
		if(!BoradFunsion.listdata.isEmpty()) {
			
		editstart: 
			while (true) {
				
			P_MenuList.menulistrun();
			String cmd = Ci.r("수정할글번호 입력 [b]뒤로가기");
			boolean foundd = false;
			int edit_number = 0;
			switch (cmd) {
			case "b":
				break editstart;

			}
			for (int i = 0; i < BoradFunsion.countdata.size(); i++) {
				Product edit_list = BoradFunsion.listdata.get(i);
				edit_number = i + 1;
				
				// int 변수 +"" 하면 equals 문에서 문자열로 반환됨
				if (cmd.equals(edit_number + "")) {
					foundd = true;
					Cw.wn("원문제목:");
					Cw.wn(edit_list.title);
					Cw.wn("----------------------");
					Cw.wn("수정할 제목을 입력해주세요!");
					
					String title = sc.nextLine();
					edit_list.title = title;
					
					Cw.wn("수정한제목:");
					Cw.wn(edit_list.title);
					Cw.wn("---------수정완료---------");
					// 어쩌다보니까 됐는데 좀 질문해야함.
				}
				if (cmd.equals(edit_number + "")) {
					foundd = true;
					Cw.wn("원문내용:");
					Cw.wn(edit_list.content);
					Cw.wn("----------------------");
					Cw.wn("수정할 내용을 입력해주세요!");
					
					String content = sc.nextLine();
					edit_list.content = content;
					
					Cw.wn("수정한내용:");
					Cw.wn(edit_list.content);
					Cw.wn("---------수정완료---------");
				}
				
				if (cmd.equals(edit_number + "")) {
					foundd = true;
					Cw.wn("원문내용:");
					Cw.wn(edit_list.write);
					Cw.wn("----------------------");
					Cw.wn("수정할 작성자를 입력해주세요!");
					
					String write = sc.nextLine();
					edit_list.write = write;
					
					Cw.wn("수정한내용:");
					Cw.wn(edit_list.write);
					Cw.wn("---------수정완료---------");
				}
				if(!foundd) {
					Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");
					System.out.println("올바른 명령어가 아닙니다!");
					Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");
				}
				
			}
			
		}
		
		
	}else {
		Cw.wn("저장된 글이 없습니다!");
	}
	
	}
}
