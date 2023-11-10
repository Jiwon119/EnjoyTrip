package com.ssafy.enjoyTrip;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
		}
	)
@Slf4j
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.ssafy"})
class ApplicationTests {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private MemberService memberService;
	
	@Value("${userid}")
	private String userId;
	
	@Value("${userpwd}")
	private String userPwd;

	@Test
	@DisplayName("### 프로퍼티 읽기 테스트 ###")
	void contextLoads() {
		log.debug("##### 회원 목록 테스트 시작 #####");
	}
}
