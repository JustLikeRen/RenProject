package kr.bit.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/weather")
public class WeatherController {

	@GetMapping("/w")										
	public String w() {										
		//// 우리나라 공공 api ////									
		//인코딩 인증키									
		String API_KEY = "07ceLHBKTR1U7CW4yFs%2FAAK3LGlL73237qwpjaAtW77tGAohL08pvyt6xDh3%2BdJg4wMDANJcZ3wfT4ptelctRg%3D%3D";									
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20240228&endDt=20240228&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey=" + API_KEY;									
				// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.							
		RestTemplate restTemplate = new RestTemplate();									
											
		//// **** 중요 **** uri									
		URI uri = null; //java.net.URI 임포트 하셈									
		try {									
			uri = new URI(API_URL);								
		} catch (URISyntaxException e) {									
			e.printStackTrace();								
		}									
											
		String s = restTemplate.getForObject(uri, String.class); //									
		log.info("====== 우리나라 날씨 잘 나오나? "+s);

		return "home";
	}
	
	
}
