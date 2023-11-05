package com.ssafy.attraction.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionInfoDto;
import com.ssafy.attraction.model.service.AttractionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/map")
@CrossOrigin("*")
@Api(tags = {"Attraction Controller  API V1"})
public class AttractionController {

	private AttractionService attractionService;

	public AttractionController(AttractionService attractionService) {
		super();
		this.attractionService = attractionService;
	}
	
	@ApiOperation(value = "map", notes = "지도의 <big>전체 목록</big>을 반환해 줍니다.")
	@PostMapping("/mapList")
	public ResponseEntity<?> list() {
		List<AttractionInfoDto> list = attractionService.attractionList(null, null);

		return new ResponseEntity<List<AttractionInfoDto>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "map", notes = "지도의 <big>검색 결과</big>을 반환해 줍니다.")
	@PostMapping("/mapSearch")
	public ResponseEntity<?> search(@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "keyword", required = false) String keyword) {

		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
		if(area != null) attractionInfoDto.setSidoCode(Integer.parseInt(area));
		if(type != null) attractionInfoDto.setContentTypeId(Integer.parseInt(type));
		List<AttractionInfoDto> list = attractionService.attractionList(attractionInfoDto, keyword);

		return new ResponseEntity<List<AttractionInfoDto>>(list, HttpStatus.OK);
	}
	
}
