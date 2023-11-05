package com.ssafy.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;

@Mapper
public interface MemberMapper {
	//로그인 회원가입 비밀번호찾기 마이페이지수정,조회,삭제
	
	public MemberDto regist(MemberDto member);
	public MemberDto login(String id, String password);
	public MemberDto selectMember(String id);
	public MemberDto updateMember(MemberDto member);
	public MemberDto deleteMember(String id);
	
	
	public MemberDto searchPass(String id, String eamil);		//패스워드찾기1	

	
	
}
