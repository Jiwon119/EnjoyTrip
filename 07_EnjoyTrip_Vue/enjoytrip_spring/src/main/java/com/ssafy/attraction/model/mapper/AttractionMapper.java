package com.ssafy.attraction.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.attraction.model.AttractionInfoDto;

@Mapper
public interface AttractionMapper {

	List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto, String title);

	List<AttractionInfoDto> searchByTitle(String title, int sidoCode);

}
