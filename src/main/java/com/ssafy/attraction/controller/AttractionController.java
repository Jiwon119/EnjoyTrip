package com.ssafy.attraction.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionInfoDto;
import com.ssafy.attraction.model.service.AttractionService;
import com.ssafy.attraction.model.service.AttractionServiceImpl;

@Controller
@RequestMapping("/map")
public class AttractionController {

	private AttractionService attractionService;

	public AttractionController(AttractionService attractionService) {
		super();
		this.attractionService = attractionService;
	}
	
	////////////////////////////////////////////////////////////////
	
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
