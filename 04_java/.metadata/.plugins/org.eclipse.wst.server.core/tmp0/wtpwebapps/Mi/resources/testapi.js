$(function() {		// << 이렇게 jquery 3.0 식으로 줄여쓰기. 대신 맨 아래 닫는 괄호들 주의.			
	var xhr = new XMLHttpRequest();	
				
	//jqeury : 선택한 요소에 이벤트 핸들러 추가
	
	// 아래 jquery 문은 다시 아래아래껄로 더 줄일 수 있음.					
	//$("#cat1").on("click", function() {	
	
	//아래 두번째 버튼 처리한거랑 비교 해보시오.. 방식을 다르게 처리 했음.				
	$("#cat1").on("click", function() {	
		$.ajax({	
			url: "/api/catOne",
			method: "GET",
			dataType: "html",
			success: function(cat) {
				$("#cat1_area").text("이름:" + cat.name + " 나이:" + cat.age);
			
			},
			error: function(xhr, status, error) {
			
			}
		})
		});	
					
	$("#cat2").on("click", function() {	
		$.ajax({	
			url: "/api/catTwo",
			method: "GET",
			dataType: "html",
			success: function(cat) {
				$("#cat2_area").text("이름:" + cat.name + " 나이:" + cat.age);
			
			},
			error: function(xhr, status, error) {
			
			}
		})
		});	
//	} 대신				
});	// 이렇게 마무리 해야되는거 주의.				