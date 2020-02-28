<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>
<style type="text/css">
#pwDiv{display: none;}
</style>

<script type="text/javascript">
$(function(){
	$("#deleteBtn").click(function(){
		$("#pwDiv").show();
		// href="" -> 자신을 다시 호출한다. => false : 호출하는 것을 무시
		return false;
	});
});
</script>
</head>
<body>
<!-- 데이터 표시하는 부분 : Bootstrap 쉽게 표시 : 라이브러리 필요 -> sitemesh에서 처리 -->
<!-- <div class="container"> -->
	<!-- 제목 -->
	<h1>게시판 글보기</h1>
	<!-- 데이터 테이블 -->
	<!-- bootstrap 적용 : w3schools.com 참조
		: 1. 라이브러리 등록 , 2.body안에 container 3. 그외필요한 객체 => tag 안에 class -->
	<table class="table">
		<tr>
			<th>글번호</th>
			<!-- dto안에 no property를 사용했다. => getNo()를 사용한 것 -->
			<td>${dto.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<!-- dto안에 no property를 사용했다. => getTitle()를 사용한 것 -->
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>글내용</th>
			<!-- dto안에 no property를 사용했다. => getContent()를 사용한 것
				출력만 하면 HTML에서 줄바꿈을 무시한다. => pre tag사용 -->
			<td><pre>${dto.content }</pre></td>
		</tr>
		<tr>
			<th>작성자</th>
			<!-- dto안에 no property를 사용했다. => getWriter()를 사용한 것 -->
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<!-- dto안에 no property를 사용했다. => getWriteDate()를 사용한 것 -->
			<td>
				<fmt:formatDate value="${dto.writeDate }"
				 pattern="yyyy.MM.dd" />
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<!-- dto안에 no property를 사용했다. => getHit()를 사용한 것 -->
			<td>${dto.hit }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="update.do?no=${dto.no }"
					role="button" class="btn btn-default">수정</a>
				<a href="" id="deleteBtn"
					role="button" class="btn btn-default">삭제</a>
				<div id="pwDiv">
					<form action="delete.do" method="post">
						<input type="hidden" name="no"
						 value="${dto.no}" />
						<!-- 비밀번호 : 확인용 비밀번호는 안보이게 처리 -->
						<div class="form-group">
							<label for="pw">비밀번호:자신글 확인용</label>
							<input type="password" class="form-control" id="pw" name="pw"
								autocomplete="off"
								title="비밀번호는 4~20 글자 사이로 입력하셔야 합니다." pattern="^.{4,20}$">
						</div>
						<button>삭제</button>
					</form>
				</div>
			</td>
		</tr>
	</table>
<!-- </div> -->
</body>
</html>