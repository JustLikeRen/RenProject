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
String no=request.getParameter("no");

Dao dao=new Dao();
Dto d=dao.delread(no);
%>

<%=d.no%>
<%=d.id%>
<%=d.title%>
<hr>
<%=d.text%>

<a href="/peisia/restore?no=<%=no%>">글복구하기</a>
<a href="/peisia/dellist">리스트로</a>

</body>
</html>