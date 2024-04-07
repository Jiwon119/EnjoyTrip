package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	int registerMember(MemberDto memberDto);

	MemberDto login(String userId, String userPass);

	MemberDto modifyMember(MemberDto memberDto);

	int deleteMember(String userId);

}
