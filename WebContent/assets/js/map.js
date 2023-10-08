	  var markers = [];
      let areaUrl =
        "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
        serviceKey +
        "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

      fetch(areaUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption(data));

      function makeOption(data) {
    	  console.log(data);
        let areas = data.response.body.items.item;
        // console.log(areas);
        let sel = document.getElementById("search-area");
        areas.forEach((area) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", area.code);
          opt.appendChild(document.createTextNode(area.name));

          sel.appendChild(opt);
        });
      }

      // 검색 버튼을 누르면..
      // 지역, 유형, 검색어 얻기.
      // 위 데이터를 가지고 공공데이터에 요청.
      // 받은 데이터를 이용하여 화면 구성.
      document.getElementById("btn-search").addEventListener("click", () => {
    	// 기존 마커 제거
        let baseUrl = root + "/tripinfo?act=list";

        let queryString = ``;
        let areaCode = document.getElementById("search-area").value;
        let contentTypeId = document.getElementById("search-content-id").value;
        let keyword = document.getElementById("search-keyword").value;

        if (parseInt(areaCode)) queryString += `&search-area=${areaCode}`;
        if (parseInt(contentTypeId)) queryString += `&search-content-id=${contentTypeId}`;
        // if (!keyword) {
        // alert("검색어 입력 필수!!!");
        // return;
        // } else searchUrl += `&keyword=${keyword}`;
        let service = ``;
        if (keyword) {
          queryString += `&search-keyword=${keyword}`;
        } 
        let searchUrl = baseUrl + queryString;
        
        console.log(searchUrl);

        fetch(searchUrl)
          .then((response) => response.json())
          .then((data) => makeList(data));
      });

      var positions; // marker 배열.
      function makeList(data) {
        document.querySelector("table").setAttribute("style", "display: ;");
        let trips = data; // 여기 수정
        let tripList = ``;
        positions = [];
        trips.forEach((area) => {
          tripList += `
                    <tr onclick="moveCenter(${area.mapy}, ${area.mapx});">
                    <td><img src="${area.firstimage}" width="100px"></td>
                    <td>${area.title}</td>
                    <td>${area.addr1} ${area.addr2}</td>
                    <td>${area.mapy}</td>
                    <td>${area.mapx}</td>
                    </tr>
                `;

          let markerInfo = {
            title: area.title,
            latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
          };
          positions.push(markerInfo);
        });
        document.getElementById("trip-list").innerHTML = tripList;
        displayMarker();
      }

      // 카카오지도
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
          level: 5, // 지도의 확대 레벨
        };

      // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);

      function displayMarker() {
    	removeMarker();
        // 마커 이미지의 이미지 주소입니다
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        for (var i = 0; i < positions.length; i++) {
          // 마커 이미지의 이미지 크기 입니다
          var imageSize = new kakao.maps.Size(24, 35);

          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
          });
          markers.push(marker);
        }

        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
        map.setCenter(positions[0].latlng);
      }

      function moveCenter(lat, lng) {
        map.setCenter(new kakao.maps.LatLng(lat, lng));
      }
      
      // 기존 마커 제거
      function removeMarker() {
    	    for ( var i = 0; i < markers.length; i++ ) {
    	        markers[i].setMap(null);
    	    }   
    	    markers = [];
    	}
      
      
      function sortTable(sortValue){
    	// 기존 마커 제거
          let baseUrl = root + "/tripinfo?act=list";

          let queryString = ``;
          let areaCode = document.getElementById("search-area").value;
          let contentTypeId = document.getElementById("search-content-id").value;
          let keyword = document.getElementById("search-keyword").value;

          if (parseInt(areaCode)) queryString += `&search-area=${areaCode}`;
          if (parseInt(contentTypeId)) queryString += `&search-content-id=${contentTypeId}`;

          let service = ``;
          if (keyword) {
            queryString += `&search-keyword=${keyword}`;
          } 
          queryString += `&sort=${sortValue}`;
          let searchUrl = baseUrl + queryString;
          
          console.log(searchUrl);

          fetch(searchUrl)
            .then((response) => response.json())
            .then((data) => makeList(data));
      }
