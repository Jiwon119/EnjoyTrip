<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.attraction.model.AttractionInfoDto" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
	
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>지역별 관광지 정보 수집</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />

    <style>
      .wrap {
        position: absolute;
        left: 0;
        bottom: 40px;
        width: 288px;
        height: 132px;
        margin-left: -144px;
        text-align: left;
        overflow: hidden;
        font-size: 12px;
        font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
        line-height: 1.5;
      }
      .wrap * {
        padding: 0;
        margin: 0;
      }
      .wrap .info {
        width: 286px;
        height: 120px;
        border-radius: 5px;
        border-bottom: 2px solid #ccc;
        border-right: 1px solid #ccc;
        overflow: hidden;
        background: #fff;
      }
      .wrap .info:nth-child(1) {
        border: 0;
        box-shadow: 0px 1px 2px #888;
      }
      .info .title {
        padding: 5px 0 0 10px;
        height: 30px;
        background: #eee;
        border-bottom: 1px solid #ddd;
        font-size: 18px;
        font-weight: bold;
      }
      .info .close {
        position: absolute;
        top: 10px;
        right: 10px;
        color: #888;
        width: 17px;
        height: 17px;
        background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
      }
      .info .close:hover {
        cursor: pointer;
      }
      .info .body {
        position: relative;
        overflow: hidden;
      }
      .info .desc {
        position: relative;
        margin: 13px 0 0 90px;
        height: 75px;
      }
      .desc .ellipsis {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      }
      .desc .jibun {
        font-size: 11px;
        color: #888;
        margin-top: -2px;
      }
      .info .img {
        position: absolute;
        top: 6px;
        left: 5px;
        width: 73px;
        height: 71px;
        border: 1px solid #ddd;
        color: #888;
        overflow: hidden;
      }
      .info:after {
        content: '';
        position: absolute;
        margin-left: -12px;
        left: 50%;
        bottom: 0;
        width: 22px;
        height: 12px;
        background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png');
      }
      .info .link {
        color: #5085bb;
      }
    </style>
    <style>
      div {
        text-align: center;
      }
    </style>
	
	
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	
	<div>
      <h1>지역별 관광정보 검색 페이지</h1>
    </div>
    <!-- 중앙 content start -->
    <div class="container">
      <div class="col-md-12">
        <div class="alert alert-primary mt-3 text-center fw-bold" role="alert">전국 관광지 정보</div>
        <!-- 관광지 검색 start -->
        <form class="d-flex my-3" role="search" action="/map">
        	<input type="hidden" name="action" value="mapSearch">
          <select id="search-area" class="form-select me-2" name="area">
            <option value="0" selected>검색 할 지역 선택</option>
          </select>
          <select id="search-content-id" class="form-select me-2" name="type">
            <option value="0" selected>관광지 유형</option>
            <option value="12">관광지</option>
            <option value="14">문화시설</option>
            <option value="15">축제공연행사</option>
            <option value="25">여행코스</option>
            <option value="28">레포츠</option>
            <option value="32">숙박</option>
            <option value="38">쇼핑</option>
            <option value="39">음식점</option>
          </select>
          <input id="search-keyword" class="form-control me-2" type="search" placeholder="검색어" aria-label="검색어" name="keyword"/>
          <input id="btn-search" class="btn btn-outline-success" type="submit" />
        </form>
        <!-- kakao map start -->
        <div id="map" class="mt-3" style="width: 100%; height: 400px"></div>
        <!-- kakao map end -->
        <!-- 관광지 검색 end -->
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c8b44a255545fb3017be433bf23eeeb4&libraries=services,clusterer,drawing"></script>

    <!-- 마커 클러스터 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c8b44a255545fb3017be433bf23eeeb4&libraries=clusterer"></script>

    <script type="text/javascript">
      // index page 로딩 후 전국의 시도 설정
      let areaUrl =
        'https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=' +
        'In87czNDnBi2N43LS33XLI6CLL%2BQ69MxUWi54NUaLH0FJ3G4sgPaLmAMqZz2cTXc28J%2F%2BWGr7vpYN2KZPWeXcA%3D%3D' +
        '&numOfRows=50&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json';

      fetch(areaUrl, { method: 'GET' })
        .then((response) => response.json())
        .then((data) => makeOption(data))
        .then((data) => makeList(data));

      function makeOption(data) {
        let areas = data.response.body.items.item;
        let sel = document.getElementById('search-area');
        areas.forEach((area) => {
          let opt = document.createElement('option');
          opt.setAttribute('value', area.code);
          opt.appendChild(document.createTextNode(area.name));

          sel.appendChild(opt);
        });
      }

      // 검색 버튼을 누르면..
      // 지역, 유형, 검색어 얻기.
      // 받은 데이터를 이용하여 화면 구성.
       document.getElementById('btn-search').addEventListener('click', () => {
          makeList(result);
      });

 
      var positions = []; // marker 배열
      function makeList(data) {
        positions = [];
        for (var i = 0; i < markerArr.length; i++) {
          markerArr[i].setMap(null);
        }
        for (var i = 0; i < overlayArr.length; i++) {
          overlayArr[i].setMap(null);
        }

         <c:forEach items="${result}" var="item">
         	positions.push({title: "${item.title}", latlng: new kakao.maps.LatLng("${item.latitude}", "${item.longitude}"),
         		contenttypeid: "${item.contentTypeId}",
	            areaimg: "${item.firstImage}",
	            areaaddr: "${item.addr1}" });
         </c:forEach>
        displayMarker();
      }

      // 카카오지도
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
          level: 13 // 지도의 확대 레벨
        };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);

      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      var mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      // 마커 클러스터러를 생성합니다
      var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10 // 클러스터 할 최소 지도 레벨
      });

      var markerArr = [];
      function displayMarker() {
        clusterer.clear();
        markerArr = [];
        for (var i = 0; i < positions.length; i++) {
          var imageSrc;
          if (
            positions[i].contenttypeid == '12' ||
            positions[i].contenttypeid == '14' ||
            positions[i].contenttypeid == '15' ||
            positions[i].contenttypeid == '28' ||
            positions[i].contenttypeid == '32' ||
            positions[i].contenttypeid == '38' ||
            positions[i].contenttypeid == '39'
          ) {
            // imageSrc = `/img/marker_${positions[i].contenttypeid}.png`;
            switch (positions[i].contenttypeid) {
              case '12':
                imageSrc = 'https://blog.kakaocdn.net/dn/YJA3z/btstxnllXkt/yrm2jmqBJxj28SZdP5X4u0/img.png';
                break;
              case '14':
                imageSrc = 'https://blog.kakaocdn.net/dn/I9opY/btstqD4pZ8c/U0A1R4lkxGkkYEAEoK8eX0/img.png';
                break;
              case '15':
                imageSrc = 'https://blog.kakaocdn.net/dn/cYxNbc/btstxk94Aga/NUq7KDKmWHWDXuKuW8dJZ1/img.png';
                break;
              case '28':
                imageSrc = 'https://blog.kakaocdn.net/dn/chscVf/btstxidk0ak/KkYdeNWDpaKPZGuEHNDeak/img.png';
                break;
              case '32':
                imageSrc = 'https://blog.kakaocdn.net/dn/bv7IB6/btstq50EAbM/93ZNzkdNJgub24yldKfcAk/img.png';
                break;
              case '38':
                imageSrc = 'https://blog.kakaocdn.net/dn/bqijV2/btstrQ3r3N2/KxvFAcHNpVhV7tqS8mXiL0/img.png';
                break;
              case '39':
                imageSrc = 'https://blog.kakaocdn.net/dn/bANoeg/btstxPBZlcD/zK1tb1Lv5JDBgBtpqKuCb1/img.png';
                break;
            }
          } else {
            // 마커 이미지의 이미지 주소입니다
            imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';
          }

          // 마커 이미지의 이미지 크기 입니다
          var imageSize = new kakao.maps.Size(24, 35);

          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage // 마커 이미지
          });

          markerArr.push(marker);
          // 커스텀 오버레이에 표시할 컨텐츠 입니다
          // 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
          // 별도의 이벤트 메소드를 제공하지 않습니다
          
          var content =
            '<div class="wrap">' +
            '    <div class="info">' +
            '        <div class="title">' +
            `            <div class="close" onclick="closeOverlay()" title="닫기"></div>` +
            '        </div>' +
            '        <div class="body">' +
            '            <div class="img">' +
