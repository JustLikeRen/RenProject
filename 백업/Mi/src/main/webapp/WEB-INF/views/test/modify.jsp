<%@page import="com.peisia.dto.TestDto"%>
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
	여기 진짜오나???
	
글번호:${read.bno}
<hr>
글내용:
	<form action="/spring/test/modify" method="post">
	<c:set var="read" value="${read}"/>
		<input type="hidden" name='bno' value='${read.bno}' >
		<textarea name='btext'>${read.btext}</textarea>
		<input type="submit" value="수정하기">
	</form>
<hr><a href="/spring/test/getList?currentPage=1">글 리스트</a>
</body>
</html>