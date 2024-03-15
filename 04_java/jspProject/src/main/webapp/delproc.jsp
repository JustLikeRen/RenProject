<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String delNum = request.getParameter("num");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		String sql = "update cat_board set delNo=1 where num="+delNum;
		
		int resultCount = st.executeUpdate(sql);
		if (resultCount == 1) {
			System.out.println("====글삭제 성공");
		} else {
			System.out.println("====글삭제 실패");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	response.sendRedirect("/jspProject/list.jsp");
%>