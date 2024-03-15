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
<title>게시판 - 글읽기</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
		<a href="index.jsp">홈으로 이동</a>
		<h2> </h2>
<hr>
<%
	String readNum = request.getParameter("num");	//url get방식으로 읽을 글 번호를 받아서 변수 저장.
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		st.executeUpdate("update cat_board set count=count+1 where num="+readNum);
		ResultSet rs = st.executeQuery("select * from cat_board where delNo=0 and num="+readNum);	//sql문 조합.
		rs.next();
		String num = rs.getString("num");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");
		String count = rs.getString("count");

%>

		글번호:<%=num %><br>
		글제목:<%=title %><br>
		작성자id:<%=id %><br>
		글내용:<br>
		<%=content %> <br>
		조회수:<%=count %>
<%			
		
	} catch (Exception e) {		
		e.printStackTrace();
	}	
%>
		<h2> </h2>
<a href="delproc.jsp?num=<%=readNum%>">글삭제하기</a>
<a href="modify.jsp?num=<%=readNum%>">글수정하기</a>
</body>
</html>