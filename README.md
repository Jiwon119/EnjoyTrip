# 04_EnjoyTrip_Back

## 요구사항
- **지역별 관광지 정보 수집** - 데이터베이스의 지역별 관광지 정보를 가져와 화면에 표시
- **관광지, 숙박, 음식점 조회** - 관광지 정보를 지역별 원하는 컨텐츠 별 조회.
- **문화시설, 공연, 여행코스, 쇼핑 조회** - 관광지 정보를 지역별 원하는 컨텐츠 별 조회
- **회원 관리** - 회원가입, 회원탈퇴, 정보수정
- **로그인 관리** - 로그인, 로그아웃, 비밀번호 찾기, 아이디 저장
- **게시글 관리** - 게시글 등록, 조회, 수정, 삭제
- **게시판 관리** - 게시글 목록, 검색

## swagger
![swagger](/uploads/c53d253b91df5cc020f3aef0ec881149/swagger.PNG)

✔ **Attraction Controller API**  
  
![Attraction_Controller](/uploads/ba7dabccb9abed45e874b188041f3c9c/Attraction_Controller.PNG)

- **/map/mapList**  :  지도의 전체 목록을 반환해 줍니다.
![image](/uploads/fafa2e4a619dc6c8a7815977a26b6b47/image.png)
![image](/uploads/0eb021ef178d44f77422e860448a234b/image.png)

- **/map/mapSearch**  :  지도의 검색 결과을 반환해 줍니다.
![image](/uploads/207e7d3a3f523aa1cb4d02f266299149/image.png)
![image](/uploads/9e2414d4b5f2fb228f2532bcab87079a/image.png)

✔ **Board Controller API**
![Board_Controller](/uploads/6dc1533b643adca0541f5edd2cb1aca7/Board_Controller.PNG)
- **/article/write**  :  게시글을 작성합니다.
![image](/uploads/74fa903f03cad687583c67e3bfcf5265/image.png)
![image](/uploads/35b910731177fdcf0eb4abd8d4eb5ec5/image.png)


✔ **Member Controller API**
![image](/uploads/b2c72ef2469166edab98b8a36b5b5e14/image.png)

✔ **Models**
![image](/uploads/438d36d3b5403a4fa276a2d4dd7ac528/image.png)
