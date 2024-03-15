var p = [1,2,3,4,5,6];      // 내번호들 
var r = [0,0,0,0,0,0];  // 컴 번호들(초기값 다 0으로 일단)
var s = 0; // 보너스 번호 함수
////////////////////////////////////////////////////////
// 랜덤 번호들
////////////////////////////////////////////////////////
////    번호 1
r[0] = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r[0]);
document.write("<br>");

while (true) {
    r[1] = Math.floor(Math.random() * 45) + 1;
    if (r[0]!=r[1]) {
        document.write(r[1]);
        document.write("<br>");
        break;
    }
}
while (true) {
    r[2] = Math.floor(Math.random() * 45) + 1;
    if (r[0]!=r[2]&&r[2]!=r[1]) {
        document.write(r[2]);
        document.write("<br>");
        break;
    }
}
while (true) {
    r[3] = Math.floor(Math.random() * 45) + 1;
    if (r[0]!=r[3]&&r[3]!=r[1]&&r[3]!=r[2]) {
        document.write(r[3]);
        document.write("<br>");
        break;
    }
}
while (true) {
    r[4] = Math.floor(Math.random() * 45) + 1;
    if (r[0]!=r[4]&&r[4]!=r[1]&&r[4]!=r[2]&&r[4]!=r[3]) {
        document.write(r[4]);
        document.write("<br>");
        break;
    }
}
while (true) {
    r[5] = Math.floor(Math.random() * 45) + 1;
    if (r[0]!=r[5]&&r[5]!=r[1]&&r[5]!=r[2]&&r[5]!=r[3]&&r[5]!=r[4]) {
        document.write(r[5]);
        document.write("<br>");
        break;
    }
}

while (true) {
    s = Math.floor(Math.random() * 45) + 1;
    if (r[0]!=s&&s!=r[1]&&s!=r[2]&&s!=r[3]&&s!=r[4]&&s!=r[5]) {
        document.write(s);
        document.write("<br>");
        break;
    }
}
var win = 0;

for (i = 0; i <=5; i=i+1) {
    for (j = 0; j <= 5; j=j+1) {
        if (p[i]==r[j]) {
            win=win+1;
        }
    }
}

document.write("맞은개수: "+win+"<br>");

var str =" ";

switch (win) {
    case 0:
    case 1:
    case 2:
        str="꽝 다음기회에";
        break;
    case 3:
        str="5등입니다";
        break;
    case 4:
        str="4등입니다";
        break;
    case 5:
        str="3등입니다";
        for (i=0;i<=6;i=i+1) {
            if (s==p[i]) {
            str="2등입니다";
            }
        }
        
        break;
    case 6:
        str="1등입니다"
        break;
}

document.write(str);