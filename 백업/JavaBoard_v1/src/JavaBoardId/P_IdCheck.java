package JavaBoardId;

import java.util.Scanner;

import JavaBoardMain.P_MainMenu;
import JavaFunsionData.BoradFunsion;
import JavaFunsionData.Product;
import Util.Cw;

public class P_IdCheck {
	
	public static String idwiter = "";
	
	public static void idcheckrun() {
		
		Cw.wn("아이디를 입력해주세요!");
		
		Scanner sc = new Scanner(System.in);
		String cmd = sc.nextLine();
		boolean idExists = false;
		
		for (int i = 0; i < BoradFunsion.idcount.size(); i++) {
			
			Product idpin = BoradFunsion.idcount.get(i);
			Product pwpin = BoradFunsion.pwcount.get(i);
			
	        if (cmd.equals(BoradFunsion.idcount.get(i).text)) {
	            	idExists = true;
	            	break; 
	        }
	    }
			if(idExists) {
				Cw.wn("아이디 확인 완료!");
				idwiter = cmd;
				pwcheckrun();
			} else {
				Cw.wn("아이디 혹은 비밀번호가 다릅니다. 메인메뉴로 돌아갑니다");
			}
			
		}
			
	public static void pwcheckrun() {
		
		Cw.wn("비밀번호를 입력해주세요!");
		
		Scanner sc = new Scanner(System.in);
		String cmd = sc.nextLine();
		
		boolean pwcheck = false;
		
		for (int i = 0; i < BoradFunsion.pwcount.size(); i++) {
			
			Product idpin = BoradFunsion.idcount.get(i);
			Product pwpin = BoradFunsion.pwcount.get(i);
			
	        if (cmd.equals(BoradFunsion.pwcount.get(i).text)) {
	        		pwcheck = true;
	            break; 
	        }
	    }
		
	if(pwcheck) {
		Cw.wn("패스워드 확인 완료! 회원전용 글쓰기로 이동합니다.");
		P_MenuIdList.menuidlistrun();
		
	} else {
		
		Cw.wn("아이디 혹은 비밀번호가 다릅니다. 메인메뉴로 돌아갑니다");
		P_MainMenu.mainmenurun();
	}
	
	}

}
