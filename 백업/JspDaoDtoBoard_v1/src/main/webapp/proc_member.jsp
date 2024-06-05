<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.peisia.c.utll.Cw"%>
<%@page import="com.peisia.db.Db"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
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
String id = request.getParameter("m_id");
String pw = request.getParameter("m_pw");
PreparedStatement checkStatement = null;
PreparedStatement insertStatement = null;
Connection con=null;
try {
// 	int cnt=0;
	Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
	con = DriverManager.getConnection(Db.DB_LOGINURL, Db.DB_ID, Db.DB_PW);
	
	String checkSql = "SELECT COUNT(*) FROM PS_MEMBER WHERE ps_id=?";
	checkStatement = con.prepareStatement(checkSql);
	checkStatement.setString(1, id);
	ResultSet checkResult = checkStatement.executeQuery();
	checkResult.next();
	int count = checkResult.getInt(1);
	
	if(count == 0){	//회원가입 아이디가 없을때
	
		String sql="insert into PS_MEMBER (ps_id, ps_pw) values (?, ?)";
// 	Cw.wn("sql :"+sql);
		insertStatement = con.prepareStatement(sql);
		insertStatement.setString(1, id);
		insertStatement.setString(2, pw);
		insertStatement.executeUpdate();
		System.out.println("회원가입 성공");

		response.sendRedirect("/");

	}else{
	System.out.println("중복된 아이디입니다");
	
	response.sendRedirect("member_re.jsp");
	}
} catch(Exception e) {
	e.printStackTrace();
} finally {
	if (checkStatement != null) {
        checkStatement.close();
    }
    if (insertStatement != null) {
        insertStatement.close();
    }
	if(con!=null){
		con.close();
	}
}
%>

</body>
</html>