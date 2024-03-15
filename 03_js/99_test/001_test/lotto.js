function dw(str){
    document.write(str);
}
function br(){
    document.write("<br>");
}

let usernum = new Array(7);
let win = new Array(8);
let lotto = new Array(46);

let lotto_result;

window.onload = function () {
    lotto_result = document.getElementById("lotto_result");
}

function onClick() {    
    // usernum.fill(0);
    // lotto.fill(0);
    // win.fill(0);
    // lotto_result = "";

    for (i = 1; i <= 6; i++) {
        let n = document.getElementById("n"+i)
        usernum[i] = n.value;
    }
    
    for (i = 1; i <= 7;) {
        let tmp = Math.floor(Math.random()*45+1);
        if (!lotto[tmp]) {
            win[i] = tmp;
            if (i == 7) {
                lotto[tmp] += 2;
                break;
            }
            lotto[tmp]++;
            lotto[usernum[i]]++;
            i++;
        }
    }
    
    let corrcnt = 0;
    let bonusf = false;
    for (i = 1; i <= 45; i++) {
        if(lotto[i] == 2) corrcnt++;
        if(lotto[i] == 3) bonusf = true;
    }

    switch (corrcnt) {
        case 3:
            lotto_result.value = "5등입니다. "
            break;
        case 4:
            lotto_result.value = "4등입니다. "
            break;
        case 5:
            if (bonusf = false) lotto_result.value = "3등입니다. "
            else lotto_result.value = "2등입니다. "
            break;
        case 6:
            lotto_result.value = "1등입니다. "
            break;
        default:
            lotto_result.value = "꽝입니다. "
            break;
    }
    
    lotto_result.value += "\n뽑은 번호 : "
    for (i = 1; i <= 6; i++) lotto_result.value += usernum[i] + " ";

    lotto_result.value += "\n당첨 번호 : ";
    for (i = 1; i <= 6; i++) lotto_result.value += win[i] + " ";
    lotto_result.value += "+ " + win[7];
}