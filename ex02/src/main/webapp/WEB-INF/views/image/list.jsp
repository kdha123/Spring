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
<title>이미지 리스트</title>
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
	<h1>이미지 리스트</h1>
	<!-- 데이터 테이블 -->
	<!--  bootstrap 적용 : w3schools.com -->
	<!-- 이미지의 검색 : 제목, 내용, 작성자, 그외 복합  -->
	<!--  페이지는 1페이지, 한페이지에 표시할 데이터 갯수전달. : hidden -->
	<div class="row">
		<div id="searchDiv">
			<form action="list.do" class="form-inline">
				<input name="page" value="1" type="hidden" />
				<div class="form-group">
					<select class="form-control" id="key" name="key">
						<option value="t" ${(param.key == "t")?"selected":"" }>제목</option>
						<option value="c" ${(param.key == "c")?"selected":"" }>내용</option>
						<option value="i" ${(param.key == "i")?"selected":"" }>아이디</option>
						<option value="tc" ${(param.key == "tc")?"selected":"" }>제목/내용</option>
						<option value="ti" ${(param.key == "ti")?"selected":"" }>제목/아이디</option>
						<option value="ci" ${(param.key == "ci")?"selected":"" }>내용/아이디</option>
						<option value="tci" ${(param.key == "tci")?"selected":"" }>전체</option>
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
	<!-- 이미지 갤러리 리스트 작성 -->
		<div class="row">
			<!-- 데이터가 있는 만큼 반복문 처리 시작. -->
			<c:forEach items="${list }" var="dto">
				<!-- col 시작 : no, title, id, writeDate, fileName -->
				<div class="col-md-3 dataRow">
					<div class="thumbnail">
						<img src="${dto.fileName }" alt="${dto.fileName }"
							style="width: 100%">
						<div class="caption">
							<p>
								<span class="no">${dto.no }</span>. ${dto.title }
							</p>
							<p>${dto.id }[${dto.name }] - (<fmt:formatDate value="${dto.writeDate }" pattern="yyyy-MM-dd"/>)</p>
						</div>
					</div>
				</div>
				<!-- col의 끝 -->
			</c:forEach>
			<!-- 데이터가 있는 만큼 반복문 처리 끝. -->
		</div>
		<!-- row의 끝 -->
		<div>
			<p:pageNav endPage="${pageObject.endPage }" totalPage="${pageObject.totalPage }" startPage="${pageObject.startPage }" page="${pageObject.page }" />
		</div>
	<!-- 버튼처리 -->
		<div>
				<a href="write.do?perPageNum=${pageObject.perPageNum }"><button>글쓰기</button></a>
				<a href="list.do?page=1&perPageNum=${pageObject.perPageNum }"><button>전체목록</button></a>
		</div>
</div>
</body>
</html>