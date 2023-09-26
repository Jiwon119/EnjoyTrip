# 04_EnjoyTrip_Back

## 요구사항
- 지역별 관광지 정보 수집 - 데이터베이스의 지역별 관광지 정보를 가져와 화면에 표시
- 관광지, 숙박, 음식점 조회 - 관광지 정보를 지역별 원하는 컨텐츠 별 조회.
- 문화시설, 공연, 여행코스, 쇼핑 조회 - 관광지 정보를 지역별 원하는 컨텐츠 별 조회
- 회원 관리 - 회원가입, 회원탈퇴, 정보수정
- 로그인 관리 - 로그인, 로그아웃, 비밀번호 찾기, 아이디 저장
- 게시글 관리 - 게시글 등록, 조회, 수정, 삭제
- 게시판 관리 - 게시글 목록, 검색



## Class Diagram
✔ **Member Class Diagram**  
![MemberCD](https://github.com/BBSSJJ/BOJ/assets/77558985/e9ff7eb8-bd78-4907-b316-d122cf3e1c08)

✔ **Board Class Diagram**  
![BoardCD](https://github.com/BBSSJJ/BOJ/assets/77558985/0ebe27cb-3483-42f6-bd46-64a20a38ef50)


✔ **EnjoyTrip Class Diagram**  
![TripCD](https://github.com/BBSSJJ/BOJ/assets/77558985/d369a347-db36-4525-939d-77fad3eea937)


✔ **Region Class Diagram**  
![RegionCD](https://github.com/BBSSJJ/BOJ/assets/77558985/7b65db9a-202f-4c15-89c6-16d0cb899f84)


## Usecase Diagram
✔ **Member Usecase Diagram**  
![회원](/uploads/6c5403531813a4fbf9dd633e633b92f9/회원.jpg)  

✔ **Board Usecase Diagram**  
![여행_후기_게시판](/uploads/8d79f5706fb29a6e73bc41fd182b754b/여행_후기_게시판.jpg)  

✔ **EnjoyTrip Usecase Diagram**  
![지도](/uploads/01bc298ad5759ee89cf2f7a664e1d9ad/지도.jpg)  


## 1. 메인 화면
✔ **1-1. 로그인 전**  
![1 main](https://github.com/BBSSJJ/BOJ/assets/77558985/888f6dde-27c9-4827-a8f0-b2ca6a70dd73)

✔ **1-1. 로그인 후**  
![1 main-login](https://github.com/BBSSJJ/BOJ/assets/77558985/a727b213-0320-493c-989e-3df478aa6d86)




## 2. 로그인 관리
✔ **2-1. 회원가입**  
![2 login-join](https://github.com/BBSSJJ/BOJ/assets/77558985/74e35d5e-d780-4d7d-8336-fdf9d2085e16)

✔ **2-2. 로그인, 아이디 저장**  
 ![2 login-remember](https://github.com/BBSSJJ/BOJ/assets/77558985/b5df7975-4e85-482e-88ca-cc77d68d6518)

✔ **2-3. 비밀번호 찾기**  
![2 login-findPW](https://github.com/BBSSJJ/BOJ/assets/77558985/b507d7d9-7181-43b9-b886-43172bb2b28b)




## 3. 회원 관리
✔ **3-1. 내 정보 페이지**  
![3 mypage](https://github.com/BBSSJJ/BOJ/assets/77558985/98b96555-e725-4842-bf24-c3e7418965f0)

✔ **3-2. 정보 수정**  
![3 mypage-update](https://github.com/BBSSJJ/BOJ/assets/77558985/0ecaa6fb-f731-448f-844d-fe4b40ec966e)

✔ **3-3. 회원 탈퇴**  
![3 mypage-delete](https://github.com/BBSSJJ/BOJ/assets/77558985/98733afe-c4e4-4a2f-87d6-60229f82a93f)




## 4. 게시판 관리
✔ **4-1. 여행 후기 목록** 
![4 board](https://github.com/BBSSJJ/BOJ/assets/77558985/7063b0a4-2ef3-4469-9f1a-2ced50a4836d)

✔ **4-2. 검색 조건설정 후 검색** 
![4 board-search](https://github.com/BBSSJJ/BOJ/assets/77558985/fba40f30-63b7-4027-bb35-0f89c6913ffc)




## 5. 게시글 관리
✔ **5-1. 게시글 작성** 
![5 content-write](https://github.com/BBSSJJ/BOJ/assets/77558985/0e1d380f-62e3-4995-adda-2e38e7a2ff57)

✔ **5-1. 게시글 보기** 
![5 content](https://github.com/BBSSJJ/BOJ/assets/77558985/1778cb11-e380-4fa5-b864-3cab4449f978)

✔ **5-1. 게시글 수정** 
![5 content-fix](https://github.com/BBSSJJ/BOJ/assets/77558985/789b1e98-0a48-4a3c-a2e6-df0d53e82568)

✔ **5-1. 게시글 삭제** 
![5 content-delete](https://github.com/BBSSJJ/BOJ/assets/77558985/89c42c01-f8b6-44e7-ac03-49e541774327)




## 6. 지도
✔ **6-1. 지도 화면** 
![6 map-default](https://github.com/BBSSJJ/BOJ/assets/77558985/8997a2cf-9d4d-4a14-9745-6be54617fe44)

✔ **6-2. 관광지 정보 지역별, 컨텐츠별 검색** 
![6 map-type](https://github.com/BBSSJJ/BOJ/assets/77558985/403776a7-4671-4346-8f2c-bc9f75534e1a)

✔ **6-3. 검색어를 통한 검색** 
![6 map-search](https://github.com/BBSSJJ/BOJ/assets/77558985/16859e5f-599a-4af8-b7f0-162f2f8215a0)


