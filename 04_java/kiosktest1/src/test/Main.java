package test;

import java.util.ArrayList;

import util.So;

public class Main {

	public static void main(String[] args) {
		// 게임 오브젝트들 로딩
		Character c = new Character("고양이",3,100);
		Sword s = new Sword("단검",2,100,50,70);
		Sword l = new Sword("장검",3,150,100,70);
		
//		c.name = "개";
		((GameObj)c).name = "개";
		
//		((Item)s).attack;	//손자가 아버지로 형변환함. 대신 자기 변수 못씀.
//		((Item)s).slash();	//손자가 아버지로 형변환함. 대신 자기 함수 못씀.
		
		////	형변환은 가족끼리만 가능	////
		
		////	각자 강제형변환 후, 할아버지 변수에 대입했음	////
		GameObj g1 = (GameObj)s;	//손자가 할아버지로 형변환함.
		GameObj g2 = (GameObj)c;	//작은아버지가 할아버지로 형변환함.
		
		////	그냥 할아버지 변수에 대입해도 자동 형변환 됨.	////
		GameObj g3 = s;	//손자가 할아버지로 형변환함.
		GameObj g4 = c;	//작은아버지가 할아버지로 형변환함.
		
//		g3.attack; // 자기꺼는 못쓰게됨.
//		g4.hp;	// 자기꺼는 못쓰게됨.
		
		ArrayList<GameObj> gf = new ArrayList<>();
		gf.add(g3);
		gf.add(g4);
		gf.add(g1);
		gf.add(g2);
		
		//// 그럼 자기꺼 쓰려면?	////
		/// : 원형으로 돌아가야함. 다시 형변환
		Sword shortSword = (Sword)g3;
		shortSword.slash(); 	// 자기 함수 이제 쓸 수 있게 됨.(또는 변수)
		
		if(g3 instanceof Sword) {
			So.ln("얘 원래 검임");
		}
		if(g4 instanceof Character) {
			So.ln("얘 원래 케릭임");
		}
		if(g1 instanceof Sword) {
			So.ln("얘 원래 검임");
		}
		if(g2 instanceof Character) {
			So.ln("얘 원래 케릭임");
		}

		//할아버지형 리스트에 손자,아들,본인 다 넣을수 있음. (상속의 중요 특성)
		ArrayList<GameObj> gs = new ArrayList<>();
		gs.add(c);
		gs.add(s);
		gs.add(l);
		for(GameObj o : gs) {
			So.ln(o.name);
			if(o instanceof Sword) {
				System.out.println(o.name + "의 공격력은 "+((Sword)o).attack);
			}
			if(o instanceof Character) {
				System.out.println(o.name + "의 체력은 "+((Character)o).hp);
			}
		}
		int n = 1 + ((Sword)gs.get(2)).attack;
		So.ln("공격력"+n);
		
		////1. 형변환을 했다고해서 주소값이 바뀌거나 하지는 않음.
		GameObj xx = c;
		
		System.out.println(System.identityHashCode(c));
		System.out.println(System.identityHashCode(xx));
		
		////2. 부모객체를 자식으로 형변환은 못함. 
		
		Item x = new Item("검",2,10,100);
		//아래코드 주석 풀고 테스트하면 Class Cast Exception 남.
		//이유: 부모객체를 자식으로 형변환은 못함.
		//
		//본체가 Item인데 자식으로 형변환하는건 불가함.
		System.out.println(System.identityHashCode(x));
//		Sword ss = (Sword)x;

		////3.본체가 손자(Sword)인데 아버지나 할아버지로 형변환을 하고
		////다시 자기모습으로 돌아가는 형변환은 가능.

		////3-1. 아래 코드도 같은 본체가 손자인데 아버지로 (자동)형변환 한 것임 
		Item z = new Sword("쌍검",3,200,20,300);
		
		System.out.println(System.identityHashCode(z));
		////위 코드는 아래 3-2로 바꿔서 처리한것과 같음.
		////3-2.
		Sword xxx = new Sword("무검",5,2300,0,9999);
//		Item yyy = (Item)xxx;	//명시적 형변환. 업 캐스팅 (자식 > 부모) 
		Item yyy = xxx;			//자동 형변환. 업 캐스팅 (자식 > 부모)
		
		////3-3. 다운캐스팅 예시 코드. 
		Sword sss = (Sword)yyy;	//다운 캐스팅 (부모 > 자식)
//		
		System.out.println(System.identityHashCode(sss));
		
//		Sword ss = (Sword)y;	//다운 캐스팅 (부모 > 자식) << 이건 에러남.
	}
}