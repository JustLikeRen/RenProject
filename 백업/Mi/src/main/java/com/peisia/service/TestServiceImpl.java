package com.peisia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.dto.TestDto;
import com.peisia.mapper.TestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class TestServiceImpl implements TestService{

	@Setter(onMethod_ = @Autowired)
	private TestMapper mapper;	
	
	@Override
	public ArrayList<TestDto> getList(int currentPage) {
		log.info("비지니스 계층===========");
		int limitIndex = (currentPage-1) * 5;
		return mapper.getList(limitIndex);
	}
	
	@Override
	public TestDto read(long bno) {
		return mapper.read(bno);
	}	
	
//	@Override
//	public TestDto login(String id,String pw){
//		log.info("서비스 로그인 확인");
//		return mapper.login(id,pw);
//	}

	@Override	
	public boolean login(String id, String pw) {
	    int count = mapper.login(id, pw);
	    return count > 0; // 로그인 성공 여부 반환
	}
	
	@Override
	public void del(long bno) {
		mapper.del(bno);
	}		
	
	@Override
	public void write(TestDto dto) {
		
		mapper.write(dto);
	}
	
	@Override
	public void modify(TestDto dto) {
		mapper.modify(dto);
	}
	
	public ArrayList<TestDto> search(String word, int currentPage) {
		TestDto dto = new TestDto();
		dto.setLimitIndex((currentPage-1) * 5);
		dto.setWord(word);
		return mapper.search(dto);
	}
	
	public int getListCount(String word) {
		TestDto dto = new TestDto();
		dto.setWord(word);
		return mapper.getListCount(dto);
	}
//	public TestDto pageingBlock(String word) {
//		TestDto dto = new TestDto();
//		int aaa = getListCount(word);
//		System.out.println("햇갈리면안되 이거 인트값확인용:"+aaa);
//		dto.setCount(aaa);
//		return dto;
//	}

	@Override
	public TestDto pageingBlock(String word,int currentPage) {
		TestDto page = new TestDto();
		log.info("비지니스 계층===========");
		page.setWord(word);
		page.setTotalPage((int) Math.ceil((double) getListCount(word) / 5));
		page.setTotalBlock((int) Math.ceil((double) page.getTotalPage() / 5));
		page.setCurrentBlockNo((int) Math.ceil((double) currentPage / 5));
		page.setBlockStartNo((page.getCurrentBlockNo() - 1) * 5 + 1);
		page.setBlockEndNo(page.getCurrentBlockNo() * 5);

		if (page.getBlockEndNo() > page.getTotalPage()) {
			page.setBlockEndNo(page.getTotalPage());
		}
		if (page.getCurrentBlockNo() <= 1) {
			page.setHasPrev(false);
		} else {
			page.setHasPrev(true);
			page.setPrevPage((page.getCurrentBlockNo() - 1) * 5);
		}
		if (page.getCurrentBlockNo() < page.getTotalBlock()) {
			page.setHasNext(true);
			page.setNextPage(page.getCurrentBlockNo() * 5 + 1);
		} else {
			page.setHasNext(false);
		}
		return page;
	}
	
	@Override
	public void member(TestDto dto) {
	    mapper.member(dto);
	}
}

