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
글번호, 제목, 작성자<hr>
<%
Dao dao=new Dao();

ArrayList<Dto> posts=dao.dellist();

for(int i=0;i<posts.size();i=i+1){
%>

<%=posts.get(i).no%>
<a href="/peisia/delread?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>

<%
}
%>
<a href="/peisia/list">뒤로가기</a>

</body>
</html>