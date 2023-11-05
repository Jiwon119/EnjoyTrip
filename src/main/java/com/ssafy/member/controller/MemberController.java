package com.ssafy.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.attraction.model.AttractionInfoDto;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.util.DBUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
@Api(tags = {"Member Controller  API V1"})
public class MemberController {

	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	
//	@GetMapping("/mypage")
//	private String mypage(HttpSession session, @PathVariable("userid") String id) {
//		MemberDto member = memberService.myPage(id);
//		System.out.println("member");
//		session.setAttribute("mypage", member);
//
//		return "member/mypage";
//	}

	@ApiOperation(value = "regist", notes = "회원가입")
	@PostMapping("/regist")
	protected ResponseEntity<?> regist(MemberDto member) throws Exception {
		Map<String , String> map = new HashMap<String, String>();
		memberService.regist(member);
		map.put("msg", "회원가입 성공");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value = "login", notes = "로그인")
	@PostMapping("/login")
	protected ResponseEntity<?> login(
			HttpSession session,
			@RequestParam("id") String id,
			@RequestParam("password") String password
			) throws Exception {
		Map<String , String> map = new HashMap<String, String>();
		MemberDto member = memberService.login(id, password);
		if(member != null) {
			map.put("msg", "로그인 성공");
			session.setAttribute("loginUser", member);
		}else {
			map.put("msg", "로그인 실패");		
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value = "mypage", notes = "유저 정보 페이지")
	@GetMapping("/mypage/{userId}")
	public ResponseEntity<?> mypage(@PathVariable("userId") String id) throws Exception {
		MemberDto member = memberService.selectMember(id);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}
	
	@ApiOperation(value = "deleteMember", notes = "유저 탈퇴")
	@DeleteMapping("/delete/{userId}")
	protected ResponseEntity<?> deleteMember( 
			HttpSession session ,
			@PathVariable("userId") String id) throws Exception {
		Map<String , String> map = new HashMap<String, String>();

		memberService.delete(id);
		map.put("msg", "회원 탈퇴 성공");
		session.invalidate();
		
		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getParameter("action");
//		System.out.print(action);
//		
//		switch(action) {
//			case "mypage":
//				mypage(request, response);
//				break;
//			case "logout":
//				logout(request, response);
//				break;
//			case "searchPass":
//				searchPass(request, response);
//				break;
//			case "delete":
//				doPost(request, response);
//				break;
//		}
//	}
//	
//
//	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		session.setAttribute("login", null);
//		session.setAttribute("mypage", null);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
//		dispatcher.forward(request, response);
//	}
//
//
//	private void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String id = request.getParameter("id");
//		MemberDto member = memberService.myPage(id);
//		session.setAttribute("mypage", member);
//		
//		System.out.print(member);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/mypage.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void searchPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
//		String email = request.getParameter("email");
//		
//		MemberDto member = memberService.searchPass(id, email);
//		request.setAttribute("searchPass", member);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/searchpassResult.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getParameter("action");
//		System.out.print(action);
//		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		HttpSession session = request.getSession();
//		if(slidingWindow(id, password) == 1) {
//			session.setAttribute("msg", "비밀번호 안에 아이디 문자열이 포함될 수는 없습니다!");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
//			dispatcher.forward(request, response);
//			session.setAttribute("msg", null);
//			return;
//		}
//		
//		switch(action) {
//			case "login":
//				login(request, response);
//				break;
//			case "regist":
//				regist(request, response);
//				break;
//			case "update":
//				doUpdate(request, response);
//				break;
//			case "modify":
//				doModify(request, response);
//				break;
//			case "delete":
//				doDelete(request, response);
//				break;
//			}
//	}
//	
//	protected static int slidingWindow(String id, String password) {
//		int idLength = id.length();
//        int passwordLength = password.length();
//        
//        if (idLength > passwordLength) return 0;
//        
//        for (int i = 0; i <= passwordLength - idLength; i++) {
//            boolean found = true;
//
//            for (int j = 0; j < idLength; j++) {
//                if (id.charAt(j) != password.charAt(i + j)) {
//                    found = false;
//                    break;
//                }
//            }
//
//            if (found) return 1;
//        }
//        
//		return 0;
//	}
//	

//	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String action = request.getParameter("action");
//		System.out.print(action);
//		
//		MemberDto dto = (MemberDto)session.getAttribute("login");
//		String id = dto.getId();
//		memberService.delete(id);
//		session.setAttribute("login", null);
//		session.setAttribute("mypage", null);
//		session.setAttribute("msg", "탈퇴 되었습니다.");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
//		dispatcher.forward(request, response);
//		session.setAttribute("msg", null);
//	}
//	
//	protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String action = request.getParameter("action");
//		System.out.print(action);
//		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		password = BCrypt.hashpw(password, BCrypt.gensalt());
//		int age = Integer.parseInt(request.getParameter("age"));
//		String email = request.getParameter("email");
//		String address = request.getParameter("address");
//		
//		MemberDto member = new MemberDto();
//		
//		member.setId(id);
//		member.setPassword(password);
//		member.setAge(age);
//		member.setEmail(email);
//		member.setAddress(address);
//		
//		MemberDto result = memberService.update(member);
//		
//		session.setAttribute("mypage", result);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/mypage.jsp");
//		dispatcher.forward(request, response);
//		
//	}
//	
//	protected void doModify(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String action = request.getParameter("action");
//		System.out.print(action);
//		
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		password = BCrypt.hashpw(password, BCrypt.gensalt());
//		int age = Integer.parseInt(request.getParameter("age"));
//		String email = request.getParameter("email");
//		String address = request.getParameter("address");
//		
//		MemberDto member = new MemberDto();
//		
//		member.setId(id);
//		member.setPassword(password);
//		member.setAge(age);
//		member.setEmail(email);
//		member.setAddress(address);
//		
//		MemberDto result = memberService.update(member);
//		
//		//session.setAttribute("mypage", result);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//		dispatcher.forward(request, response);
//		
//	}
	
	
}