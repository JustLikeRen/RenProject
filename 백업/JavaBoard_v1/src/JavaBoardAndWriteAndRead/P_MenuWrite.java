package JavaBoardAndWriteAndRead;

import JavaFunsionData.BoradFunsion;
import JavaFunsionData.Product;
import Util.Ci;
import Util.Cw;

public class P_MenuWrite {

	public static void menuwriterun() {
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
		String writer;
			while (true) {
				writer = Ci.rw("작성자");
				if (writer.length() > 0) {
					break;
				} else {
					Cw.wn("1개 이상의 문자를 입력해주세요!");
				}
			}
			Product list_all = new Product(title,content,writer);
			BoradFunsion.listdata.add(list_all);
			
			Cw.wn("작성완료");
			}
		}

