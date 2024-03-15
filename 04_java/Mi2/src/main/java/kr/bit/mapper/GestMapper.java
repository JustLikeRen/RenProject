package kr.bit.mapper;

import java.util.List;

import kr.bit.model.GestVo;

public interface GestMapper {
	public List<GestVo> gestList();
	public GestVo read();
}
