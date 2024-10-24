package com.peisia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peisia.dto.GuestDto;
import com.peisia.mapper.GuestMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{
	@Autowired
	private GuestMapper mapper;
	
	@Override
	public ArrayList<GuestDto> getList() {
		log.info("비지니스 계층===========");
		return mapper.getList();
	}
	
	@Override
	public GuestDto read(long bno) {
		log.info("read=======");
		return mapper.read(bno);
	}
	
}
