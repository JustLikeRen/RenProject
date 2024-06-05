package JavaBoardAndWriteAndRead;

import JavaBoardId.P_IdCheck;
import JavaFunsionData.BoradFunsion;
import JavaFunsionData.Product;
import Util.Ci;
import Util.Cw;

public class P_MenuIdWrite {

	public static void menuidwriterun() {
		//제목
		String title ="";
			while (true) {
				title = Ci.rw("글제목");
				if (title.length() > 0) {
					BoradFunsion.countdata.add(new Product(title));
					break;
				} else {
					Cw.wn("1개 이상의 문자를 입력해주세요!");
				}
			}
		//내용
		String content;
			while (true) {
				content = Ci.rw("글내용");
				if (content.length() > 0) {
					break;
				} else {
					Cw.wn("1개 이상의 문자를 입력해주세요!");
				}
			}
		//작성자
		String Id_writer;
				Id_writer = P_IdCheck.idwiter;
			Product list_all = new Product(title,content,Id_writer);
			BoradFunsion.listdata.add(list_all);
			
			Cw.wn("작성완료");
			}
		}

