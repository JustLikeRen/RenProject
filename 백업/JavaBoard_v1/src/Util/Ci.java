package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 입력을 담당하는 클래스. (Scanner 등)
 */
public class Ci {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static public String r() {
		return sc.next();
	}
	static public String r(String comment) {
		Cw.w(comment+":");
		return sc.next();
	}
	static public String rw(String comment) {
		Cw.w(comment+":");
		return sc.nextLine();
	}
	static public String rl(String comment) {
		Cw.w(comment+":");
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null; // 트라이캐치 = 위험성이있으면 체크할때 좋음. (쉬운예시)
		}
	}
}
