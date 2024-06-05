<%@page import="com.peisia.db.BoardListProcessor"%>
<%@page import="com.peisia.db.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/list.css">
</head>
<body>

<%
BoardListProcessor blp = (BoardListProcessor)request.getAttribute("blp");
ArrayList<Dto> posts = blp.getPosts();
%>

글번호, 제목, 작성자<hr>

<% 
for(int i=0;i<posts.size();i=i+1){
%>

<%=posts.get(i).no%>
<a href="/peisia/read?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>

<%
}
%>
		



<fieldset>
	<legend>페이지 블럭</legend>
	<%=blp.getHtmlPageList()%>
</fieldset>
<fieldset>
	<a href="/write.jsp">쓰기</a>
</fieldset>
<fieldset>
	<legend>검색</legend>
	<form action="/peisia/list">
		<input name="word">
		<input type="submit" value="검색">
	</form>
</fieldset>

	<a href="/peisia/dellist">삭제글목록</a>



</body>
</html>