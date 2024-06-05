package JavaBoardDelAndEdit;

import java.util.Scanner;

import JavaBoardAndWriteAndRead.P_MenuList;
import JavaFunsionData.BoradFunsion;
import JavaFunsionData.DataForBorad;
import JavaFunsionData.Product;
import Util.Cw;

public class P_MenuRestore {

	public static void menurestorerun() {

		Scanner sc = new Scanner(System.in);

		if (!BoradFunsion.deldata.isEmpty()) {
			P_MenuList.dellistrun();
			Cw.wn("복구할 게시물 번호를 입력하세요:");
			String input = sc.nextLine();

			try {
				int del_restore = Integer.parseInt(input); // 문자열을 숫자로 변환

				if (del_restore > 0 && del_restore <= BoradFunsion.deldata.size()) {

					Product restore = BoradFunsion.deldata.get(del_restore - 1);
					BoradFunsion.listdata.add(BoradFunsion.deldata.get(del_restore - 1));
					BoradFunsion.countdata.add(BoradFunsion.deldata.get(del_restore - 1));

					Cw.w("No." + del_restore + " ");
					Cw.w("제목:" + restore.title + "/");
					Cw.w("작성자:" + restore.write + "/");
					Cw.wn("조회수:" + DataForBorad.view_limit);
					Cw.wn("작성일:" + DataForBorad.date);
					Cw.wn("〓〓〓〓〓〓〓〓〓〓〓〓〓");
					Cw.wn("복구완료!");
					BoradFunsion.deldata.remove(BoradFunsion.deldata.get(del_restore - 1));

				} else {
					Cw.wn("유효한 게시물 번호가 아닙니다!");
				}

			} catch (NumberFormatException e) {
				System.out.println("유효한 입력이 아닙니다.");
			}
		} else {
			Cw.wn("삭제된 게시물이 없습니다.");
		}
	}
}