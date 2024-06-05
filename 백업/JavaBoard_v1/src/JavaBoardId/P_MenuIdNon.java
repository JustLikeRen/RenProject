package JavaBoardId;

import Display.Disp;
import JavaBoardAndWriteAndRead.P_MenuList;
import JavaBoardAndWriteAndRead.P_MenuRead;
import JavaBoardAndWriteAndRead.P_MenuNonIdWrite;
import JavaBoardDelAndEdit.P_MenuDelAndEdit;
import JavaFunsionData.BoradFunsion;
import Util.Ci;
import Util.Cw;

public class P_MenuIdNon {

	public static void nonidrun() {
		
		startmenu:
			while(true) {
				
				Disp.menuMainnonid();
				String cmd =Ci.r("입력");
				
				switch(cmd) {
				
				case "1":
					if(!BoradFunsion.listdata.isEmpty()) {
					P_MenuList.menulistrun();
					P_MenuRead.menureadrun();
					}else {
						Cw.wn("저장된 글이 없습니다!");
					}
					break ;
					
				case "2":
					P_MenuNonIdWrite.menuwriterun();
					break ;
												
				case "e":
					Cw.wn("프로그램을 종료하겠습니다.");
					break startmenu;
					
				default:
					Cw.wn("정해진 명령문을 입력해주세요!");
					break;
					
				}
			}
		
	}
}
