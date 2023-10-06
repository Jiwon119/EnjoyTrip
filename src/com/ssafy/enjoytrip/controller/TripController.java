package com.ssafy.enjoytrip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.service.AttractionService;
import com.ssafy.enjoytrip.model.service.AttractionServiceImpl;

@WebServlet("/tripinfo")
public class TripController extends HttpServlet {

	AttractionService service = AttractionServiceImpl.getAttractionServcie();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		switch (act) {
		case "list":
			doSearch(request, response);
			break;
		}
	}

	private void doSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
		String areaId = request.getParameter("search-area");
		String contentId = request.getParameter("search-content-id");
		String title = request.getParameter("search-keyword");
		// areaId와 contentId의 null값 확인
		if (areaId != null) {
			attractionInfoDto.setSidoCode(Integer.parseInt(areaId));
		}
		if (contentId != null) {
			attractionInfoDto.setContentTypeId(Integer.parseInt(contentId));
		}
		// title이 없는 경우 모두 검색
		if (title == null) {
			title = "";
		}

		List<AttractionInfoDto> attractionList = service.attractionList(attractionInfoDto, title);
		JSONArray jsonArrayList = new JSONArray();
		for (AttractionInfoDto dto : attractionList) {
			JSONObject jObj = new JSONObject();
			jObj.put("firstimage", dto.getFirstImage());
			jObj.put("title", dto.getTitle());
			jObj.put("addr1", dto.getAddr1());
			jObj.put("addr2", dto.getAddr2());
			jObj.put("mapy", dto.getLatitude());
			jObj.put("mapx", dto.getLongitude());
			jsonArrayList.put(jObj);
		}

		response.setContentType("application/x-json; charset=utf-8");
		response.getWriter().print(jsonArrayList);
	}

}
