<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
		<h1>게시판 글 보기</h1>
		<table class="table">
			<tr>
				<th>글번호</th>
				<td>${view.no}</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td>${view.title}</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><pre>${view.content}</pre></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${view.writer}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${view.hit}</td>
			</tr>
			<tr>
				<td colspan="2"><a
					href="updateForm.do?no=${view.no }"><button>수정</button></a>
					<a href="delete.do?no=${view.no }"><button id="deleteBtn">삭제</button></a>
					<a
					href="list.do"><button>목록</button></a>
				</td>
			</tr>
		</table>
</div>
</body>
</html>