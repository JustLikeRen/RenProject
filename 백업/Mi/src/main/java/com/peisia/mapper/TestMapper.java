package com.peisia.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.peisia.dto.TestDto;

public interface TestMapper {
		
	public ArrayList<TestDto> getList(int limitIndex);
	
	public TestDto read(long bno);
	
	public int login(@Param("id") String id, @Param("pw") String pw);
	
	public void del(long bno);
	
	public void write(TestDto dto);
	
	public void modify(TestDto dto);
	
	public ArrayList<TestDto> search(TestDto dto);

	public int getListCount(TestDto dto);

	public void member(TestDto dto);

}
