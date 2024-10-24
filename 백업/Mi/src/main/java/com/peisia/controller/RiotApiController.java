package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.peisia.dto.RiotDto;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/riot/*")
public class RiotApiController {

	ObjectMapper objectMapper = new ObjectMapper();
	@RequestMapping("/searchss")
	public void searchss() {
		
	}
	
	@ResponseBody
	@GetMapping("/searchs")
	public void searchs(
			@RequestParam("searchName") String searchName,
			@RequestParam("tag") String tag,
			Model model) {
		RiotDto riot = new RiotDto();
		RiotDto match = new RiotDto();
		// UTF-8형싟으로 변환
		String characterName = URLEncoder.encode(searchName, StandardCharsets.UTF_8);
		String tagName = URLEncoder.encode(tag, StandardCharsets.UTF_8);
		// 매일매일 바꿔줘야함
		String API_KEY = "RGAPI-8cf36b8d-f566-4d20-a887-2d54e50dbbd7";
		// 
		String API_URI = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/"+characterName+"/"+tagName+"?api_key="
				+ API_KEY;
		// 내장객채 URL or URI (JSON화)관련
		RestTemplate restTemplate = new RestTemplate();
		
		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URI);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		// JSON 형식으로 문자열 압축
		String RD = restTemplate.getForObject(uri, String.class);
		
		try {
            // JSON 문자열을 RiotDto 객체로 변환
			Gson gson = new Gson();
//	JSON어레이 쓸대 글대로 못넣어서 오브젝트 뭐시기 부르고 포문으로 하나씩 넣어야됨 = 형주
			  riot = gson.fromJson(RD, RiotDto.class);
//			riot = objectMapper.readValue(RD,RiotDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
//		model.addAttribute("asdf",riot); // 검색해서 나온 puuid , 닉네임, 태그 정보 있음
		
		
		String Puuid = riot.puuid;
//		RiotDto riotDto = (RiotDto)model.getAttribute("asdf");
//		
//		String puuid = riotDto.getPuuid();
//		System.out.println("puuid: " + puuid);
		
		String API_URI2 = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/"+Puuid+"/ids?start=0&count=20&api_key="+API_KEY;
		
		URI uri2 = null; // java.net.URI 임포트 하셈
		try {
			uri2 = new URI(API_URI2);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		String RD2 = restTemplate.getForObject(uri2, String.class);
		 
		try {
            // JSON 문자열을 RiotDto 객체로 변환
			Gson gson2 = new Gson();
			List<String> matchList = gson2.fromJson(RD2, new TypeToken<List<String>>(){}.getType());
//			Gson gson2 = new Gson();
//			  match = gson2.fromJson(RD2, RiotDto.class);
//			riot = objectMapper.readValue(RD,RiotDto.class);
			
			List<RiotDto> matchDtoList = new ArrayList<>();
		    
		    for (String itemId : matchList) {
		        String API_URI3 = "https://asia.api.riotgames.com/lol/match/v5/matches/"+itemId+"?api_key=" + API_KEY;
		        URI uri3 = null;
		        
		        try {
		            uri3 = new URI(API_URI3);
		        } catch (URISyntaxException e) {
		            e.printStackTrace();
		        }
		        
		        String RD3 = restTemplate.getForObject(uri3, String.class);
		        RiotDto matchDto = gson2.fromJson(RD3, RiotDto.class);
		        matchDtoList.add(matchDto);
		       
		    }
		    
		    model.addAttribute("aabb", matchDtoList);
		    
		    System.out.println(matchDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	@GetMapping("/search")
	public String search(@RequestParam("searchName") String searchName, Model model) {
		//// 우리나라 공공 api ////
		// 인코딩 인증키
		
		String API_KEY = "RGAPI-8cf36b8d-f566-4d20-a887-2d54e50dbbd7"; // 매일매일 바꿔줘야함
		String API_URL = "http://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + searchName + "?api_key="
				+ API_KEY;
		
		RestTemplate restTemplate = new RestTemplate();
		
		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		RiotDto RD = restTemplate.getForObject(uri, RiotDto.class);
		//이건 방식이 엄청 여러가지있음.
		//
		String encordId = RD.id;
		log.info(encordId);
		String API_PRIMARY = "http://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encordId + "?api_key="
				+ API_KEY;
		RestTemplate restTemplate2 = new RestTemplate();
		log.info(API_PRIMARY);
		//// **** 중요 **** uri
		URI uri2 = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_PRIMARY);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		RiotDto RDD = restTemplate2.getForObject(uri2, RiotDto.class);
		
		model.addAttribute("asd",RDD);
		return "/riot/search";
	}
}

