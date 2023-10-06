package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService{
	
	private static MemberService memberService = new MemberServiceImpl();
	
	public static MemberService getMemberService() {
		return memberService;
	}

	private MemberDao memberDao = MemberDaoImpl.getMemberDao();
	
	@Override
	public int registerMember(MemberDto memberDto) {
		return memberDao.registerMember(memberDto);
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		return memberDao.login(userId, userPass);
	}

	@Override
	public MemberDto modifyMember(MemberDto memberDto) {
		return memberDao.modifyMember(memberDto);
	}

	@Override
	public int deleteMember(String userId) {
		return memberDao.deleteMember(userId);
	}

}
