<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<a href="index.jsp">홈으로 이동</a>
<h2> </h2>
<hr>

<form action="wirteproc.jsp" method="get">
	글제목:<input name="title"><br>
	글작성자:<input name="id"><br>
	글내용:<textarea name="content" rows="5" cols="50"></textarea>
	<input type="submit" value="글쓰기"> 
</form>
</body>
</html>