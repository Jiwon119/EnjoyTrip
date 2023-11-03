package com.ssafy.attraction.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionInfoDto;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.attraction.model.service.AttractionServiceImpl;
import com.ssafy.member.model.MemberDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/map")
@CrossOrigin("*")
@Api(tags = {"어드민 컨트롤러  API V1"})
public class AttractionController {

	private AttractionService attractionService;

	public AttractionController(AttractionService attractionService) {
		super();
		this.attractionService = attractionService;
	}
	
	@ApiOperation(value = "맵", notes = "지도의 <big>전체 목록</big>을 반환해 줍니다.")
	@PostMapping("/mapList")
	public ResponseEntity<?> list(@RequestParam("area") String area,
			@RequestParam("type") String type,
			@RequestParam("keyword") String keyword) {

		if (keyword != null && !keyword.isEmpty())
			System.out.println("keyword is" + keyword);
		
		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
		if (area != null)
			attractionInfoDto.setSidoCode(Integer.parseInt(area));
		if (type != null)
			attractionInfoDto.setContentTypeId(Integer.parseInt(type));
		
		List<AttractionInfoDto> list = attractionService.attractionList(attractionInfoDto, keyword);

		return new ResponseEntity<List<AttractionInfoDto>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "맵", notes = "지도의 <big>검색 결과</big>을 반환해 줍니다.")
	@PostMapping("/mapSearch")
	public ResponseEntity<?> search(@RequestParam("area") String area,
			@RequestParam("type") String type,
			@RequestParam("keyword") String keyword) {

		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
		if(area != null) attractionInfoDto.setSidoCode(Integer.parseInt(area));
		if(type != null) attractionInfoDto.setContentTypeId(Integer.parseInt(type));
		List<AttractionInfoDto> list = attractionService.attractionList(attractionInfoDto, keyword);

		return new ResponseEntity<List<AttractionInfoDto>>(list, HttpStatus.OK);
	}
	
//	@PostMapping("/mapSearch")
//	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String area = req.getParameter("area");
//		String type = req.getParameter("type");
//		String keyword = req.getParameter("keyword");
//		if (keyword != null && !keyword.isEmpty())
//			System.out.println("keyword is" + keyword);
//		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
//		if (area != null)
//			attractionInfoDto.setSidoCode(Integer.parseInt(area));
//		if (type != null)
//			attractionInfoDto.setContentTypeId(Integer.parseInt(type));
//		List<AttractionInfoDto> list = attractionService.attractionList(attractionInfoDto, keyword);
//		req.setAttribute("result", list);
//		req.getRequestDispatcher("/map/map.jsp").forward(req, resp);
//	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String action = req.getParameter("action");
//		search(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
//		String action = req.getParameter("action");
//		System.out.print(action);
//		
//		switch(action) {
//		case "mapSearch":
//			search(req, resp);
//			break;
//		}
//	}
//	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String area = req.getParameter("area");
//		String type = req.getParameter("type");
//		String keyword = req.getParameter("keyword");
//		if(keyword != null && !keyword.isEmpty()) System.out.println("keyword is" + keyword );
//		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
//		if(area != null) attractionInfoDto.setSidoCode(Integer.parseInt(area));
//		if(type != null) attractionInfoDto.setContentTypeId(Integer.parseInt(type));
//		List<AttractionInfoDto> list = attractionService.attractionList(attractionInfoDto, keyword);
//		req.setAttribute("result", list);
//		req.getRequestDispatcher("/map/map.jsp").forward(req, resp);
//	}
	
}
