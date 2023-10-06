package com.ssafy.member.model.dao;

import com.ssafy.member.model.MemberDto;

public interface MemberDao {

	int registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	MemberDto modifyMember(MemberDto memberDto);

	int deleteMember(String userId);
	
}
