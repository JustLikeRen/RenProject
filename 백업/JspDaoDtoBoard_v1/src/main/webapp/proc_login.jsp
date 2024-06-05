<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.peisia.c.utll.Cw"%>
<%@page import="com.peisia.db.Db"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String c = "";
PreparedStatement checkStatement = null;
Connection con=null;
try {
	String sql="select count(*) from PS_MEMBER where PS_ID='"+id+"' and PS_PW='"+pw+"'";
	Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
	con = DriverManager.getConnection(Db.DB_LOGINURL, Db.DB_ID, Db.DB_PW);
	checkStatement=con.prepareStatement(sql);
	Cw.wn("sql :"+sql);
	ResultSet rs=checkStatement.executeQuery(sql);
	rs.next();
	c = rs.getString("count(*)");
} catch(Exception e) {
	e.printStackTrace();
} finally {
	if(checkStatement!=null){
		checkStatement.close();
	}
	if(con!=null){
		con.close();
	}
}
if(c.equals("1")){	//로그인 성공
	System.out.println("로그인 성공");
	response.sendRedirect("/peisia/list");
}else{
	System.out.println("로그인 실패");
	response.sendRedirect("login_re.jsp");
}
%>

</body>
</html>