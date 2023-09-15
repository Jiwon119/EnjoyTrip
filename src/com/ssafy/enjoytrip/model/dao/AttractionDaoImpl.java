package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.service.AttractionServiceImpl;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {

	private static AttractionDaoImpl instance = new AttractionDaoImpl();

	private AttractionDaoImpl() {
	}

	public static AttractionDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		DBUtil instance = DBUtil.getInstance();
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = instance.getConnection();
			System.out.println("DB 연결 성공");

			String sql = "select * from attraction_info";

			boolean ck = false;
			if (attractionInfoDto.getContentTypeId() != 0) {
				sql += " where content_type_id = " + attractionInfoDto.getContentTypeId();
				ck = true;
			}
			if (attractionInfoDto.getSidoCode() != 0) {
				if (ck) {
					sql += " and sido_code = " + attractionInfoDto.getSidoCode();
				} else {
					sql += " where sido_code = " + attractionInfoDto.getSidoCode();
				}
			}

			pstmt = conn.prepareStatement(sql);
			System.out.println("select 성공");
			System.out.println(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AttractionInfoDto att = new AttractionInfoDto();
				att.setContentId(rs.getInt("content_id"));
				att.setContentTypeId(rs.getInt("content_type_id"));
				att.setTitle(rs.getString("title"));
				att.setAddr1(rs.getString("addr1"));
				att.setAddr2(rs.getString("addr2"));
				att.setZipcode(rs.getString("zipcode"));
				att.setTel(rs.getString("tel"));
				att.setFirstImage(rs.getString("first_image"));
				att.setFirstImage2(rs.getString("first_image2"));
				att.setReadcount(rs.getInt("readcount"));
				att.setSidoCode(rs.getInt("sido_code"));
				att.setGugunCode(rs.getInt("gugun_code"));
				att.setLatitude(rs.getDouble("latitude"));
				att.setLongitude(rs.getDouble("longitude"));
				att.setMlevel(rs.getString("mlevel"));

				list.add(att);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		DBUtil instance = DBUtil.getInstance();
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = instance.getConnection();
			System.out.println("DB 연결 성공");

			String sql = "select * from attraction_info where title like '%" + title + "%'";

			if (sidoCode != 0) {
				sql += " and sido_code = " + sidoCode;
			}

			pstmt = conn.prepareStatement(sql);
			System.out.println("select 성공");
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AttractionInfoDto att = new AttractionInfoDto();
				att.setContentId(rs.getInt("content_id"));
				att.setContentTypeId(rs.getInt("content_type_id"));
				att.setTitle(rs.getString("title"));
				att.setAddr1(rs.getString("addr1"));
				att.setAddr2(rs.getString("addr2"));
				att.setZipcode(rs.getString("zipcode"));
				att.setTel(rs.getString("tel"));
				att.setFirstImage(rs.getString("first_image"));
				att.setFirstImage2(rs.getString("first_image2"));
				att.setReadcount(rs.getInt("readcount"));
				att.setSidoCode(rs.getInt("sido_code"));
				att.setGugunCode(rs.getInt("gugun_code"));
				att.setLatitude(rs.getDouble("latitude"));
				att.setLongitude(rs.getDouble("longitude"));
				att.setMlevel(rs.getString("mlevel"));

				list.add(att);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
