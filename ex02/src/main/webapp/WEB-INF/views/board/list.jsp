<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css"> 
.dataRow:hover {
	background: #5CEEE6;
	cursor: pointer;
}
</style>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
		var no = $(this).find(".no").text();
		location = "view.do?no="+no;
		});
});
</script>
</head>
<body>
<div class="container">
	<!-- 제목 -->
	<h1>게시판 리스트</h1>
	<!-- 데이터 테이블 -->
	<!--  bootstrap 적용 : w3schools.com -->
	<table class="table table-bordered">
	<!-- 데이터의 갯수 만큼 tr을 만든다. : 반복문 -> jsp jstl 사용 태그로 작성 -->
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr class="dataRow">
				<td class="no">${dto.no }</td>
				<td>${dto.title }<span>[${dto.reply_cnt }]</span></td>
				<td>${dto.writer }</td>
				<!-- 날짜형을 특별한 형식에 맞춰서 출력 : JSTL - fmt : JAVA SimpleDateFormat -->
				<td><fmt:formatDate value="${dto.writeDate }" pattern="yyyy-MM-dd"/></td>
				<td>${dto.hit }</td>
			</tr>
		</c:forEach>
	<!-- 데이터 표시하는 부분 : Bootstrap 쉽게 표시 : 라이브러리 필요 : sitemesh에서 처리 -->
	<!-- 페이지 처리 : 나중에 -->
		<tr>
			<td colspan="5">
				<a href="write.do"><button>글쓰기</button></a>
			</td>
		</tr>
	</table>
	
</div>
</body>
</html>