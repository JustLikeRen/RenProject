package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.KWeatherDto;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/weather")
public class WeatherController {

	@GetMapping("/w")										
	public String w(Model model) {										
		//// 우리나라 공공 api ////									
		//인코딩 인증키									
		String API_KEY = "07ceLHBKTR1U7CW4yFs%2FAAK3LGlL73237qwpjaAtW77tGAohL08pvyt6xDh3%2BdJg4wMDANJcZ3wfT4ptelctRg%3D%3D";									
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20240310&endDt=20240310&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey=" + API_KEY;									
				// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.							
		RestTemplate restTemplate = new RestTemplate();									
											
		//// **** 중요 **** uri									
		URI uri = null; //java.net.URI 임포트 하셈									
		try {									
			uri = new URI(API_URL);								
		} catch (URISyntaxException e) {									
			e.printStackTrace();								
		}									
											
//		String s = restTemplate.getForObject(uri, String.class); //									
//		log.info("====== 우리나라 날씨 잘 나오나? "+s);
//		System.out.println("====== 우리나라 날씨 잘 나오나? "+s);
		
		KWeatherDto kw = restTemplate.getForObject(uri, KWeatherDto.class); // 자기 클래스로 바꾸시오..				
//		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);				
//		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);				
		String tMin = kw.response.body.items.item.get(0).minTa;				
		String location = kw.response.body.items.item.get(0).stnNm;				
		String tMax = kw.response.body.items.item.get(0).maxTa;				
		String ddara = String.format("==== json ==== : 어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location, tMin, tMax);				
		log.info(ddara);				
		model.addAttribute("aaa",kw);
		
		return "/weather/test";
	}
	
	
}
