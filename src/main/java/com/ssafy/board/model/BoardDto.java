package com.ssafy.board.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto {

	@JsonProperty("article_no")
	private int articleNo;
	
	@JsonProperty("user_id")
	private String userId;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("content")
	private String content;
	
	@JsonProperty("hit")
	private int hit;
	
	@JsonProperty("register_time")
	private String registerTime;

}
