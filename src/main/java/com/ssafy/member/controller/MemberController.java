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
import io.swagger.annotations.ApiImplicitParam;
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
			@PathVariable("userId")  String id) throws Exception {
		Map<String , String> map = new HashMap<String, String>();

		memberService.deleteMember(id);
		map.put("msg", "회원 탈퇴 성공");
		session.invalidate();
		
		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "logout", notes = "로그아웃")
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		Map<String , String> map = new HashMap<String, String>();
		session.invalidate();
		map.put("msg", "로그아웃 성공");
		
		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "searchPass", notes = "비밀번호 찾기_회원 정보 일치 검사")
	@PostMapping("/searchPass")
	private ResponseEntity<?> searchPass(
			@RequestParam("id") String id,
			@RequestParam("email") String email,
			@RequestParam("name") String name
			)
			throws Exception {
		Map<String , Object> map = new HashMap<String, Object>();
		MemberDto member = memberService.searchPass(id, email, name);
		if(member != null) {
			map.put("member", member);
			map.put("msg", "회원정보 일치");
		}else {
			map.put("msg", "회원정보 없음");
		}

		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "updateMember", notes = "회원 정보 수정")
	@PostMapping("/updateMember")
	private ResponseEntity<?> updateMember(MemberDto member)
			throws Exception {
		Map<String , Object> map = new HashMap<String, Object>();
		int state = memberService.updateMember(member);
		if(state == 1) {
			map.put("msg", "회원정보 수정 성공");
		}else {
			map.put("msg", "회원정보 수정 실패");
		}

		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "selectAllMember", notes = "회원 조회")
	@GetMapping("/selectAllMember")
	private ResponseEntity<?> selectAllMember()
			throws Exception {
		Map<String , Object> map = new HashMap<String, Object>();
		List<MemberDto> members = memberService.selectAllMember();
		map.put("members", members);

		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
}