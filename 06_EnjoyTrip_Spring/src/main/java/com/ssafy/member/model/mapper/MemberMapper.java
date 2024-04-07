package com.ssafy.member.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;

@Mapper
public interface MemberMapper {
	
	public int regist(MemberDto member);
	public MemberDto login(String id, String password);
	public MemberDto selectMember(String id, String eamil, String name);
	public List<MemberDto> selectAllMember();
	public int updateMember(MemberDto member);
	public int deleteMember(String id);
	

//	public MemberDto searchPass(String id, String eamil, String name);
	
	
	
}
