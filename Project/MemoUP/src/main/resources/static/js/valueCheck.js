function valueCheck(value, alertString){
	if(value == ""){
		alert(alertString + "을(를) 입력하세요.");
		return false;
	}
	return true;
}