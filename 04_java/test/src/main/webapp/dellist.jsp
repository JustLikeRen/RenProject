<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글복구</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<a href="index.jsp">홈으로 이동</a>
<h2> </h2>
<hr>

	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from cat_board where delNo=1" );
		while(rs.next()){
			String num = rs.getString("num");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String id = rs.getString("id");
	 
	%>
	<%=num %> <a href="delread.jsp?num=<%=num%>"><%=title %></a> <%=id%><br>
<% 
	
		}	
	} catch (Exception e) {		
		e.printStackTrace();
		}
%>
</body>
</html>