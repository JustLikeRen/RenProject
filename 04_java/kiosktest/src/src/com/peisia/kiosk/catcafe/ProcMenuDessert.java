package com.peisia.kiosk.catcafe;

import com.peisia.kiosk.catcafe.product.Product;
import com.peisia.util.Cw;

public class ProcMenuDessert {
	
	public static void run() {
		
		for(Product q:KioskDessertObj.products) {	//메뉴출력
			Cw.wn(q.name);
		}
		yy:while(true) {
			Cw.wn("[1.마카롱/x.이전메뉴로]");
			KioskDessertObj.cmd = KioskDessertObj.sc.next();
			switch(KioskDessertObj.cmd) {
			case "1":
				Cw.wn(KioskDessertObj.products.get(2).name+" 선택됨");
				
				Order n = new Order(KioskDessertObj.products.get(2));
				KioskDessertObj.basket.add(n);	//오더 추가
//				KioskObj.basket.add(new Order(KioskObj.products.get(2)));	//오더 추가
				
				break;
			case "x":
				Cw.wn("이전 메뉴 이동");
				break yy;
			}
		}
	}
}
