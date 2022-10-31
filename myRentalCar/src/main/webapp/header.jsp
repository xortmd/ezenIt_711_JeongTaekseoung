<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/grid.css">
    <title>TS RENTAL CAR</title>
</head>
<body>
    <header>
		<div>
			<%if(session.getAttribute("id") != null) {%>
				<button onclick="location.href='UserLogout'">로그아웃</button>
            	<button onclick="location.href='carList'">관리자모드</button>
			<%} else {%>
            	<button onclick="location.href='userJoinForm'">회원가입</button>
            	<button onclick="location.href='userLoginForm'">로그인</button>
            <%} %>
        </div>
        <h1>TS RENTAL CAR</h1>
    </header>
    <nav>
        <ul>
            <li><a href="guide">서비스안내</a></li>
            <li><a href="rentalList">차량대여</a></li>
            <li><a href="communityList">커뮤니티</a></li>
            <li><a href="noticeList">공지사항</a></li>
            <li><a href="userMypageForm">마이페이지</a></li>
        </ul>
    </nav>
    <aside>
        광고이미지
    </aside>
</body>
</html>