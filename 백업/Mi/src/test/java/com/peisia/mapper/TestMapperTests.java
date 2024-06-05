package com.peisia.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestMapperTests {
	@Autowired
	private TestMapper mapper;
	@Test
	public void testGetList() {
//		TestDto sData1= mapper.getData1();
//		TestDto sData2= mapper.getData2();
//		TestDto sData3= mapper.getData3();
		
//		log.info(sData1);
//		log.info(sData2);
//		log.info(sData3);
//		
//		String s1 =sData1.getStr_data();
//		String s2 =sData2.getStr_data();
//		String s3 =sData3.getStr_data();
//		
//		int n1 = Integer.parseInt(s1);
//		int n2 = Integer.parseInt(s2);
//		int n3 = Integer.parseInt(s3);
//		
//		int sum = n1+n2;
//		int sum1 = n2+n3;
//		
//		log.info("1+2="+sum);
//		log.info("2+100="+sum1);
	}
}
