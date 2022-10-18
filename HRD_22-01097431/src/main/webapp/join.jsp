<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="index.css">
	<title>쇼핑몰 회원관리</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	MemberDao memberDao = MemberDao.getInstance();
	int custno = memberDao.getLastCustno();
	%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>홈쇼핑 회원 등록</h3>
		<form method="POST" action="joinPro.jsp">
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<td>회원번호(자동발생)</td>
					<td><input type="text" id="custno" name="custno" value="<%=custno %>" readonly></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="custName" name="custName" autofocus></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" id="phone" name="phone"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="address" name="address"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="date" id="joinDate" name="joinDate"></td>
				</tr>
				<tr>
					<td>고객등급[A:VIP, B:일반, C:직원]</td>
					<td><select id="grade" name="grade">
						<option>A</option>
						<option>B</option>
						<option>C</option>
					</select></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" id="city" name="city"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="button" value="조회">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>