//            `                <img src="${positions[i].areaimg}" width="73" height="70">` +
            '                <img src=\"'+positions[i].areaimg +'\"width="73" height="70">' +
            '           </div>' +
            '            <div class="desc">' +
            '                <div class="ellipsis">'+ positions[i].title +'</div>' +
            '                <div class="jibun ellipsis">'+ positions[i].areaaddr +'</div>' +
            '                <div><a href=\"https://www.google.com/search?q='+ positions[i].title + '\" target=\"_blank\" class=\"link\">상세 페이지(Google)</a></div>' +
            '            </div>' +
            '        </div>' +
            '    </div>' +
            '</div>';

          // 이벤트 리스너로는 클로저를 만들어 등록합니다
          // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
          // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
          kakao.maps.event.addListener(marker, 'click', makeClickListener(map, content, marker.getPosition()));
        }

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markerArr);

        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
        map.setCenter(positions[0].latlng);
      }

      // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
      function closeOverlay() {
        if (overlayArr.length != 0) {
          for (var i = 0; i < overlayArr.length; i++) {
            overlayArr[i].setMap(null);
          }
          overlayArr = [];
        }
      }

      function moveCenter(lat, lng) {
        map.setCenter(new kakao.maps.LatLng(lat, lng));
      }

      var overlayArr = [];
      function makeClickListener(map, content, position) {
        return function () {
          closeOverlay();
          overlay = new kakao.maps.CustomOverlay({
            content: content,
            map: map,
            position: position,
            clickable: true
          });
          overlayArr.push(overlay);
          //클릭 시, 마커 위치로 최대한 Zoom-in
          var level = 4;
          map.setLevel(level, { anchor: position });
          map.setCenter(position);
          kakao.maps.event.preventMap();
          overlay.setMap(map);
        };
      }

      kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        if (overlayArr.length != 0) {
          closeOverlay();
        }
      });
    </script>
 
<%@ include file="/include/footer.jsp" %>