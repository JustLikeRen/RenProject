package com.peisia.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dto.TestDto;
import com.peisia.service.TestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
@AllArgsConstructor
@Controller
public class TestController {
	private TestService service;
	
	
		@GetMapping("/login") // GET 요청을 처리하는 메서드 추가
		    public String showLoginPage() {
		        return "test/login";
		    }
		 
		@PostMapping("/login")
		public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model, HttpSession session) {
			if (service.login(id, pw)) {
				 log.info("로그인성공");
				 	session.setAttribute("login",service.login(id, pw));
			        return "redirect:/test/getList?currentPage=1"; // 로그인 성공 시 다른 페이지로 이동
			    } else {
			        model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
			        log.info("로그인실패");
			        return "redirect:/test/login"; // 로그인 실패 시 로그인 페이지로 다시 이동
			    }
		}
	
	@GetMapping("/getList")	// 프로젝트 루트 경로 이하 /test/getList url 진입 시 여기로 진입하게 됨.
	public void getList(
			@RequestParam(value="word", defaultValue="") String word,
			@RequestParam(value="currentPage", defaultValue="1")int currentPage, Model model) {	
//		if (word.equals("")) {
//			model.addAttribute("list",service.getList(currentPage));
//			model.addAttribute("page",service.pageingBlock(word,currentPage));
//		}else{
//			
			model.addAttribute("list",service.search(word,currentPage));
			model.addAttribute("page",service.pageingBlock(word,currentPage));
//		}
	}	
	
	@GetMapping({"/read","modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		service.del(bno);
		return "redirect:/test/getList";	//sendRedirect 로 이동하게 됨.
	}		
	
	@PostMapping("/write")
	//폼 태그의 텍스트에어리어 태그에 btext 변수로 데이터가 넘어왔는데
	//매개변수에 (GuestVO gvo) 이런 클래스를 선언해놓게 되면
	//해당 객체의 멤버변수에 스프링이 알아서 채워줌.
	public String write(TestDto dto) {
		service.write(dto);
		return "redirect:/test/getList";
	}
	
	@GetMapping("/write")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {
		
	}	
	
	@PostMapping("/modify")
	public String modify(TestDto dto) {
		service.modify(dto);
		return "redirect:/test/getList";
	}		

	@GetMapping("/member")
	public void member(){
		
	}
	@PostMapping("/member")
	public String member(TestDto dto) {
		service.member(dto);
		return "/login";
	}
}

