<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  <a href="/weather/w">컨트롤러</a> </P>
	<form action="/weather/w" method="get">
    <button type="submit">테스트로연결</button>
</form>
</body>
</html>
