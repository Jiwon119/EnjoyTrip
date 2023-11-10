package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.CommentDto;
import com.ssafy.board.model.FileInfoDto;

@Mapper
public interface BoardMapper {

	void writeArticle(BoardDto boardDto) throws SQLException;

	List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;
	
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	
	BoardDto getArticle(int articleNo) throws SQLException;
	
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(BoardDto boardDto) throws SQLException;
	
	void deleteArticle(int articleNo) throws SQLException;
	
	
	// 파일 관련 mapper
	void registerFile(BoardDto boardDto) throws Exception;
	
	void deleteFile(int articleNo) throws Exception;
	
	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;
	
	// 댓글 관련 Mapper
	void writeComment(CommentDto commentDto) throws Exception;
	
	List<CommentDto> getComment(int articleNo) throws Exception;
}
