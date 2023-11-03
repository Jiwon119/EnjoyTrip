package com.ssafy.member.model.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(
		properties = {
			"spring.config.location=classpath:application.properties"
		},
		classes = {MemberServiceImplTest.class}
	)
@Slf4j
@ComponentScan(basePackages = {"com.ssafy"})
class MemberServiceImplTest {
	
	@Autowired
	private MemberService memberService;
//
//	@Test
//	void testRegist() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLogin() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testModify() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchPass() {
//		fail("Not yet implemented");
//	}

	@Test
	void testMyPage() {
		log.debug("##### 회원 정보 얻기 테스트 #####");
		
		MemberDto member = memberService.selectMember("jw");
		
		log.debug("member : {}", member);
		log.debug("##### 회원 목록 테스트 종료 #####");
	}

}
