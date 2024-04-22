package com.ahn.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahn.memo.user.bo.UserBO;
import com.ahn.memo.user.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBo;
	
	@PostMapping("/signup")
	public Map<String,String> signup(
			@RequestParam("id") String id
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("email") String email) {
		
		int insert = userBo.insertUser(id, password, name, email);
		
		Map<String,String> result = new HashMap<>();
		
		if(insert == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
		
	}
	
	@PostMapping("/signin")
	public Map<String,String> signin(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		
		User user = userBo.selectUser(loginId, password);
		Map<String, String> result = new HashMap<>();
		
		if(user != null) {
			result.put("result", "success");
			
			// 세션 객체 얻어오기
			HttpSession session = request.getSession();
			// 세션에 특정한 값이 저장되어 있으면 로그인 된 상태
			// 세션에 특정한 값이 저장되어 있지 않으면 로그인이 되어있지 않은 상태
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	@GetMapping("/signup/duplication")
	public Map<String, Boolean> signupDuplication(@RequestParam("loginId") String loginId) {
		
		int count = userBo.selectLoginId(loginId);
		
		Map<String, Boolean> result = new HashMap<>();
		
		result.put("result", count == 1);

		return result;
	}
	
}
