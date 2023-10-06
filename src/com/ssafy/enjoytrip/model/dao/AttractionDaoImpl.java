package com.ssafy.enjoytrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {

	private static AttractionDao attractionDao = new AttractionDaoImpl();

	public static AttractionDao getAttractionDao() {
		return attractionDao;
	}

	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto, String title) {
		List<AttractionInfoDto> list = new ArrayList<AttractionInfoDto>();
		;
		// 구현
		// sido_code
		// content_type_id
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = null;
			String sql = "select * from attraction_info where title like ? ";
			System.out.println(attractionInfoDto.getSidoCode());
			if (attractionInfoDto.getSidoCode() == 0) {
				if (attractionInfoDto.getContentTypeId() == 0) {
					sql += "limit 0,20";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + title + "%");
				} else {
					sql += "and content_type_id = ? limit 0,20";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + title + "%");
					pstmt.setInt(2, attractionInfoDto.getContentTypeId());
				}

			} else {
				if (attractionInfoDto.getContentTypeId() == 0) {
					sql += "and sido_code = ? limit 0,20";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + title + "%");
					pstmt.setInt(2, attractionInfoDto.getSidoCode());
				} else {
					sql += "and sido_code = ? and content_type_id = ? limit 0,20";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + title + "%");
					pstmt.setInt(2, attractionInfoDto.getSidoCode());
					pstmt.setInt(3, attractionInfoDto.getContentTypeId());
				}
			}

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AttractionInfoDto aid = new AttractionInfoDto();
				aid.setContentId(rs.getInt("content_id"));
				aid.setContentTypeId(rs.getInt("content_type_id"));
				aid.setTitle(rs.getString("title"));
				aid.setAddr1(rs.getString("addr1"));
				aid.setAddr2(rs.getString("addr2"));
				aid.setZipcode(rs.getString("zipcode"));
				aid.setTel(rs.getString("tel"));
				aid.setFirstImage(rs.getString("first_image"));
				aid.setFirstImage2(rs.getString("first_image2"));
				aid.setReadcount(rs.getInt("readcount"));
				aid.setSidoCode(rs.getInt("sido_code"));
				aid.setGugunCode(rs.getInt("gugun_code"));
				aid.setLatitude(rs.getDouble("latitude"));
				aid.setLongitude(rs.getDouble("longitude"));
				aid.setMlevel(rs.getString("mlevel"));
				list.add(aid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
