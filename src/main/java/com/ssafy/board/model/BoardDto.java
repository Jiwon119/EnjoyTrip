package com.ssafy.board.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "BoardDto (게시판 정보)")
public class BoardDto {

	@ApiModelProperty(value = "게시글 번호", example = "0")
	private int articleNo;
	
	@ApiModelProperty(value = "게시글 유저")
	private String userId;
	
	@ApiModelProperty(value = "게시글 제목")
	private String subject;
	
	@ApiModelProperty(value = "게시글 내용")
	private String content;
	
	@ApiModelProperty(value = "조회수", example = "0")
	private int hit;
	
	@ApiModelProperty(value = "등록 시간")
	private String registerTime;

}
