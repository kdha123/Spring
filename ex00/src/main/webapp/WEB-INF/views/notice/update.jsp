<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/regExutil.js"></script>
</head>
<body>
	<div class="container">
		<h2>게시판 글 수정하기</h2>
		<!-- 많은 데이터를 넘길 때는 form action -->
		<form action="update.do" method="post">
			<input type="hidden" name="page" value="${param.page }" /> <input
				type="hidden" name="perPageNum" value="${param.perPageNum }" /> <input
				type="hidden" name="key" value="${param.key }" /> <input
				type="hidden" name="word" value="${param.word }" />
			<div class="form-group">
				<!-- 글번호 수정불가-->
				<label for="no">글번호 :</label>
				<!-- id: 한개 태그 - 화면단 컨트롤하기 위해서 붙인다./ name:넘어가는 데이터 키에 해당된다. -->
				<input class="form-control" id="no" name="no" value="${dto.no }"
					readonly="readonly"><br />
			</div>
			<div class="form-group">
				<!-- 제목 입력 : 한줄 - 키보드입력 -->
				<label for="title">제목 :</label>
				<!-- id: 한개 태그 - 화면단 컨트롤하기 위해서 붙인다./ name:넘어가는 데이터 키에 해당된다. -->
				<input type="text" class="form-control" id="title"
					placeholder="제목입력" name="title" maxlength="300" required="required"
					value="${dto.title }"><br />
			</div>
			<div class="form-group">
				<!-- 내용 입력 : 여러줄 - 키보드입력 -->
				<label for="content">내용:</label><br />
				<textarea rows="5" name="content" class="form-control" id="content"
					placeholder="내용입력" maxlength="2000" required="required">${dto.content }</textarea>
				<br />
			</div>
			<div class="form-group">
				<label for="startDate">공지시작일 :</label> <input type="text"
					class="form-control" id="startDate" placeholder="시작일 입력 -클릭"
					name="startDate" maxlength="10" required="required" value="${dto.startDate }"
					pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$" /><br />
			</div>
			<div class="form-group">
				<label for="endDate">공지종료일:</label> <input type="text"
					class="form-control" id="endDate" placeholder="종료일 입력 -클릭"
					name="endDate" maxlength="10" required="required" value="${dto.endDate }"
					pattern="^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$" /><br /> <br />
			</div>


			<!-- button tag의 기본 type은 submit이다. 그래서  생략가능 -->
			<button type="submit" class="btn btn-default">수정하기</button>
			<button type="reset" class="btn btn-default">다시 입력</button>
			<!-- 	버튼 기능만 사용하고 다른 동작은 하지 않도록 하는 타입 : button -->
			<!-- 	동작을 따로 정의하는데 onclick(클릭할 때 동작) / history.bak()<-이전페이지로이동 -->
			<button type="button" onclick="history.back();"
				class="btn btn-default">취소</button>
		</form>
	</div>
</body>
</html>