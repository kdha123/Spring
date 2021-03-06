<!-- sitemesh 사용을 위한 설정 파일 -->
<!-- 작성자 : 김동현 -->
<!-- 작성일 : 2020-02-24 -->
<!-- 최종수정일 : 2020-02-24 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!-- JSTL : JSP별로 따로 설정해야 한다. -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>donghyeon::<decorator:title /></title>
<!-- web 라이브러리 : 공통으로 사용 - 여기서만 선언해주면 된다. -->
<!-- BootStrap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- jQuery UI : datepicker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- Icons Awesome5,4 Bootstrap, google -->
<script src="https://kit.fontawesome.com/yourcode.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #627AAA;
	padding: 25px;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 600px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<decorator:head />
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${absUri }">DONG</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="${absUri }/message/list.do">메세지</a></li>
						<li><a href="${absUri }/notice/list.do">공지사항</a></li>
						<li><a href="${absUri }/board/list.do">게시판</a></li>
						<li><a href="${absUri }/member/list.do">회원</a></li>
						<li><a href="${absUri }/image/list.do">이미지</a></li>
						<li><a href="${absUri }/qna/list.do">질문답변</a></li>
						<c:if test="${!empty login }">
							<c:if test="${login.gradeNo==9 }">
								<li><a href="${absUri }/member/list.do">회원관리</a></li>
								<li><a href="${absUri }/schedule/view.do">스케줄 관리</a></li>
							</c:if>
						</c:if>
						<%-- 							<c:if test="${login.gradeNo==9 }"> --%>
						<%-- 							</c:if> --%>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${empty login }">
							<li><a href="${absUri }/member/writeForm.do">회원가입</a></li>
							<li><a href="${absUri }/member/login.do"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:if>
						<c:if test="${!empty login }">
							<li id="welcome">${login.name}[${login.gradeName }]님,환영합니다</li>
							<li><a href="${absUri }/member/view.do?id=${login.id}">MyPage</a></li>
							<li><a href="${absUri }/member/logoutProcess.do"><span
									class="glyphicon glyphicon-log-in"></span> Logout</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer class="container-fluid text-center">
       <span><a href="/index.html">홈</a></span>
       <span><a href="/board/list.do">회사소개</a></span>
        <span><a href="/board/list.do">이용약관</a></span>
       <span><a href="/board/list.do"><strong>개인정보취급방침</strong></a></span>
        <span><a href="/board/list.do">이용안내</a></span>
    <p class="address">
        <span>대표자(성명) : 브랜드독 </span> <span>사업자 등록번호 안내 : [123-45-68790]</span> <br />
        <span>전화 : 02-1234-5678 </span> <span>팩스 : 02-1234-5678 </span> <span>주소 : 서울특별시 구로구 경영기술개발원 </span><br />
        <span>Contact <strong>security@branddog.com</strong> for more information.</span>
    </p>
    <p class="copyright">Copyright &copy; 2020 <strong>www.branddog.com</strong>. All rights reserved.</p>
    <p class="pageTop"><a href=".navbar-header" title="화면 최상단으로 이동하기"></a></p>
	</footer>
</body>
</html>