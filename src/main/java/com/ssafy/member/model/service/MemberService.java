package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public interface MemberService {
	// 회원가입 로그인 수정 삭제 비밀번호찾기 마이페이지조회
	
	
	MemberDto regist(MemberDto member);
	
	MemberDto login(String id, String password);
	
	MemberDto update(MemberDto member);
	
	int delete(String id);
	
	MemberDto searchPass(String id, String email);
	
	MemberDto myPage(String id);
	
}
