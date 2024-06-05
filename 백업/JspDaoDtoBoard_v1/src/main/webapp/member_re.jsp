<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	중복된 아이디 입니다. 다시 입력해주세요
	<hr> <h2> </h2>
	<form action="proc_member.jsp" method="post">
	<input name="m_id" placeholder="아이디"><br>
	<input name="m_pw" placeholder="비밀번호"><br>
	<input type="submit" value="회원가입">
</form>

</body>
</html>