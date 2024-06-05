package JavaBoardId;

import JavaFunsionData.BoradFunsion;
import JavaFunsionData.Product;
import Util.Ci;
import Util.Cw;

public class P_CreateId {
	public static int pin_id = 0;
	public static int pin_pw = 0;
	
	public static void createidrun() {
		
			Cw.wn("아이디를 만드는 곳 입니다!");
			
			String id_1 ="";
			
			start:
			while (true) {
				id_1 = Ci.rw("id");
				for(int i = 0 ; i<BoradFunsion.idcount.size() ; i++) {
					if(id_1.equals(BoradFunsion.idcount.get(i).text)) {
						Cw.wn("중복된 아이디가 있습니다! 다시 입력해주세요!");
						continue start;
					}
				}
				if (id_1.length() > 0) {
					pin_id ++;
					BoradFunsion.idcount.add(new Product(id_1 , pin_id));
					createpwrun();
					break;
				} else {
					Cw.wn("1개 이상의 문자를 입력해주세요!");
				}
			}
			
	}
	
	
	static void createpwrun() {
			String pw_1 ="";
			start:
			while (true) {
				pw_1 = Ci.rw("pw");
				if (pw_1.length() > 0) {
					pin_pw ++;
					BoradFunsion.pwcount.add(new Product(pw_1 , pin_pw));
					break start;
				} else {
					Cw.wn("1개 이상의 문자를 입력해주세요!");
				}
			}
			
			Cw.wn("ID가 성공적으로 만들어졌습니다!");
			
		}
}