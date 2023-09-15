package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao instance = new BoardDaoImpl();

	private BoardDaoImpl() {
	}

	public static BoardDao getInstance() {
		return instance;
	}

	@Override
	public void registerArticle(BoardDto boardDto) {
		DBUtil instance = DBUtil.getInstance();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = instance.getConnection();
			String sql = "insert into board (subject, content, user_id) values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setString(3, boardDto.getUserId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(conn, pstmt);
		}

	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBUtil instance = DBUtil.getInstance();
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement("select * from board order by register_time desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto tmp = new BoardDto();
				tmp.setArticleNo(rs.getInt("article_no"));
				tmp.setSubject(rs.getString("subject"));
				tmp.setContent(rs.getString("content"));
				tmp.setUserId(rs.getString("user_id"));
				tmp.setRegisterTime(rs.getString("register_time"));
				list.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBUtil instance = DBUtil.getInstance();
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement("select * from board where subject ='" + subject + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto tmp = new BoardDto();
				tmp.setArticleNo(rs.getInt("article_no"));
				tmp.setSubject(rs.getString("subject"));
				tmp.setContent(rs.getString("content"));
				tmp.setUserId(rs.getString("user_id"));
				tmp.setRegisterTime(rs.getString("register_time"));
				list.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public BoardDto viewArticle(int no) {
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DBUtil instance = DBUtil.getInstance();
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement("select * from board where article_no='" + no + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto tmp = new BoardDto();
				tmp.setArticleNo(rs.getInt("article_no"));
				tmp.setSubject(rs.getString("subject"));
				tmp.setContent(rs.getString("content"));
				tmp.setUserId(rs.getString("user_id"));
				tmp.setRegisterTime(rs.getString("register_time"));
				boardDto = tmp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(rs, pstmt, conn);
		}

		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		DBUtil instance = DBUtil.getInstance();
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement("update board set subject=?, content=? where article_no=?");
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(pstmt, conn);
		}
	}

	@Override
	public void deleteArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		DBUtil instance = DBUtil.getInstance();
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement("delete from board where article_no=?");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(pstmt, conn);
		}
	}

}
