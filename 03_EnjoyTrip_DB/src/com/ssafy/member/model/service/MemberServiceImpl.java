package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	static public MemberService instance = new MemberServiceImpl();

	private MemberServiceImpl() {
	}

	public static MemberService getMemberService() {
		return instance;
	}

	@Override
	public boolean registerMember(MemberDto memberDto) {
		MemberDto member = MemberDaoImpl.getMemberDao().findMember(memberDto.getUserId());
		if (member == null) {
			return MemberDaoImpl.getMemberDao().registerMember(memberDto);
		}
		return false;

	}

	@Override
	public MemberDto login(String userId, String userPass) {
		return MemberDaoImpl.getMemberDao().login(userId, userPass);
	}

	@Override
	public boolean modifyMember(MemberDto memberDto) {
		return MemberDaoImpl.getMemberDao().modifyMember(memberDto);
	}

	@Override
	public boolean deleteMember(String userId) {
		return MemberDaoImpl.getMemberDao().deleteMember(userId);
	}

}
