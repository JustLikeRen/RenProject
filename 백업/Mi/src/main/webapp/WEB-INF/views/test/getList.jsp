<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${cp}/resources/common.css" >
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jstl 로 처리하면 더 짧게 가능 -->

<table>
	<tr>
		<td>글번호</td>
		<td>글내용</td>
	</tr>
<!-- jstl 로 처리하면 더 짧게 가능 -->
<c:forEach var="test" items="${list}">
	<tr>
		<td>${test.bno}</td>
		<td><a href="/spring/test/read?bno=${test.bno}">${test.btext}</a></td>
    </tr>
</c:forEach>
</table>


<c:if test="${page.hasPrev}">
<a href="/spring/test/getList?currentPage=${page.prevPage}&word=${page.word}">이전블럭가기</a>

</c:if>
<c:forEach var="aasdas" begin="${page.blockStartNo}" end="${page.blockEndNo}" step="1" varStatus="loop">
		[ <a href="/spring/test/getList?currentPage=${loop.index}&word=${page.word}">${loop.index}</a> ]
</c:forEach>
<c:if test="${page.hasNext}">
<a href="/spring/test/getList?currentPage=${page.nextPage}&word=${page.word}">다음블럭가기</a>
    </c:if>
 	<fieldset>
		<legend>검색</legend>
			<form action="/spring/test/getList">
				<input name="word"><input type="submit" value="검색">
			</form>
	</fieldset>
<br>
<a href="/spring/test/write">새글 쓰기</a>


<%-- <c:forEach var="guest" items="${list}"> --%>
<%--     <c:set var="bno" value="${guest.bno}" /> --%>
<%--     <c:set var="btext" value="${guest.btext}" /> --%>
<%--     ${bno} --%>
<%--     ${btext} --%>
<!--     <hr> -->
<%-- </c:forEach> --%>


</body>
</html>