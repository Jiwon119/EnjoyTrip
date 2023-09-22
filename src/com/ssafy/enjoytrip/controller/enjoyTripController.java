package com.ssafy.enjoytrip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.service.AttractionService;
import com.ssafy.enjoytrip.model.service.AttractionServiceImpl;


@WebServlet("/enjoyTrip")
public class enjoyTripController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static AttractionService service = AttractionServiceImpl.getInstance();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String path = "";
		if ("map".equals(action)) {
			path = map(request, response);
			forward(request, response, path);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	private String indexSearch(HttpServletRequest request, HttpServletResponse response) {
		try {
			AttractionInfoDto info = new AttractionInfoDto();
			info.setAddr1(request.getParameter(""));
			service.attractionList(info);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "목록 로드 실패");
			return "/error/error.jsp";
		}
		return "/map/map.jsp";
	}
	
	private String map(HttpServletRequest request, HttpServletResponse response) {
		try {
//			List<AttractionInfoDto> list = new ArrayList<>();
//			
//			AttractionInfoDto info = new AttractionInfoDto();
//
//			list = service.attractionList(info);
//			request.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "목록 로드 실패");
			return "/error/error.jsp";
		}
		return "/map/map.jsp";
	}
}
