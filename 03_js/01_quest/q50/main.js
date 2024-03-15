/**********************************************************************
rpg (v0.1.0)
***********************************************************************

[v0.1.0 업데이트 내용]
- 몬스터 클래스 생성
- 플레이어 클래스 생성
- 몬스터 객체 생성(orc)
- 플레이어 객체 생성(elf)


**********************************************************************/

function Monster(){ 
    //속성, 프로퍼티    
    this.name;
    this.hp;
    this.attack;
    
    this.info = function(){
        hr();
        dw("["+this.name+"]["+this.hp+"][atk:"+this.attack+"]");
        hr();
    }
}
// function Monster(name,hp,attack){ 
    //     //속성, 프로퍼티    
    //     this.name = name;  // 이름
    //     this.hp = hp;    // 체력
    //     this.attack = attack; // 공격력
    
    //     this.info = function(){
        //         hr();
        //         dw("["+name+"]["+hp+"][atk:"+attack+"]");
        //         hr();
        //     }
        // }
        function Character(){ 
            //속성, 프로퍼티    
            this.name;
            this.hp;
            this.attack;
            
            this.info = function(){
                hr();
                dw("["+this.name+"]["+this.hp+"][atk:"+this.attack+"]");
                hr();
            }
        }
        // function Character(name,hp,attack){ 
            //     //속성, 프로퍼티    
            //     this.name = name;  // 이름
            //     this.hp = hp;    // 체력
            //     this.attack = attack; // 공격력
            
            //     this.info = function(){
                //         hr();
                //         dw("["+name+"]["+hp+"][atk:"+attack+"]");
                //         hr();
                //     }
// }

// var orc = new Monster("오크전사",100,10);
var orc = new Monster();
var elf = new Character();

orc.name = "오크전사";
orc.hp = 100;
orc.attack = 10;

elf.name = "엠피스";
elf.hp = 200;
elf.attack = 20;


orc.info();
elf.info();

// function getRandomAttackValue(attack){
//     attack = attack + 1;    //ex. 공격력이 10이라고 하면 0~10의 수치로 나와야 하므로
//     var random = Math.floor(Math.random()*attack);  // ex. 공격력이 11이고 이 랜덤처리를 하면 랜덤 값은 0~10이 나옴
// return random;}