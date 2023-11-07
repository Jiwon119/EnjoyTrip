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
  
---

✔ **Board Controller API**
  
![Board_Controller](/uploads/6dc1533b643adca0541f5edd2cb1aca7/Board_Controller.PNG)
  
- **/article/list**  :  게시글 목록을 반환해줍니다.
![image](/uploads/933a814a45359bae8bbe1f2f03d23bb7/image.png)
![image](/uploads/9b4542477d54cda645c29909fba26bf6/image.png)
  
- **/article/write**  :  게시글을 작성합니다.
![image](/uploads/74fa903f03cad687583c67e3bfcf5265/image.png)
![image](/uploads/35b910731177fdcf0eb4abd8d4eb5ec5/image.png)
![image](/uploads/4dfd898dd9e06960dfbbb36583001424/image.png)
  
- **/article/modify**  :  게시글을 수정합니다.
![image](/uploads/2dc5e2baaa99808a873921a37f24fd96/image.png)
![image](/uploads/c090340cc269f6e6d94a3cac584cb843/image.png)
![image](/uploads/bed83c4bbfe8d7289030a3bb0f1ee687/image.png)
  
- **/article/remove/{articleNo}**  :  게시글을 삭제합니다.
![image](/uploads/946fc5b0669aba3cb6672102be03e225/image.png)
![image](/uploads/4886dc1e63f97a46ce950ebb1927e854/image.png)
![image](/uploads/489e950c50d82f9c57430a32783512c1/image.png)
  
- **/article/view/{articleNo}}**  :  게시글을 번호로 검색한 결과를 반환해줍니다.
![image](/uploads/1a620ffa72cce1b44eaa82c3f023d39a/image.png)
![image](/uploads/c153b051aff874d8406defb0f691abc0/image.png)
  
- **/article/write**  :  게시글을 작성합니다.
![image](/uploads/f58960a8ecfbf17267b0c819b52f48a4/image.png)
![image](/uploads/68e81bcc1fcd3b2b0320fa3d23a0867d/image.png)
![image](/uploads/d3c98283f2023edcd9937c9113ebb19c/image.png)

---

✔ **Member Controller API**
![image](/uploads/b2c72ef2469166edab98b8a36b5b5e14/image.png)

- **/member/delete/{userId}**  :  회원탈퇴
![image](/uploads/a64dedfb913af7a55381814948769a83/image.png)
![image](/uploads/c488267c326cb55e223e17e8d766075a/image.png)

- **/member/login**  :  로그인
![image](/uploads/4fb87a9a3123bc5b125b9ef7d1af2c2e/image.png)
![image](/uploads/8d1c62bd679d6cc85a2b73ac195ba240/image.png)

- **/member/logout**  :  로그아웃
![image](/uploads/6b6118ddfea54210f1ff805038ac2daf/image.png)
![image](/uploads/78f78e7a3341c9fdd4e9d1ba2d84ffb3/image.png)

- **/member/mypage/{userId}**  :  유저 정보 페이지
![image](/uploads/e584b5c59ae4471afceb9364978be7ac/image.png)
![image](/uploads/42ec581203c13404cf64f1c1373c65cc/image.png)

- **/member/regist**  :  회원가입
![image](/uploads/fe63cb5d7b3d2cea6819ad48aa4ffce6/image.png)
![image](/uploads/84cbb0fa833f9af0b0c4ab7e8d77dfbf/image.png)

- **/member/searchPass**  :  비밀번호 찾기
    - 올바른 정보를 입력했을 경우,
    ![image](/uploads/a2325718061e1df89fcfd56d1c1344cf/image.png)
    ![image](/uploads/25ea257dda92a670b4d8de4cc94eb15a/image.png)

    - 잘못된 정보를 입력했을 경우,
    ![image](/uploads/bf3d991c6f5cce5ebe5d011f300432ef/image.png)
    ![image](/uploads/cd2f04e985c4b68c4c2e4908bb68ac8c/image.png)

- **/member/selectAllMember**  :  회원조회
![image](/uploads/83b46691ac8ff0f5e0c94f7ed37908f0/image.png)
![image](/uploads/e76a6065691617d1229fd476cc649b36/image.png)

- **/member/updateMember**  :  회원 정보 수정
![image](/uploads/b1f0cbb39db6579264ca33ce881c3dc6/image.png)
![image](/uploads/7348c9d28af3dcfd15411cefc6bf35b3/image.png)
    - 수정 결과 반영
    ![image](/uploads/173c1fac596791ff64d2278123087670/image.png)

✔ **Models**
![image](/uploads/438d36d3b5403a4fa276a2d4dd7ac528/image.png)

![image](/uploads/158fed9554b7a818c1d677332ed167ff/image.png)

![image](/uploads/134b9e48fb5cb64530452c1a6c722a25/image.png)

![image](/uploads/916e97600ddc793fae259c7f86297ddd/image.png)

## 레퍼런스
- https://stackoverflow.com/questions/62578308/swagger-ui-not-displaying-models
