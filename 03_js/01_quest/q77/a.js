
var str_id = "";
var str_pw = "";

var input_id;
var input_pw;
var divX;

window.onload = function(){ // html 문서가 다 읽어진 후에 실행되는 함수임. 이걸 써야 아래 h1 태그(id=a)에 대한 접근이 가능해짐


    input_id = document.getElementById("id");
    input_pw = document.getElementById("pw");
	divX = document.getElementById("x");

//todo

    // str_id = input_id.value;
    // str_pw = input_pw.value;

    

}

function login(){
	var entered_id = input_id.value;
    var entered_pw = input_pw.value;
	if (entered_id=="cat" && entered_pw=="1234") {
		divX.innerHTML = entered_id+" 회원님 반갑습니다.";
	} else {
		alert("로그인 실패")
	}
}