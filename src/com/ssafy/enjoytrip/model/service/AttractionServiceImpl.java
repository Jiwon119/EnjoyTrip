package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.dao.AttractionDaoImpl;

public class AttractionServiceImpl implements AttractionService{

	private static AttractionService attractionService = new AttractionServiceImpl();
	
	public static AttractionService getAttractionServcie() {
		return attractionService;
	}
	
	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto, String title) {
		List<AttractionInfoDto> attractionList = AttractionDaoImpl.getAttractionDao().attractionList(attractionInfoDto, title);
		return attractionList;
	}
}
