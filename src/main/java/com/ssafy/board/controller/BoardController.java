package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.ParameterCheck;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
@Api(tags = {"Board Controller  API V1"})
public class BoardController {

	private int pgno;
	private String key;
	private String word;
	private String queryStrig;
	
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	
	@ApiOperation(value = "article", notes = "게시글 목록을 반환해줍니다.")
	@PostMapping("/list")
	public ResponseEntity<?> list(
			@RequestParam(value = "loginUser", required = false) MemberDto loginUser,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "pgno", required = false) String ParamPgno,
			@RequestParam(value = "key", required = false) String ParamKey,
			@RequestParam(value = "word", required = false) String ParamWord) {
		
		pgno = ParameterCheck.notNumberToOne(ParamPgno);
		key = ParameterCheck.nullToBlank(ParamKey);
		word = ParameterCheck.nullToBlank(ParamWord);
		
		Map<String, Object> responseData = new HashMap<>();
		
//		if (loginUser != null) {
			try {
				Map<String, String> map = new HashMap<String, String>();
				map.put("pgno", pgno + "");
				map.put("key", key);
				map.put("word", word);
				
				List<BoardDto> list = boardService.listArticle(map);
				int n = list.size();
				
				String sort = type;
				
				if(sort != null) {
					if(sort.equals("sort")) {
						//reverse Insertion Sort
						for(int i = 1; i < n; i++) {
							BoardDto key = list.get(i);
							int j = i - 1;
							while(0 <= j && list.get(j).getHit() < key.getHit()) {
								list.set(j+1, list.get(j));
								j--;
							}
							list.set(j+1, key);
						}
					}
				}
				
				responseData.put("articles", list);
				
				PageNavigation pageNavigation = boardService.makePageNavigation(map);
				responseData.put("navigation", pageNavigation);
				
				return new ResponseEntity<Map<String, Object>>(responseData, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return exceptionHandling(e); 
			}
//		}

	}
	
	@ApiOperation(value = "article", notes = "게시글 목록을 반환해줍니다.")
	@PostMapping("/view")
	private  ResponseEntity<?> view(
			@RequestParam(value = "loginUser", required = false) MemberDto loginUser,
			@RequestParam(value = "articleno", required = false) int articleNo
			) {

//		if (loginUser != null) {
			try {
				BoardDto boardDto = boardService.getArticle(articleNo);
				boardService.updateHit(articleNo);

				return new ResponseEntity<>(boardDto, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return exceptionHandling(e); 
			}
//		} else
//			return "/user/login.jsp";
	}
	
//	private String write() {
//		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("login");
//		if (memberDto != null) {
//			BoardDto boardDto = new BoardDto();
//			boardDto.setUserId(memberDto.getId());
//			boardDto.setSubject(request.getParameter("subject"));
//			boardDto.setContent(request.getParameter("content"));
//			try {
//				boardService.writeArticle(boardDto);
//				return "/article?action=list";
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("msg", "글작성 중 문제 발생!!!");
//				return "/error/error.jsp";
//			}
//		} else
//			return "/user/login.jsp";
//	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getParameter("action");
//		pgno = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
//		key = ParameterCheck.nullToBlank(request.getParameter("key"));
//		word = ParameterCheck.nullToBlank(request.getParameter("word"));
//		queryStrig = "pgno=" + pgno + "&key=" + key + "&word=" + URLEncoder.encode(word, "utf-8");
//
//		String path = "";
//		if ("list".equals(action)) {
//			path = list(request, response);
//			forward(request, response, path);
//		} else if ("view".equals(action)) {
//			path = view(request, response);
//			forward(request, response, path);
//		} else if ("mvwrite".equals(action)) {
//			path = "/board/write.jsp";
//			redirect(request, response, path);
//		} else if ("write".equals(action)) {
//			path = write(request, response);
//			redirect(request, response, path);
//		} else if ("mvmodify".equals(action)) {
//			path = mvModify(request, response);
//			forward(request, response, path);
//		} else if ("modify".equals(action)) {
//			path = modify(request, response);
//			forward(request, response, path);
//		} else if ("delete".equals(action)) {
//			path = delete(request, response);
//			redirect(request, response, path);
//		} else {
//			redirect(request, response, path);
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		doGet(request, response);
//	}
//
//	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//		dispatcher.forward(request, response);
//	}
//
//	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
//		response.sendRedirect(request.getContextPath() + path);
//	}
//
//	
//	private String write(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("login");
//		if (memberDto != null) {
//			BoardDto boardDto = new BoardDto();
//			boardDto.setUserId(memberDto.getId());
//			boardDto.setSubject(request.getParameter("subject"));
//			boardDto.setContent(request.getParameter("content"));
//			try {
//				boardService.writeArticle(boardDto);
//				return "/article?action=list";
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("msg", "글작성 중 문제 발생!!!");
//				return "/error/error.jsp";
//			}
//		} else
//			return "/user/login.jsp";
//	}
//
//	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
//		// TODO : 수정하고자하는 글의 글번호를 얻는다.
//		// TODO : 글번호에 해당하는 글정보를 얻고 글정보를 가지고 modify.jsp로 이동.
//		try {
//			HttpSession session = request.getSession();
//			MemberDto memberDto = (MemberDto) session.getAttribute("login");
//			if(memberDto != null) {
//				int articleNo = Integer.parseInt(request.getParameter("articleno"));
//				BoardDto boardDto = boardService.getArticle(articleNo);
//				request.setAttribute("article", boardDto);
//				
//				return "/board/modify.jsp";
//			} else
//				return "/user/login.jsp";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "글내용 얻는 중 문제 발생!!!");
//			return "/error/error.jsp";
//		}
//	}
//
//	private String modify(HttpServletRequest request, HttpServletResponse response) {
//		// TODO : 수정 할 글정보를 얻고 BoardDto에 set.
//		// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
//		// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
//		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("login");
//		if(memberDto != null) {
//			BoardDto boardDto = new BoardDto();
//			boardDto.setArticleNo(Integer.parseInt(request.getParameter("articleno")));
//			boardDto.setSubject(request.getParameter("subject"));
//			boardDto.setContent(request.getParameter("content"));
//			
//			try {
//				boardService.modifyArticle(boardDto);
//				return "/article?action=list&pgno=1&key=&word=";
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("msg", "글수정 중 문제 발생!!!");
//				return "/error/error.jsp";
//			}
//			
//		} else
//			return "/user/login.jsp";
//	}
//
//	private String delete(HttpServletRequest request, HttpServletResponse response) {
//		// TODO : 삭제할 글 번호를 얻는다.
//		// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
//		// TODO : 글삭제 완료 후 list.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
//		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("login");
//		if(memberDto != null) {
//			int articleNo = Integer.parseInt(request.getParameter("articleno"));
//			
//			try {
//				boardService.deleteArticle(articleNo);
//				return "/article?action=list&pgno=1&key=&word=";
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("msg", "글삭제 중 문제 발생!!!");
//				return "/error/error.jsp";
//			}
//			
//		} else
//			return "/user/login.jsp";
//	}

}
