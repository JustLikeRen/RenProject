<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> 
  
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<div class="container">
  <h2>회원가입</h2>
  <form action="${cp}/test/member" method="post">
    <div class="form-group" >
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" name="id" placeholder="Enter id">
	<button type="button" id="id_check">중복 확인</button> 
	<span id="id_check_ok"></span> 
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" name="pw" placeholder="Enter password">
    </div>
   <!--  <div class="form-group">
      <label for="nickname">nickname:</label>
      <input type="text" class="form-control" id="nickN" name="nickName" placeholder="Enter nickname">
    </div> -->
    <button type="submit" class="btn btn-default">회원가입</button>
    <button type="reset" class="btn btn-warning">reset</button>
  </form>
</div>

	
</body>
</html>