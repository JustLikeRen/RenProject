var ipId;
var ipPw;
var ipPw_re;
var ipUser_name;
var ipEmail;
var ipSex;
var ipBirth_y;
var ipBirth_m;
var ipBirth_d;
var ipTel_1;
var ipTel_2;
var ipTel_3;

var Id;
var Pw;
var Pw_re;
var User_name;
var Email;
// var Sex;
var Birth_y;
var Birth_m;
var Birth_d;
var Tel_1;
var Tel_2;
var Tel_3;

window.onload = function(){
    ipId=document.getElementById("id");
    ipPw=document.getElementById("pw");
    ipPw_re=document.getElementById("pw_re");
    ipUser_name=document.getElementById("user_name");
    ipEmail=document.getElementById("email");
    ipSex=document.getElementById("sex");
    ipBirth_y=document.getElementById("birth_y");
    ipBirth_m=document.getElementById("birth_m");
    ipBirth_d=document.getElementById("birth_d");
    ipTel_1=document.getElementById("tel_1");
    ipTel_2=document.getElementById("tel_2");
    ipTel_3=document.getElementById("tel_3");
}

function check(){  
    id=ipId.value;
    pw=ipPw.value;
    pw_re=ipPw_re.value;
    userName=ipUser_name.value;
    email=ipEmail.value;
    birth_y=ipBirth_y.value;
    birth_m=ipBirth_m.value;
    birth_d=ipBirth_d.value;
    // sex=ipSex.value;
    tel_1=ipTel_1.value;
    tel_2=ipTel_2.value;
    tel_3=ipTel_3.value;
    
    if (checkId()&&checkPw()&&checkPw_re()&&checkUserName()&&checkEmail()) {
        alert("회원가입 성공");
    } else {
        alert("회원가입 실패");
    }
}

function checkId(){
    if (id.length>=6&&id.length<=12) {
        console.log("ok id");
        return true;
    } else {
        console.log("no id");
        return false;
    }
}

function checkPw(){
    if (pw.length>=6&&pw.length<=15) {
        console.log("ok pw");
        return true;
    } else {
        console.log("no pw");
        return false;
    }
}

function checkPw_re(){
    if (pw_re.length>=6&&pw_re.length<=15) {
        console.log("ok Pw_re");
        return true;
    } else {
        console.log("no Pw_re");
        return false;
    }
}

function checkUserName(){
    if (userName.length>=2&&userName.length<=20) {
        console.log("ok Name");
        return true;
    } else {
        console.log("no Name");
        return false;
    }
}

function checkEmail(){
    if (email.length>=10&&email.length<=20) {
        console.log("ok Email");
        return true;
    } else {
        console.log("no Email");
        return false;
    }
}


