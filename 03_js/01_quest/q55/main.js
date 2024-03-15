// - 전투 무한 루프 처리 : 전투 시 플레이어나 적의 현재 체력이 0 이하로 될 때까지(죽을때 까지) 전투 반복 처리

var dragon = new Monster("드래곤",100,10); 
//몬스터라는 큰틀에 다른 몹을 묶어서 만들어낼수가있음

var elf = new Character();
elf.name = "성모";
elf.hp = 200;
elf.max_hp = 200;
elf.attack = 20;

elf.info();
dragon.info();

hr();
dw("전투시작");
hr();


function proc_battle(){
	var elf_attack = r(elf.attack);
	var dragon_attack = r(dragon.attack);
	
	hr();
	dw("플레이어 데미지:"+elf_attack);
	hr();
	dw("몬스터 데미지:"+dragon_attack);
	hr();
	
	elf.hp = elf.hp - dragon_attack;		// 1~10 랜덤 뎀
	dragon.hp = dragon.hp - elf_attack;	
	
	elf.info();
	dragon.info();
}



while(true){
	proc_battle();

	if(elf.hp <= 0 || dragon.hp <= 0){
		break;
	}
}
br()
dw(dragon.name+"을 처치하여 "+elf.name+"(이)가 100gold를 얻었습니다")