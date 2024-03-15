package test;

//할아버지가 다시 손자나 부모를 상속받는건 안됨. 바로 빨간줄. 
//public class GameObj extends Sword{
public class GameObj{
	int grade;
	String name;
	
	void info() {
		System.out.println("이름:"+name+" 등급:"+grade);
	}
	
	GameObj(){
		System.out.println("게임 오브젝트 생성되었음. 생성자 함수 호출됨.");
	}

	public GameObj(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	public GameObj(String name) {
		this.name = name;
	}
	
}
