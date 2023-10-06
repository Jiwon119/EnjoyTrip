package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao{

	private static MemberDao memberDao = new MemberDaoImpl();

	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	private DBUtil dbUtil;
	
	MemberDaoImpl(){
		dbUtil = DBUtil.getInstance();
	}
	
	@Override
	public int registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = dbUtil.getConnection();
			String sql = "insert into member(user_id,user_name,user_password,user_email) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
			pstmt.setString(4, memberDto.getUserEmail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return res;
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = new MemberDto();
		try {
			conn = dbUtil.getConnection();
			String sql = "select * from member where user_id = ? and user_password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto.setUserId(rs.getString("user_id"));
				memberDto.setUserName(rs.getString("user_name"));
				memberDto.setUserPass(rs.getString("user_password"));
				memberDto.setUserEmail(rs.getString("user_email"));
			}else {
				return null;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return memberDto;
	}

	@Override
	public MemberDto modifyMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = dbUtil.getConnection();
			String sql = "update member set user_name = ?,user_password = ?, user_email = ? where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserName());
			pstmt.setString(2, memberDto.getUserPass());
			pstmt.setString(3, memberDto.getUserEmail());
			pstmt.setString(4, memberDto.getUserId());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		if(res != 0) {
			return selectMember(memberDto.getUserId());
		}else {
			return null;
		}
	}

	@Override
	public int deleteMember(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = dbUtil.getConnection();
			String sql = "delete from member where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return res;
	}
	
	private MemberDto selectMember(String userId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = new MemberDto();
		
		try {
			conn = dbUtil.getConnection();
			String sql = "select * from member where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto.setUserId(rs.getString("user_id"));
				memberDto.setUserName(rs.getString("user_name"));
				memberDto.setUserPass(rs.getString("user_password"));
				memberDto.setUserEmail(rs.getString("user_email"));
			}else {
				return null;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return memberDto;
	}

}
