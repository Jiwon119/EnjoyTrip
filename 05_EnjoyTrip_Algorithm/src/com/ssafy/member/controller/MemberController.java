package com.ssafy.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;
	
	public void init() {
		memberService = MemberServiceImpl.getMemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("login")) {
			doLogin(request, response);
		}else if(action.equals("loginForm")) {
			request.getRequestDispatcher("/member/login.jsp").forward(request, response);
		}else if(action.equals("logout")) {
			doLogout(request,response);
		}else if(action.equals("mypage")) {
			response.sendRedirect("/member/mypage.jsp");
		}else if(action.equals("update")) {
			doUpdate(request,response);
		}else if(action.equals("remove")) {
			doRemove(request,response);
		}else if(action.equals("regist")) {
			doRegist(request, response);
		}else if(action.equals("registForm")) {
			request.getRequestDispatcher("/member/regist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");

		MemberDto memberDto = new MemberDto();
		memberDto = memberService.login(userId, userPass);

		if(memberDto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memberDto);
			request.setAttribute("msg", "로그인 성공!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요!");
			request.getRequestDispatcher("/member?action=loginForm").forward(request, response);
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("loginUser");
	
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		memberDto.setUserName(userName);
		memberDto.setUserEmail(userEmail);
		
		memberDto = memberService.modifyMember(memberDto);
		if(memberDto != null) {
			session.setAttribute("loginUser", memberDto);
			request.setAttribute("msg", "정보 수정 성공!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "정보 수정 실패!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}
	
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto)session.getAttribute("loginUser");
		
		int res = memberService.deleteMember(memberDto.getUserId());
		if(res != 0) {
			session.invalidate();
			request.setAttribute("msg", "회원 탈퇴 되었습니다.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "회원 탈퇴에 실패하였습니다.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		MemberDto memberDto = new MemberDto(userId, userName, userPass, userEmail);
		
		int res = memberService.registerMember(memberDto);
		if(res != 0) {
			request.setAttribute("msg", "회원 가입이 완료되었습니다.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "회원 가입에 실패하였습니다.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
