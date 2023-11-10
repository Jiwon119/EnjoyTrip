package com.ssafy.board.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {

	private int articleNo;
	private int commentNo;
	private int parentCommentNo;
	private String content;
	private String writer;
	private String createDate;

}
