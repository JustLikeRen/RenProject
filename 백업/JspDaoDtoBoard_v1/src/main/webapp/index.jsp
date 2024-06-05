<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="proc_login.jsp" method="post">
	<input name="id" placeholder="아이디"><br>
	<input name="pw" placeholder="암호" type="password"><br>
	<input type="submit" value="로그인"><br><h2> </h2>
</form>
<form action="member.jsp" method="post">
<input type="submit" value="회원가입">
</form>
</body>
</html>