package com.marobiana.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String hyungjubabo() {
		return "home";
	}
}
