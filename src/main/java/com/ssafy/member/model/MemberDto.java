package com.ssafy.member.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

	private String id;
	private String name;
	private String password;
	private String birth;
	private String email;
	private String phone;
	private String joinDate;
	
}
