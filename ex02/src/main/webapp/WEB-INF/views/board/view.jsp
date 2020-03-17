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
.chat{list-style: none;}
</style>

<script type="text/javascript">
// 댓글 객체 - 속성, 함수
var replyService = (function(){

	// getList를 저장하는 프로그램 작성 -> 필요한 데이터 param(no, page), callback-처리되는 함수, error-오류가 났을때 객체
	function getList(param, callback, error){
		var no = param.no;
		var page = param.page;

		// $.getJSON
		$.getJSON(
				// 데이터 요청 URI
				"/reply/pages/" + no + "/" + page + ".json",
				// 데이터 가져오기를 성공하면 처리되는 함수. data : 서버에서 넘어오는 데이터
				function(data){
					// 데이터를 가져오기를 성공하면 실행되는 함수를 밖에서 선언해서 넣어주는 경우 처리
					if(callback){
						callback(data);
					}
				}
		// 데이터 가져오는 것을 실패했을 때의 처리
		).fail(function(xhr, status, err){
			if(err){
				err();
			}
		});
	}

	// 날짜 timestamp 숫자를 받아서 날짜 형식을 리턴해 주는 함수. -> json데이터로 받을때 timestamp로 전달된다.
	function displayDate(timeValue){
		var today = new Date(); // 오늘 날짜 셋팅
		// today.getTime() - timeValue // 현재 날짜시간과 댓글 작성일의 차이
		// 차이가 24시간이 지나지 않았으면 시간을 지났으면 날짜를 표시할수 있도록 할수 있다.
		var dateObj = new Date(timeValue); // 댓글을 작성한 날짜 객체
		var str ="";
		str += dateObj.getFullYear() + ".";
		str += (dateObj.getMonth() + 1) + "."; // month 는 0~ 11까지 사용하기 때문에 +1 처리한다.
		str += dateObj.getDate();

		// [yy, mm, dd].join("."); - 중간에 .을 이용해서 이어 붙인다.
		return str;
	}
	
	return {
		// 댓글 리스트가 처리되 결과를 만들어 내는 함수
		getList : getList,
		displayDate : displayDate
	}
})();

$(function(){

	// 댓글을 처리하는 프로그램 작성
	var no = ${dto.no};
	// 댓글 리스트를 표시할 객체 저장
	var replyUL = $(".chat")
	
	// 댓글 리스트를 가져와서 보여주는 함수 호출
	showList(1);

	// 댓글 리스트를 보여 주는 function: 글보기를 호출하면 바로 보여주는 부분이므로 페이지는 1페이지이다.
	function showList(page){
		// getList({no,page}, callback function(data), error)
		replyService.getList(
			{no:no, page:page},
			function(list){
				var str = "";
				// 댓글이 없는 경우의 처리
				if(list == null || list.length ==0){
					replyUL.html("<li class='left clearfix'>댓글이 존재하지 않습니다.</li>");
					return;
				}
				// 댓글이 있는 경우의 처리
				for(var i = 0; i < list.length; i++){
					var dto = list[i];
					str += "<li class='left clearfix' data-rno='"+dto.rno+"'>";
					str += "<div>";
					str += "<div class='header'>";
					str += "<strong class='primary-font'>"+ dto.writer +"</strong>";
					str += "<small class='pull-right text-muted'>" + replyService.displayDate(dto.writeDate) + "</small>";
					str += "</div>";
					str += "<p>" + dto.content + "</p>";
					str += "</div>";
					str += "<hr>";
					str += "</li>";
				}
				replyUL.html(str);
			}
		);
	}
	
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
		<tr>
			<td colspan="2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-comments fa-fw"></i> Reply
					</div>
					<div class="panel-body">
						<ul class="chat">
							<li class="left clearfix" data-rno="4">
								<div>
									<div class="header">
										<strong class="primary-font">writer</strong>
										<small class="pull-right text-muted">2020.03.15</small>
									</div>
									<p>jjang jjang</p>
								</div>
								<hr>
							</li>
							<li class="left clearfix">
								댓글 존재하지 않습니다.
							</li>
						</ul>
					</div>
				</div>
			</td>
		</tr>
	</table>
<!-- </div> -->
</body>
</html>