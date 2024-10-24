<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
   	<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<header>
			<c:import url="/WEB-INF/jsp/include/header.jsp"/>
		</header>
		<nav></nav>
		<section class="content d-flex justify-content-center">
			<div class="text-center">
				<h2>회원가입</h2>
				<div class="input-group">
				  	<input type="text" class="form-control" placeholder="아이디" id="idInput">
				  	<button class="btn btn-primary" type="button" id="idCheckBtn">중복체크</button>
				</div>
				<span id="idDuplication" class="text-danger small" style="display:none">중복된 아이디 입니다.</span>
				<span id="idNotDuplication" class="text-success small" style="display:none">사용 가능한 아이디 입니다.</span>
				
				<input type="password" placeholder="비밀번호" id="passwordInput" class="form-control mt-3">
				<input type="password" placeholder="비밀번호 확인" id="passwordCheck" class="form-control mt-3">
				<input type="text" placeholder="이름" id="nameInput" class="form-control mt-3">
				<input type="email" placeholder="이메일" id="emailInput" class="form-control mt-3">
				
				<button type="button" id="signupBtn" class="btn btn-primary btn-block mt-3">가입</button>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"/>
	</div>


	<script src="/static/js/valueCheck.js"></script>
	<script>
		$(document).ready(function() {
			
			var check = false;
			
			$("#idInput").on("change", function() {
				check = false;
				$("#idDuplication").hide();
				$("#idNotDuplication").hide();
			});
			
			$("#idCheckBtn").on("click", function() {
				let id = $("#idInput").val();
				
				if(!valueCheck($("#idInput"), "아이디")){
					return;
				}
				
				$.ajax({
					type:"get"
					, url:"/user/signup/duplication"
					, data:{"loginId": id}
					, success:function(data) {
						if(data.result) {
							$("#idDuplication").show();
							$("#idNotDuplication").hide();
							check = false;
						} else {
							$("#idDuplication").hide();
							$("#idNotDuplication").show();
							check = true;
						}
					}
					, error:function(){
						alert("중복검사 에러");
					}
				});
			});
			
			$("#signupBtn").on("click", function() {
				let id = $("#idInput").val();
				let password = $("#passwordInput").val();
				let passwordCheck = $("#passwordCheck").val();
				let name = $("#nameInput").val();
				let email = $("#emailInput").val();
				let exptext = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/;
				let reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/
				
				if(!valueCheck(id, "아이디")){
					e.preventDefault();
					$("#idInput").focus();
					return;
				}
				
				if(!valueCheck(password, "비밀번호")) {
					e.preventDefault();
					$("#passwordInput").focus();
					return;
				}
				
				if(!valueCheck(name, "이름")) {
					e.preventDefault();
					$("#nameInput").focus();
					return;
				}
				
				if(!valueCheck(email ,"이메일")) {
					e.preventDefault();
					$("#emailInput").focus();
					return;
				}
				
				if(!check) {
					alert("아이디 중복검사를 해주세요.");
					return;
				}
				
				if (!reg.test(password)) {
		            alert("비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.");
		            $("#passwordInput").val("");
		            $("#passwordInput").focus();
		    		return false;
		        }
				
				
				if(!exptext.test(email)) {
					alert("이메일 형식이 올바르지 않습니다.");
					$("#emailInput").val("");
					$("#emailInput").focus();
					return false;
				}
	
				
				if(password != passwordCheck) {
					alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/user/signup"
					, data:{"id":id, "password":password, "name":name, "email":email}
					, success:function(data) {
						if(data.result == "success"){
							alert("가입 완료!");
							location.href="/user/signin/view";
						} else{
							alert("회원가입 실패 다시 시도해 주세요.");
						}
					}
					, error:function() {
						alert("가입 서버 오류");
					}
				});
			});
			
		});
	</script>
</body>
</html>