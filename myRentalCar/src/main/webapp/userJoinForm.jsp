<%@page import="java.sql.Timestamp"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/table.css">
    <title>회원가입</title>
</head>
<body>
	<%
	UserDao dao = UserDao.getInstance();
	int code = dao.codeGenerator();
	Timestamp now = new Timestamp(System.currentTimeMillis());
	%>
    <h1>렌터카 회원가입</h1>
    <div class="table-container">
    	<form method="POST" action="UserJoin">
	   		<table border="1">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" id="code" name="code" value="<%=code%>" readonly></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="id" name="id" placeholder="아이디를 입력하세요." autofocus required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." required></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="name" name="name" placeholder="성명을 입력하세요." required></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="address" name="address" placeholder="주소를 입력하세요." required></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" id="phone" name="phone" placeholder="전화번호를 입력하세요." required></td>
				</tr>
				<tr>
					<td>면허번호</td>
					<td><input type="text" id="license" name="license" placeholder="운전면허번호를 입력하세요." required></td>
				</tr>
			</table>
			<input class="btn" type="submit" value="가입">
    	</form>
    	<button onclick="location.href='index'">메인화면</button>
    </div>
</body>
</html>