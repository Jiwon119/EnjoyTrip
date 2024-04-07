package com.ssafy.member.model.service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;
import com.ssafy.member.model.dao.MemberDaoImpl;
import com.ssafy.util.EncryptUtil;

public class MemberServiceImpl implements MemberService{
	
	private static MemberService memberService = new MemberServiceImpl();
	
	public static MemberService getMemberService() {
		return memberService;
	}

	private MemberDao memberDao = MemberDaoImpl.getMemberDao();
	private EncryptUtil encryptUtil = EncryptUtil.getInstance();
	
	@Override
	public int registerMember(MemberDto memberDto) {
		memberDto.setSalt(encryptUtil.createSalt());
		memberDto.setUserPass(encryptUtil.getEncrypt(memberDto.getUserPass(), memberDto.getSalt()));
		return memberDao.registerMember(memberDto);
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		MemberDto memberDto = memberDao.login(userId, userPass);
		String inputPwd = encryptUtil.getEncrypt(userPass, memberDto.getSalt());
		if(memberDto.getUserPass().equals(inputPwd)) {
			return memberDto;
		}else {
			return null;
		}
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
