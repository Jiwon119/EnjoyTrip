package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao{
	private static BoardDao boardDao = new BoardDaoImpl();

	private BoardDaoImpl() {}

	public static BoardDao getBoardDao() {
		return boardDao;
	}

	@Override
	public void registerArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// boardDto의 내용을 board table에 insert
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "insert into board(subject,content,user_id) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setString(3, boardDto.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		// board table의 모든 글정보를 글번호순으로 정렬하여 list에 담고 return
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			String sql = "select * from board";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				list.add(boardDto);
			};

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		// board table에서 제목에 subject를 포함하고 있는 글정보를 list에 담고 return
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			String sql = "select * from board where subject like ? order by article_no limit 0, 20";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+subject+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				list.add(boardDto);
			};

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto viewArticle(int no) {
		BoardDto boardDto = null;
		// board table에서 글번호가 no인 글 한개를 return
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			String sql = "select * from board where article_no = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// boardDto의 내용을 이용하여 글번호에 해당하는 글제목과 내용을 수정
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "update board set subject = ?,content = ? where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// board table에서 글번호가 no인 글 정보를 삭제
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "delete from board where article_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
