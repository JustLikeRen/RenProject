package JavaBoardMain;

import JavaBoardId.P_CreateId;
import JavaBoardId.P_IdCheck;
import JavaBoardId.P_MenuIdNon;
import Util.Ci;
import Util.Cw;

public class P_MainMenu {
	
	public static void mainmenurun() {
//		Disp.menuMain();
		startid:
		while(true) {
			
			Cw.wn("id를 입력하시겠습니까? [1]예 [2]아니오 [3]ID만들기 [4]종료");
			String cmd =Ci.r("입력");
			
			switch(cmd) {
			
			case "1":
				P_IdCheck.idcheckrun();
				break;
			case "2":
				Cw.wn("비 로그인으로 진행하겠습니다.");
				P_MenuIdNon.nonidrun();
				break;
			case "3":
				P_CreateId.createidrun();
				break;
			case "4":
				break startid;
			}
		
		}
	}
	
}
