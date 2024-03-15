// 문8	조건문	switch	사용	랜덤 1~6	숫자를 뽑고	각 숫자가 나올 때 각 숫자에 맞는 주사위 이미지로 화면에 출력
// var r = Math.floor(Math.random() * 6) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

document.write("<img src='dice6_" + (Math.floor(Math.random() * 6) + 1) + ".jpg'>");

// document.write("<img src='dice6_" + (Math.floor(Math.random() * 6) + 1) + ".jpg'>");