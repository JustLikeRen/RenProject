package Display;

import JavaFunsionData.DataForBorad;
import Util.Cw;

public class Disp {
	public static void title() {
		Cw.line();
		Cw.dot();
		Cw.space(17);
		Cw.w(DataForBorad.TITLE);
		Cw.space(17);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}
	public static void menuMain() {
		Cw.dot();
		Cw.space(11);
		Cw.w("[1.글리스트/2.글쓰기/3.익명글쓰기/4.삭제 및 수정/5.복구/e.로그아웃]");
		Cw.space(11);
		Cw.dot();
		Cw.wn();
	}
	public static void menuMainnonid() {
		Cw.dot();
		Cw.space(12);
		Cw.w("비로그인모드[1.글리스트/2.글쓰기/e.종료]");
		Cw.space(12);
		Cw.dot();
		Cw.wn();
	}

}
