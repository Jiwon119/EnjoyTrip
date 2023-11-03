package com.ssafy.attraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
 	
import com.ssafy.attraction.model.AttractionInfoDto;
import com.ssafy.attraction.model.service.AttractionService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(
		properties = {
			"spring.config.location=classpath:application.properties"
		}
	)

@Slf4j
@ComponentScan(basePackages = {"com.ssafy"})
public class AttractionServiceTest {
	@Autowired
	private AttractionService attractionService;
	
	@Test
	@DisplayName("##### 지도 Attraction 목록 #####")
	void mapLoads() {
		log.debug("##### 지도 Attraction 목록 시작 #####");
		AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
		List<AttractionInfoDto> list = attractionService.attractionList(attractionInfoDto, "강남");
		System.out.println(list.size());
		assertEquals(100, list.size());
	}
}
