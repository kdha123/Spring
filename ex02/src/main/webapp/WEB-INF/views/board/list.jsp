<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
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
	// 하나의 글을 선택하면 (tr tag를 클릭)하면 글번호를 받아내서 글보기로 보낸다.
	$(".dataRow").click(function() {
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no
				+ "&cnt=1"
				+ "&page=${pageObject.page}"
				+ "&perPageNum=${pageObject.perPageNum}"
				// el 객체에서 empty -> null || "" 체크 -> 데이터가 넘어오지 않았다.
				// el 객체에서 문자열 연결을 "+" 로 사용 불가능 => "+=" 로 사용한다.
			   ${(!empty pageObject.word)?   
					   " + \"&key=" += pageObject.key += "&word="
					   += pageObject.word += "\"":""};
	});
	
	// 페이지 네이션의 클릭 이벤트 처리
	$(".pagination > li:not('.active')").click(
			function() {
				// 		alert("페이지 이동 클릭");
				// .data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.
				var page = $(this).data("page");
//					alert(page + "-" + typeof page);

				location = "list.do?page=" + page
						+ "&perPageNum=${pageObject.perPageNum}"
						+ "&key=${pageObject.key}"
						+ "&word=${pageObject.word}";
				// a tag의 페이지 이동을 취소 시킨다.
				return false;
			});
	$("li.active").click(function() {
		return false;
	});
	
	// 한페이지에 나타날 글의 갯수 변경 이벤트 처리
	$("#perPageRow").on({
		"change":function(){
//				alert("change");
			perPageNum = $("#perPageRow").val();
			location="list.do?page=1"
				+ "&perPageNum=" + perPageNum
				+ "&key=${pageObject.key}"
				+ "&word=${pageObject.word}";
		}
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
	<!-- 게시판의 검색 : 제목, 내용, 작성자, 그외 복합  -->
	<!--  페이지는 1페이지, 한페이지에 표시할 데이터 갯수전달. : hidden -->
	<div class="row">
		<div id="searchDiv">
			<form action="list.do" class="form-inline">
				<input name="page" value="1" type="hidden" />
				<div class="form-group">
					<select class="form-control" id="key" name="key">
						<option value="t" ${(param.key == "t")?"selected":"" }>제목</option>
						<option value="c" ${(param.key == "c")?"selected":"" }>내용</option>
						<option value="w" ${(param.key == "w")?"selected":"" }>작성자</option>
						<option value="tc" ${(param.key == "tc")?"selected":"" }>제목/내용</option>
						<option value="tw" ${(param.key == "tw")?"selected":"" }>제목/작성자</option>
						<option value="cw" ${(param.key == "cw")?"selected":"" }>내용/작성자</option>
						<option value="tcw" ${(param.key == "tcw")?"selected":"" }>전체</option>
					</select>
				</div>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="word" value="${param.word }" id="word">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
				<div class="input-group right">
						<span class="input-group-addon">Rows/Page</span>
					  <select class="form-control" id="perPageRow">
					    <option ${(pageObject.perPageNum == 10)?"selected='selected'":"" }>10</option>
					    <option ${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
					    <option ${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
					    <option ${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
					  </select>
					</div>
			</form>
		</div>
	</div>
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
	<!-- 페이지 처리-->
		<tr>
			<td colspan="5">
			<p:pageNav endPage="${pageObject.endPage }" totalPage="${pageObject.totalPage }" startPage="${pageObject.startPage }" page="${pageObject.page }" />
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<a href="write.do"><button>글쓰기</button></a>
			</td>
		</tr>
	</table>
	
</div>
</body>
</html>