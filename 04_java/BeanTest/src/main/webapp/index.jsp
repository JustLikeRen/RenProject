<%@page import="bean.Test"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="kitty" class="bean.Test" scope="page" />
<jsp:setProperty name="kitty" property="name" value="키티" />
<jsp:getProperty name="kitty" property="age" /><br>
<jsp:getProperty name="kitty" property="name" /><br>

<%=kitty.getName() %>
<%=kitty.getAge() %>
<div>kitty의 이름: ${kitty.name}</div>
<div>kitty의 나이: ${kitty.age}</div>

</body>
</html>