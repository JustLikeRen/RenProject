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
<link rel="stylesheet" href="common.css">
<title>게시판-리스트</title>
</head>
<body>
글번호 | 제목 | 글내용 | 작성자id | 조회수
<hr>
<a href="index.jsp">홈으로 이동</a>
<h2> </h2>
<a href="write.jsp">글쓰기</a>
<h2> </h2>
<a href="dellist.jsp">삭제글목록</a>
<h2> </h2>
<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from cat_board where delNo=0" );
		while(rs.next()){
			String num = rs.getString("num");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String id = rs.getString("id");
			String count = rs.getString("count");
	%>
	<%=num %> <a href="read.jsp?num=<%=num%>"><%=title %></a> <%=id%> <%=count%><br>
<% 
	
		}	
	} catch (Exception e) {		
		e.printStackTrace();
		}
%>
</body>
</html>