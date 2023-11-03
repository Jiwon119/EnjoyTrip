package com.ssafy.member.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ssafy.member.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(
		properties = {
			"spring.config.location=classpath:application.properties"
		},
		classes = {MemberControllerTest.class}
	)
@Slf4j
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.ssafy"})
class MemberControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private MemberService memberService;
	
	@Value("${userid}")
	private String userId;
	
	@Value("${userpwd}")
	private String userPwd;

	@Test
	void testMypage() throws Exception{
		log.debug("##### 회원 정보 얻기 테스트 #####");
		mockMvc.perform(get("/member/mypage/" + "ssafy"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.userPwd", is(userPwd)))
			.andDo(print());
		log.debug("##### 회원 목록 테스트 종료 #####");
	}

	@Test
	@Disabled
	void testLogout() {
		fail("Not yet implemented");
	}
	
	@Test
	@Disabled
	@DisplayName("##### 회원 정보 얻기 테스트 #####")
	void testUserInfo() throws Exception {
		log.debug("##### 회원 정보 얻기 테스트 #####");
		mockMvc.perform(get("/admin/user/" + userId))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.userPwd", is(userPwd)))
			.andDo(print());
		log.debug("##### 회원 목록 테스트 종료 #####");
	}

}
