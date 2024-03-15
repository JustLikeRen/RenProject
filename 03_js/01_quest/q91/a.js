function x(){
	sec = sec - 1;
	
	if(sec <= 0){
		divA.innerHTML = "라면 불 꺼!";
	} else {
		divA.innerHTML = sec;
	}
}

// var sec = 240 + 30;
var sec = 10;
var divA;
window.onload = function(){
	divA=document.getElementById("a");
	setInterval(x, 1000);
}