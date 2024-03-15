package rpg01;

public class Main {

	public static void main(String[] args) {
//		Character elf = new Character();
		Character player = new Character("엠피스",100,20,"엘프");
		
		Monster orc = new Monster("오크족장",50,10,"오크");
//		Monster orc = new Monster("오크족장",50,10);
		player.info();
		orc.info(); 

	}

}
