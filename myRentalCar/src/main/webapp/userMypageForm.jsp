<%@page import="user.UserDto"%>
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
    <title>마이페이지</title>
</head>
<body>
	<%
	if(session.getAttribute("id") == null) {
		response.sendRedirect("index.jsp");
	} else {
		UserDao dao = UserDao.getInstance();
		UserDto user = dao.getUserById((String)session.getAttribute("id"));
	%>
	<h1>마이페이지</h1>
    <div class="table-container">
    	<form method="POST" action="UserMypage">
	   		<table border="1">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="hidden" id="code" name="code" value="<%=user.getCode()%>"><%=user.getCode()%></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><%=user.getId()%></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="password" name="password" value="<%=user.getPassword()%>" required></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="name" name="name" value="<%=user.getName()%>" required></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="address" name="address" value="<%=user.getAddress()%>" required></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" id="phone" name="phone" value="<%=user.getPhone()%>" required></td>
				</tr>
				<tr>
					<td>면허번호</td>
					<td><%=user.getLicense()%></td>
				</tr>
			</table>
			<input class="btn" type="submit" id="mypage" name="mypage" value="수정">
			<br>
			<input class="btn" type="submit" id="mypage" name="mypage" value="탈퇴">
    	</form>
    	<button onclick="location.href='index'">메인화면</button>
    </div>
	<%} %>
</body>
</html>