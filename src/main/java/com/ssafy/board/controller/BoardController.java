package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.ParameterCheck;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

	
	@ApiOperation(value = "article", notes = "게시글 목록을 반환해줍니다. (페이지네이션 미적용 (임시))")
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
				
				return new ResponseEntity<>(responseData, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return exceptionHandling(e); 
			}

	}
	
	@ApiOperation(value = "article", notes = "게시글 번호로 검색")
	@GetMapping("/view/{articleNo}")
	protected ResponseEntity<?> view(
			@PathVariable(value = "articleNo") int articleNo
			) throws Exception {
				Map<String, Object> responseData = new HashMap<>();
				BoardDto boardDto = boardService.getArticle(articleNo);
				boardService.updateHit(articleNo);
				responseData.put("article", boardDto);
					
				return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@ApiOperation(value = "article", notes = "게시글을 작성합니다.")
	@PostMapping("/write")
	protected ResponseEntity<?> write(BoardDto board) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		boardService.writeArticle(board);
		map.put("msg", "게시글 작성 성공");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
//	@ApiOperation(value = "article", notes = "수정하고자하는 글번호 반환")
//	@PostMapping("/mvModify")
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
	
	
	@ApiOperation(value = "article", notes = "글 수정하기")
	@PutMapping("/modify")
	private ResponseEntity<?> modify(
			@RequestParam(value = "articleNo") int articleNo,
			@RequestParam(value = "subject", required = false) String subject,
			@RequestParam(value = "content", required = false) String content
			) throws Exception {
		Map<String , Object> map = new HashMap<String, Object>();
		BoardDto board = new BoardDto();
		board.setArticleNo(articleNo);
		board.setSubject(subject);
		board.setContent(content);
		boardService.modifyArticle(board);
		map.put("msg", "글 수정 성공");
		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "article", notes = "글 삭제하기")
	@DeleteMapping("/remove/{articleNo}")
	private ResponseEntity<?> delete(
			@PathVariable(value = "articleNo") int articleNo) throws Exception {
			Map<String , String> map = new HashMap<String, String>();
			boardService.deleteArticle(articleNo);
			return new ResponseEntity<>(map, HttpStatus.OK); 
	}
}
