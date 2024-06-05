<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world!</h1>
	
	<form action="/riot/searchs" method="get">
    <div class="form-group">
      <label for="">닉네임:</label>
      <input type="text" class="form-control" id="searchName" name="searchName" placeholder="Enter search">
    </div>
    <div class="form-group">
      <label for="tag">태그:</label>
      <input type="text" class="form-control" id="tag" name="tag" placeholder="Enter tag">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
    </form>
    
</body>
</html>