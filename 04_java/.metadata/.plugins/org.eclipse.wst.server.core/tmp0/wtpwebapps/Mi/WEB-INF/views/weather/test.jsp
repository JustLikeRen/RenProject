<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

	<form action="/" method="get">
    <button type="submit">테스트로연결</button>
    
    <c:forEach var="xx" items="${aaa.response.body.items.item}">
	<tr>
		<td>==== json ==== : 어제의 날씨입니다~ 어제 ${xx.stnNm} 의 최저기온은 ${xx.minTa} 도 최고 기온은 ${xx.maxTa} 였습니다. 날씨였습니다.</td>
		<td></td>
    </tr>
</c:forEach>
    
</form>
</body>
</html>