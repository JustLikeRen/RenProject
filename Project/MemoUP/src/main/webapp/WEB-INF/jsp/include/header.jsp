<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<header>
		<div class="d-flex justify-content-between align-items-center">
			<h1><a href="/post/list/view" id="mainName">메모장</a></h1>
			<c:if test="${not empty userId}">
				<div class="mr-3">${userName}님 <a href="/user/signout">로그아웃</a></div>
			</c:if>
		</div>
		<hr>
	</header>