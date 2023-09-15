package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	static private MemberDaoImpl instance = new MemberDaoImpl();

	private MemberDaoImpl() {
	}

	static public MemberDaoImpl getMemberDao() {
		return instance;
	}

	@Override
	public boolean registerMember(MemberDto memberDto) {
		DBUtil instance = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(
					"insert into user " + "(user_id, user_password, user_email, user_name, user_birth, user_phone)"
							+ "values (?, ?, ?, ?, ?, ?);");

			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserPass());
			pstmt.setString(3, memberDto.getUserEmail());
			pstmt.setString(4, memberDto.getUserName());
			pstmt.setString(5, memberDto.getUserBirth());
			pstmt.setString(6, memberDto.getUserPhone());

			if (pstmt.executeUpdate() == 0) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(conn, pstmt);
		}
		return true;
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		MemberDto memberDto = findMember(userId);
		if (memberDto == null)
			return null;
		if (!userPass.equals(memberDto.getUserPass()))
			return null;

		return memberDto;
	}

	@Override
	public boolean modifyMember(MemberDto memberDto) {
		DBUtil instance = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement("update user set " + "user_password = ?, " + "user_email = ?, "
					+ "user_name = ?, " + "user_birth = ?, " + "user_phone = ? " + "where user_id = ?;");
			pstmt.setString(1, memberDto.getUserPass());
			pstmt.setString(2, memberDto.getUserEmail());
			pstmt.setString(3, memberDto.getUserName());
			pstmt.setString(4, memberDto.getUserBirth());
			pstmt.setString(5, memberDto.getUserPhone());
			pstmt.setString(6, memberDto.getUserId());
			if (pstmt.executeUpdate() == 0) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(conn, pstmt);
		}

		return true;
	}

	@Override
	public boolean deleteMember(String userId) {
		DBUtil instance = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = instance.getConnection();
			pstmt = conn.prepareStatement("delete from user where user_id = ?;");
			pstmt.setString(1, userId);
			if (pstmt.executeUpdate() == 0) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(conn, pstmt);
		}
		return true;
	}

	public MemberDto findMember(String userId) {
		DBUtil instance = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement("select * from user where user_id = ?;");
			pstmt.setString(1, userId);

			ResultSet rs = pstmt.executeQuery();

			MemberDto memberDto = new MemberDto();

			if (rs.next()) {
				memberDto.setUserId(rs.getString(1));
				memberDto.setUserPass(rs.getString(2));
				memberDto.setUserEmail(rs.getString(3));
				memberDto.setUserName(rs.getString(4));
				memberDto.setUserBirth(rs.getString(5));
				memberDto.setUserPhone(rs.getString(6));
				memberDto.setJoinDate(rs.getString(7));
			} else
				return null;

			return memberDto;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(conn, pstmt);
		}
		return null;
	}

}
