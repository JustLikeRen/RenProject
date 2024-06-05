package com.peisia.kiosk.catcafe;

import com.peisia.kiosk.catcafe.product.Figure;
import com.peisia.kiosk.catcafe.product.Product;
import com.peisia.util.Cw;

public class ProcMenuFigure {
	
	public static void run() {
		
		for(Product p:KioskObj.products) {	//메뉴출력 v.0.0.11
			if(p instanceof Figure) {	//메뉴 출력을 이쪽 계열 상품만 출력 처리
				Cw.wn(p.name+" "+p.price +"원");
			}
		}
		yy:while(true) {
			
			Cw.wn("[1.키티피규어/2.마이멜로디피규어/x.이전메뉴로]");
			KioskObj.cmd = KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1":
				Cw.wn(KioskObj.products.get(3).name+" 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(3)));	//오더 추가
				break;
			case "2":
				Cw.wn(KioskObj.products.get(4).name+" 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(4)));	//오더 추가
				break;
			case "x":
				Cw.wn("이전 메뉴 이동");
				break yy;
			}
		}
	}
}