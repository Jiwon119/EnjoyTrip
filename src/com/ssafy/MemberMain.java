package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberServiceImpl;

public class MemberMain {

	private BufferedReader in;

	public MemberMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 회원 메뉴 ----------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerMember();
					break;
				case 2:
					login();
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					deleteMember();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void registerMember() throws IOException {
		MemberDto memberDto = new MemberDto();

		System.out.print("아이디: ");
		memberDto.setUserId(in.readLine());
		System.out.print("비밀번호: ");
		memberDto.setUserPass(in.readLine());
		System.out.print("이메일: ");
		memberDto.setUserEmail(in.readLine());
		System.out.print("이름: ");
		memberDto.setUserName(in.readLine());
		System.out.print("생년월일(YYYY-MM-DD): ");
		memberDto.setUserBirth(in.readLine());
		System.out.print("전화번호(-생략): ");
		memberDto.setUserPhone(in.readLine());
		// 빈 값 들어올 때 생각

		boolean result = MemberServiceImpl.getMemberService().registerMember(memberDto);
		if (result)
			System.out.println("회원가입 성공!!");
		else
			System.out.println("회원가입 실패!!");
	}

	private void login() throws IOException {

		System.out.print("아이디: ");
		String userId = in.readLine();
		System.out.print("비밀번호: ");
		String userPass = in.readLine();

		MemberDto member = MemberServiceImpl.getMemberService().login(userId, userPass);
		if (member == null)
			System.out.println("로그인 실패!!");
		else
			System.out.println(member);
	}

	private void modifyMember() throws IOException {
		MemberDto memberDto = new MemberDto();

		System.out.print("수정할 유저 아이디: ");
		memberDto.setUserId(in.readLine());
		System.out.print("비밀번호: ");
		memberDto.setUserPass(in.readLine());
		System.out.print("이메일: ");
		memberDto.setUserEmail(in.readLine());
		System.out.print("이름: ");
		memberDto.setUserName(in.readLine());
		System.out.print("생년월일(YYYY-MM-DD): ");
		memberDto.setUserBirth(in.readLine());
		System.out.print("전화번호(-생략): ");
		memberDto.setUserPhone(in.readLine());
		// 빈 값 들어올 때 생각

		boolean result = MemberServiceImpl.getMemberService().modifyMember(memberDto);

		if (result)
			System.out.println("수정 성공!!");
		else
			System.out.println("수정 실패!!");

	}

	private void deleteMember() throws IOException {
		System.out.print("삭제할 유저 아이디: ");
		String userId = in.readLine();

		boolean result = MemberServiceImpl.getMemberService().deleteMember(userId);

		if (result)
			System.out.println("삭제 성공!!");
		else
			System.out.println("삭제 실패!!");
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
