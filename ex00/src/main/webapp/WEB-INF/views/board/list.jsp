<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.dataRow:hover {
	background: #5CEEE6;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	//이벤트처리
	$(function() {
		// 하나의 글을 선택하면 (tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
		$(".dataRow").click(function() {
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no
		});
	});
</script>
</head>
<body>
<div class = "container">
	<h1>게시판리스트</h1>
	<table class = "table table-bordered">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<!-- for each써서 데이터가 없을 때 까지 반복 위의 태그라이브러리에서 c라는 코어를 쓴다고 해야 쓸 수 있다  -->
		<c:forEach items="${list }" var="dto">
			<tr class="dataRow">
				<td class="no" >${dto.no }</td>
				<td>${dto.title }</td>
				<td>${dto.writer }</td>
				<td><fmt:formatDate value="${dto.writeDate }" pattern="yyyy.MM.dd"/></td>
				<td>${dto.hit }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write.do"><button>글쓰기</button></a></td>
		</tr>
	</table>
</div>
</body>
</html>