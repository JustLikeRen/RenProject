package JavaFunsionData;

import Util.Cw;

public class DataForBorad {
	public static final String VERSION = "v1.0.0";
	public static final String TITLE = "솔패밀리 게시판 (" + VERSION + ") feat.Jo";
	public String title;
	public String content;
	public String writer;
	public int hit;
	public static String date;
	public static int view_limit = 0;
	public void info() {
		
		Cw.w("글제목:"+title);
		Cw.w("작성자:"+writer);
		Cw.w("조회수:"+hit);
		Cw.wn("작성일:"+date);
		Cw.wn("글내용:"+content);
	}
	
}
