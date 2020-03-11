<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록</title>
</head>
<body>
<div class="container">
	<h2>글쓰기</h2>
	<!-- 많은 데이터를 넘길 때는 form action -->
	<form action="write.do" method="post" id="writeForm" enctype="multipart/form-data">
	<!-- bootstrap form-group -> form-control -->
		<div class="form-group">
			<label for="title">제목 :</label>
			<input type="text" class="form-control" id="title" placeholder="제목입력" name="title">
			<br />
		</div>
		<div class="form-group">
			<label for="content">내용:</label><br />
			<textarea rows="5" cols="100" name="content" class="form-control" id="content" placeholder="내용입력"></textarea>
			<br />
		</div>
		<!-- 작성자 : login 정보를 사용 : Controller에서 session을 이용한다. -->
		<!-- 첨부파일  -->
		<div class="form-group">
		<!-- 작성자(익명-제한없이 아무거나 입력가능) -->
			<label for="multiFile">파일</label> 
			<input type="file" class="form-control" id="multiFile" name="multiFile" required="required">
			<br />
		</div>
		<button class="btn btn-default">등록</button>
		<button type="reset" class="btn btn-default">다시 입력</button>
		<button type="button" onclick="history.back()" class="btn btn-default">취소</button>


	</form>
</div>

</body>
</html>