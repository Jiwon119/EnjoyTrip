package com.ssafy.member.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

	private String id;
	private String password;
	private int age;
	private String email;
	private String address;
	private String joinDate;
	
}
