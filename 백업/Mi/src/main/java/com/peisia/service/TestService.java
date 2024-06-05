package com.peisia.service;

import java.util.ArrayList;

import com.peisia.dto.TestDto;

public interface TestService {
	
	public ArrayList<TestDto> getList(int currentPage);
	
	public TestDto read(long bno);
	
	boolean login(String id, String pw);
	
	public void del(long bno);	
	
	public void write(TestDto dto);
	
	public void modify(TestDto dto);
	
	public ArrayList<TestDto> search(String word , int currentPage);
	
	public int getListCount(String word);
	
	public TestDto pageingBlock(String word, int currentPage);
	
	public void member(TestDto dto);


}
