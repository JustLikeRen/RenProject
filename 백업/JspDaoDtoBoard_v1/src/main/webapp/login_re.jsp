<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	잘못된 비밀번호거나 없는 아이디입니다. 다시 입력해주세요
	<hr> <h2> </h2>
	<form action="proc_login.jsp" method="post">
	<input name="m_id" placeholder="아이디"><br>
	<input name="m_pw" placeholder="비밀번호" type="password"><br>
	<input type="submit" value="로그인">
	</form>
	<h2> </h2>
		<form action="member.jsp" method="post">
		<input type="submit" value="회원가입">
		</form>
</body>
</html>