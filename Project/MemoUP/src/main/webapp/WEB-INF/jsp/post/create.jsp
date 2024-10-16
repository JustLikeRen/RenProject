<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
   	<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="d-flex justify-content-center">
			<div class="input-box my-5">
				<h1 class="text-center">메모 입력</h1>
				<div class="d-flex align-items-center">
					<label class="col-3">제목 : </label>
					<input type="text" class="form-control col-9" id="titleInput">
				</div>
				<div class="mt-3">
					<textarea class="form-control" rows="10" id="contentInput"></textarea>
				</div>
				<div class="mt-2">
					<input type="file" id="fileInput">
				</div>
				<div class="d-flex justify-content-between mt-3">
					<a href="/post/list/view" class="btn btn-info">목록으로</a>
					<button type="button" class="btn btn-primary" id="saveBtn">저장</button>
				</div>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	<script src="/static/js/valueCheck.js"></script>
	<script>
		$(document).ready(function() {
			
			$("#saveBtn").on("click", function() {
				let title = $("#titleInput").val();
				let content = $("#contentInput").val();

				if(!valueCheck(title, "제목")) {
					e.preventDefault();
					return;
				}
				
				if(!valueCheck(content, "내용")) {
					e.preventDefault();
					return;
				}
				
				var formData = new FormData();
				formData.append("title", title);
				formData.append("content", content);
				formData.append("file", $("#fileInput")[0].files[0]);
				
				$.ajax({
					type:"post"
					, url:"/post/create"
					, data:formData
					, enctype:"multipart/form-data"	// 파일 업로드 필수 항목
					, processData:false	// 파일 업로드 필수 항목
					, contentType:false	// 파일 업로드 필수 항목
					, success:function(data) {
						if(data.result == "success"){
							location.href="/post/list/view";
						} else {
							alert("메모 저장 실패");
						}
					}
					, error:function() {
						alert("메모 저장 에러");
					}
				});
			});
		});
	</script>
</body>
</html>