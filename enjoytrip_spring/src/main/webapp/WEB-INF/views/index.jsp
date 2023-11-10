<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="idck" value=" checked"/>
	<c:set var="saveid" value="${cookie.ssafy_id.value}"/>
</c:if>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link href="${root}/assets/css/app.css" rel="stylesheet" />
    <title>SSAFY</title>
  </head>
  <body>

	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
	<div class="container p-4">
		<h1 class="text-center">지금이 국내 여행 타이밍 .....!</h1>
	</div>
	<div class="text-center">
		<img src="https://img.freepik.com/free-vector/flat-tourists-ready-holiday_23-2149059980.jpg?w=996&t=st=1695776154~exp=1695776754~hmac=b300fbfe737f1729f38130f7cfb26afaa94027dc531b89bec92078bc4220749d">
	</div>
	<div class="text-center">
		<ul class="no_dot">
			<!-- <li><a href="person?act=form">사람 등록하기</a>
			<li><a href="person?act=list">사람 목록보기</a> -->
			<li><a style="font-size:1.3em;" href="/map"><img src="/img/궁.png" style="width:50px; height:60px; margin:10px;">관광지 검색</a></li>

			
			<li><a style="font-size:1.3em;"><img src="/img/지도.png" style="width:50px; height:60px; margin:10px;">나만의 여행계획</a></li>
		</ul>
	</div>
  </body>
</html>
