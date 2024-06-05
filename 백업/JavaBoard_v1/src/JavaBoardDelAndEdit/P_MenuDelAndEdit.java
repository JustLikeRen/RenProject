package JavaBoardDelAndEdit;

import java.util.Scanner;

import Util.Cw;

public class P_MenuDelAndEdit {

	public static void delandeditrun() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		start:
		while(true) {
			Cw.wn("[1]글수정 [2]삭제메뉴 [b]이전메뉴");
			String cmd = sc.nextLine();
			switch(cmd) {
			case "1":
				P_MenuEditPost.menueditpostrun();
				break;
			case "2":
				P_MenuDel.menudelrun();
				break;
			case "b":
				break start;
			}
			
			
			
		}
		
	}
	
	
}
