package com.ssafy.member.model.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ssafy.member.model.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

import com.ssafy.member.model.mapper.MemberMapper;
import com.ssafy.member.model.MemberDto;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public int regist(MemberDto member) {
		return memberMapper.regist(member);
	}

	@Override
	public MemberDto login(String id, String password) {
		return memberMapper.login(id, password);
	}

	@Override
	public MemberDto selectMember(String id) {
		return memberMapper.selectMember(id, null, null);
	}
	
	@Override
	public int updateMember(MemberDto member) {
		return memberMapper.updateMember(member);
	}
	

	@Override
	public int deleteMember(String id) {
		return memberMapper.deleteMember(id);
	}

	@Override
	public MemberDto searchPass(String id, String email, String name) {
		return memberMapper.selectMember(id, email, name);
	}

	@Override
	public List<MemberDto> selectAllMember() {
		return memberMapper.selectAllMember();
	}



}
