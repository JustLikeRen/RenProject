package JavaBoardDelAndEdit;

import java.util.Scanner;

import JavaBoardAndWriteAndRead.P_MenuList;
import JavaFunsionData.BoradFunsion;
import JavaFunsionData.Product;
import Util.Cw;

public class P_MenuDel {

	public static void menudelrun() {

		Scanner sc = new Scanner(System.in);
		Cw.wn("작성한 게시물을 삭제하는 곳입니다.");

		if (!BoradFunsion.listdata.isEmpty()) {
			P_MenuList.menulistrun(); // 게시물 목록 표시
			Cw.wn("삭제할 게시물 번호를 입력하세요");

			String input = sc.nextLine();

			// gpt 님의 코드입니다.

			try {
				int del_number = Integer.parseInt(input); // 문자열을 숫자로 변환

				if (del_number > 0 && del_number <= BoradFunsion.listdata.size()) {
					// 입력된 번호가 게시물 범위 내에 있는지 확인
					Product del_list = BoradFunsion.listdata.get(del_number - 1);
					BoradFunsion.deldata.add(del_list);
					BoradFunsion.listdata.remove(del_number - 1);
					BoradFunsion.countdata.remove(del_number - 1);

					Cw.wn("제목:" + del_list.title + " 글을 삭제하였습니다.");

				} else {
					System.out.println("게시글 넘버를 제대로 입력해주세요!");
				}

			} catch (NumberFormatException e) {
				System.out.println("유효한 입력이 아닙니다.");
			}

		} else {
			Cw.wn("저장된 글이 없습니다!");
		}

	}
}
