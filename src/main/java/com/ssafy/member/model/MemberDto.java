package com.ssafy.member.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "MemberDto (회원 정보)")
public class MemberDto {

	@ApiModelProperty(value = "아이디")
	private String id;
	
	@ApiModelProperty(value = "이름")
	private String name;
	
	@ApiModelProperty(value = "비밀번호")
	private String password;
	
	@ApiModelProperty(value = "생년월일")
	private String birth;
	
	@ApiModelProperty(value = "이메일")
	private String email;
	
	@ApiModelProperty(value = "번호")
	private String phone;
	
	@ApiModelProperty(value = "가입일")
	private String joinDate;
	
}
