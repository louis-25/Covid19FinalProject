package com.multi.covid.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.covid.domain.LiveVO;

@Mapper
@Repository
public interface LiveMapper {
	LiveVO getOneLive(String date);
}
