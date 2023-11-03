package com.ssafy.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;

@Mapper
public interface MemberMapper {
	//로그인 회원가입 비밀번호찾기 마이페이지수정,조회,삭제
	
	public int insertMember(MemberDto member);	//멤버추가1
	
	public MemberDto selectMember(String id);	//멤버선택1
	
	public int updateMember(MemberDto member);	//정보수정1
	
	public int modifyMember(MemberDto member);	//정보수정2
	
	public int deleteMember(String id);			//멤버탈퇴1	
	
	public MemberDto searchPass(String id, String eamil);		//패스워드찾기1	

	public MemberDto login(String id);			//로그인1
	
}
