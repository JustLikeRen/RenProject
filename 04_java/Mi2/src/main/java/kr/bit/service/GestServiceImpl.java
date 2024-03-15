package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.mapper.GestMapper;
import kr.bit.model.GestVo;

@Service
public class GestServiceImpl implements GestService{

	@Autowired
	private GestMapper mapper;
	@Override
	public List<GestVo> gestList() {
		
		return mapper.gestList();
	}
	
//	@Autowired
//	private GestMapper readMapper;
//	@Override
//	public GestVo read() {
//		
//		return readMapper.read();
//	}

}
