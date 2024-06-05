package com.peisia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peisia.dto.Cat;

@RequestMapping("/api/*")				
@Controller				//restController 를 쓰지않을땐 밑에 메소드에 @ResponseBody 를 어노테이션 해줘야함 안해줬더니 js 에서 ajax로 json방식을 못불러옴 ㅋㅋ
public class ApiCatController {		
	@ResponseBody
	@GetMapping("/catOne")			
	public Cat getCatOne() {			
		Cat cat = new Cat();		
		cat.setName("야옹이");		
		cat.setAge(5);		
				
		//이렇게 객체를 리턴하면 json 이 객체 구조로 해서 자동으로 출력됨. 		
		//즉, 이 주소로 api 요청을 하면 		
		//고양이 이름, 나이 json을 받아갈 수 있게 되는 것.		
		return cat; 		
	}			
	@ResponseBody
	@GetMapping("/catTwo")			
	public Cat getCatTwo() {			
		Cat cat = new Cat();		
		cat.setName("떼껄룩");		
		cat.setAge(10);		
		return cat;		
	}		
//	@ResponseBody
//	@GetMapping("/catTwo")			
//	public String getCatTwo() {			
//		Cat cat = new Cat();	
//		cat.setName("떼껄룩");		
//		cat.setAge(10);		
//		String cat2="이름:" + cat.getName() + " 나이:" + cat.getAge();
//		return cat2;		// json 형식으로 리턴하지않고 문자열 형태로 리턴해서 html 방식으로 꺼내쓸땐 이런식으로 쓰면됨 대신 한글은 깨지니까 utf-8 설정 해줘야함
//	}	
	
	@RequestMapping("/testapi")
	public void getTestApi() {
		
	}
	@ResponseBody
	@GetMapping("/getData")
	public String getData() {
		// 데이터를 생성하거나 가져옴
		String data = "<p>Hello, World!</p>";
		return data;
	}
}