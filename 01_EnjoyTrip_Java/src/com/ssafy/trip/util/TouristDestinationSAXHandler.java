package com.ssafy.trip.util;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.trip.model.dto.TripDto;

/**
 * 전국관광지정보표준데이터.xml 파일에서 관광지 정보를 읽어 파싱하는 핸들러 클래스
 */
public class TouristDestinationSAXHandler extends DefaultHandler {

	/**
	 * 관광지 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 현재 버전에서는 0번부터 순차 부여한다.
	 */
	private int num;
	/** 관광지 정보를 담는다 */
	private List<TripDto> trips;
	/** 파싱힌 관광지 정보 */
	private TripDto tripDto;
	/** 태그 바디 정보를 임시로 저장 */
	private String temp;

	public TouristDestinationSAXHandler() {
		trips = new ArrayList<TripDto>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes att) {
		temp = "";
		if (qName.equals("record")) {
			// complete code #04
			// tripDto 객체를 생성(이미지 정보 세팅)하고 trips List에 추가하세요.
			tripDto = new TripDto(num++);

			trips.add(tripDto);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("관광지명")) {
			imgSetting(temp);
			tripDto.setTouristDestination(temp);
		} else if (qName.equals("소재지도로명주소")) {
			tripDto.setStreetAddress(temp);
		} else if (qName.equals("소재지지번주소")) {
			tripDto.setLotAddress(temp);
		} else if (qName.equals("위도")) {
			if (temp.length() != 0)
				tripDto.setLat(Double.parseDouble(temp));
		} else if (qName.equals("경도")) {
			if (temp.length() != 0)
				tripDto.setLng(Double.parseDouble(temp));
		} else if (qName.equals("관광지소개")) {
			tripDto.setInfo(temp);
		} else if (qName.equals("관리기관전화번호")) {
			tripDto.setTel(temp);
		}
	}
	
	public void imgSetting(String dest) {
		String[] imgList = {
				"image01.jpg", "image02.jpg", "image03.jpg", "image04.jpg",
				"image05.jpg", "image06.jpg", "image07.jpg", "image08.jpg",
				"image09.jpg", "image10.jpg", "image11.jpg"
		};

		switch(dest) {
		case("만리포 관광지"):
			tripDto.setImg(imgList[0]);
			break;
		case("심우장"):
			tripDto.setImg(imgList[1]);
			break;
		case("길상사"):
			tripDto.setImg(imgList[2]);
			break;
		case("한국가구박물관"):
			tripDto.setImg(imgList[3]);
			break;
		case("반월호수"):
			tripDto.setImg(imgList[4]);
			break;
		case("초막골 생태공원"):
			tripDto.setImg(imgList[5]);
			break;
		case("수리산 도립공원"):
			tripDto.setImg(imgList[6]);
			break;
		case("수리산 산림욕장"):
			tripDto.setImg(imgList[7]);
			break;
		case("철쭉동산"):
			tripDto.setImg(imgList[8]);
			break;
		case("목포근대역사관 1관 (구, 일본영사관)"):
			tripDto.setImg(imgList[9]);
			break;
		case("주문진해변관광지"):
			tripDto.setImg(imgList[10]);
			break;
		default:
			int num = (int) (Math.random()*10)+1;
			tripDto.setImg(imgList[num]);
			break;
			
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		temp = new String(ch, start, length);
	}

	public List<TripDto> getTrips() {
		return trips;
	}

}
