package com.ssafy.attraction.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 디폴트 생성자 생성
public class GugunDto {

	private int gugunCode;
	private String gugunName;
	private int sidoCode;
	
}
