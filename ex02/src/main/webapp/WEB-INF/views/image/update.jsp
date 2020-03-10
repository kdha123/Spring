<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글수정</title>
</head>
<body>
<div class="container">
	<h2>글쓰기</h2>
	<!-- 많은 데이터를 넘길 때는 form action -->
	<form action="update.do" method="post" id="updateForm">
	<!-- bootstrap form-group -> form-control -->
	<!--  넘겨질 글 번호 수정불가 -->
		<div class="form-group">
			<label for="no">글번호 :</label>
			<input type="text" class="form-control" id="no" name="no" value="${dto.no }" readonly="readonly">
			<br />
		</div>
		<div class="form-group">
			<label for="title">제목 :</label>
			<input type="text" class="form-control" id="title" placeholder="제목입력" name="title" value="${dto.title }" autocomplete="off"
			title="제목은 4~100글자로 입력하셔야합니다.">
			<br />
		</div>
		<div class="form-group">
			<label for="content">내용:</label><br />
			<textarea rows="5" cols="100" name="content" class="form-control" id="content">${dto.content }</textarea>
			<br />
		</div>
		<div class="form-group">
		<!-- 작성자(익명-제한없이 아무거나 입력가능) -->
			<label for="writer">작성자</label> 
			<input type="text" class="form-control" id="writer" name="writer" value="${dto.writer }" autocomplete="off">
			<br />
		</div>
		<div class="form-group">
			<label for="password">비밀번호:자신글 확인용</label> 
			<input type="password" class="form-control" id="pw" name="pw" title="비밀번호는 4~20글자 사이로 입력" pattern="^.{4,20}$" autocomplete="off">
			<br />
		</div>
		<button class="btn btn-default">수정</button>
		<button type="reset" class="btn btn-default">다시 입력</button>
		<button type="button" onclick="history.back()" class="btn btn-default">취소</button>


	</form>
</div>

</body>
</html>