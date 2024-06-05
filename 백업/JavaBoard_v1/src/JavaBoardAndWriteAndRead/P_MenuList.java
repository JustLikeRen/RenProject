package JavaBoardAndWriteAndRead;

import java.time.LocalDate;

import JavaFunsionData.BoradFunsion;
import JavaFunsionData.DataForBorad;
import JavaFunsionData.Product;
import Util.Cw;

public class P_MenuList {

	public static void menulistrun() {
		
		LocalDate now = LocalDate.now();
		DataForBorad.date = now.toString();
		int list_number = 0;
		
		for (int i = 0; i < BoradFunsion.countdata.size(); i++) {
			Product list_all = BoradFunsion.listdata.get(i);
			list_number = i + 1;
			Cw.w("No." + list_number + " ");
			Cw.w("제목:" + list_all.title + "/");
			Cw.w("작성자:" + list_all.write + "/");
			Cw.wn("조회수:" + DataForBorad.view_limit);
			Cw.wn("작성일:" + DataForBorad.date);
			Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");

		}
	}
	public static void menuidlistrun() {
		
		LocalDate now = LocalDate.now();
		DataForBorad.date = now.toString();
		int list_number = 0;
		
		for (int i = 0; i < BoradFunsion.countdata.size(); i++) {
			Product list_all = BoradFunsion.listdata.get(i);
			list_number = i + 1;
			Cw.w("No." + list_number + " ");
			Cw.w("제목:" + list_all.title + "/");
			Cw.w("작성자:" + list_all.write + "*" +"/");
			Cw.wn("조회수:" + DataForBorad.view_limit);
			Cw.wn("작성일:" + DataForBorad.date);
			Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");
			
		}
	}
	
	public static void dellistrun() {
		
		int del_number = 0;
		for (int i = 0; i < BoradFunsion.deldata.size(); i++) {
			Product del_all = BoradFunsion.deldata.get(i);
			del_number = i + 1;
			Cw.w("No." + del_number + " ");
			Cw.w("제목:" + del_all.title + "/");
			Cw.w("작성자:" + del_all.write + "/");
			Cw.wn("조회수:" + DataForBorad.view_limit);
			Cw.wn("작성일:" + DataForBorad.date);
			Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");

		}
		
	}
	
}