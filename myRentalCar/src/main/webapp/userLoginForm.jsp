<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/table.css">
    <title>로그인</title>
</head>
<body>
	<h1>렌터카 로그인</h1>
	<div class="table-container">
	    <form method="POST" action="UserLogin">
   			<table border="1">
				<tr>
					<td class="td1">아이디</td>
					<td><input type="text" id="id" name="id" placeholder="아이디를 입력하세요." autofocus required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." required></td>
				</tr>
			</table>
			<input class="btn" type="submit" value="로그인">
    	</form>
    	<button onclick="location.href='index'">메인화면</button>
	</div>
</body>
</html>