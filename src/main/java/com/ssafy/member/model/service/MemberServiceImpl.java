package com.ssafy.member.model.service;

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
	public MemberDto regist(MemberDto member) {
		System.out.println("service"+member);
		memberMapper.insertMember(member);
		return null;
	}

	@Override
	public MemberDto login(String id, String password) {
		MemberDto member = memberMapper.login(id);
		if (BCrypt.checkpw(password, member.getPassword())) {
			System.out.println("service"+member);
			return member;
		}
		else {
			return null;
		}
	}

	@Override
	public MemberDto update(MemberDto member) {
		int result = memberMapper.updateMember(member);
		if(result==1) {
			System.out.println("service"+member);
//			MemberDto updateMember = memberMapper.selectMember(member.getId()); //한번 더 찾아주기
//			return updateMember;
		}
		else {
			return null;
		}
		return null;
	}
	
	public MemberDto modify(MemberDto member) {
		int result = memberMapper.updateMember(member);
		if(result==1) {
			System.out.println("service"+member);
//			MemberDto updateMember = memberMapper.selectMember(member.getId()); //한번 더 찾아주기
//			return updateMember;
		}
		else {
			return null;
		}
		return null;
	}

	@Override
	public int delete(String id) {
		int result = memberMapper.deleteMember(id);
		return result;
	}

	@Override
	public MemberDto searchPass(String id, String email) {
		MemberDto member = memberMapper.searchPass(id, email);
		return member;
	}

	@Override
	public MemberDto myPage(String id) {
		log.debug("memberid : {}",id);
		
		return memberMapper.selectMember(id);
	}

}
