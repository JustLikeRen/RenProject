package JavaBoardId;

import Display.Disp;
import JavaBoardAndWriteAndRead.P_MenuIdWrite;
import JavaBoardAndWriteAndRead.P_MenuList;
import JavaBoardAndWriteAndRead.P_MenuNonIdWrite;
import JavaBoardAndWriteAndRead.P_MenuRead;
import JavaBoardDelAndEdit.P_MenuDelAndEdit;
import JavaBoardDelAndEdit.P_MenuRestore;
import JavaFunsionData.BoradFunsion;
import Util.Ci;
import Util.Cw;

public class P_MenuIdList {
	
	public static void menuidlistrun() {
		
		startmenu:
			while(true) {
				Disp.menuMain();
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
					P_MenuIdWrite.menuidwriterun();
					break ;
					
				case "3":
					P_MenuNonIdWrite.menuwriterun();
					break ;
					
				case "4":
					if(!BoradFunsion.listdata.isEmpty()) {
						P_MenuDelAndEdit.delandeditrun();
					}else {
						Cw.wn("저장된 글이 없습니다!");
					}
					break ;
					
				case "5":
					P_MenuRestore.menurestorerun();
					break;
					
				case "e":
					Cw.wn("로그아웃합니다.");
					break startmenu;
					
				default:
					Cw.wn("정해진 명령문을 입력해주세요!");
					break;
					
				}
			}
		
	}
}
