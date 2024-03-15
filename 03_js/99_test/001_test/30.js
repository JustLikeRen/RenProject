function dw(str){
    document.write(str);
}
function br(){
    document.write("<br>");
}

var player;
var com;

var player_text;
var rsp_result;
var playerrsp;
var comrsp;

var rsp_result;

window.onload = function () {
    player_text = document.getElementById("player_text");
    rsp_result = document.getElementById("rsp_result");
    playerrsp = document.getElementById("playerrsp");
    comrsp = document.getElementById("comrsp");
}

function PlayerClick() {
    while(1) {
        player = player_text.value;
        if (player == "가위" || player == "바위" || player == "보") {
            break;
        }
        else {
            location.reload();
            return;
        }
    }
    com = Math.floor(Math.random()*3);
    switch (player) {
        case "가위": 
            player = 0;
            playerrsp.innerHTML = "<img src = 'imgs/sc.png'>";
            break;
        case "바위": 
            player = 1; 
            playerrsp.innerHTML = "<img src = 'imgs/ro.png'>";
            break;
        case "보": 
            player = 2; 
            playerrsp.innerHTML = "<img src = 'imgs/pa.png'>";
            break;
    }
    
    switch(com) {
        case 0: comrsp.innerHTML = "<img src = 'imgs/sc.png'>"; break;
        case 1: comrsp.innerHTML = "<img src = 'imgs/ro.png'>"; break;
        case 2: comrsp.innerHTML = "<img src = 'imgs/pa.png'>"; break;
    }

    if (player == 0) {
        switch (com) {
            case 0: rsp_result.value = "DRAW"; break;
            case 1: rsp_result.value = "LOSE"; break;
            case 2: rsp_result.value = "WIN"; break;
        }
    }
    else if (player == 1) {
        switch (com) {
            case 0: rsp_result.value = "WIN"; break;
            case 1: rsp_result.value = "DRAW"; break;
            case 2: rsp_result.value = "LOSE"; break;
        }
    }
    else if (player == 2) {
        switch (com) {
            case 0: rsp_result.value = "LOSE"; break;
            case 1: rsp_result.value = "WIN"; break;
            case 2: rsp_result.value = "DRAW"; break;
        }
    }
}