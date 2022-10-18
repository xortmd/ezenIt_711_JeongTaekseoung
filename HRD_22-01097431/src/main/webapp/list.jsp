<%@page import="member.MemberDto"%>
<%@page import="java.util.ArrayList"%>
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
	MemberDao memberDao = MemberDao.getInstance();
	ArrayList<MemberDto> list = memberDao.getMemberAll();
	%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>회원목록조회/수정</h3>
		<table border="1" style="border-collapse: collapse;">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>가입일자</th>
					<th>고객등급</th>
					<th>거주지역</th>
				</tr>
			</thead>
			<%for(MemberDto member : list) {%>
			<tbody>
				<tr>
					<td><a href="update.jsp?custno=<%=member.getCustno() %>"><%=member.getCustno() %></a></td>
					<td><%=member.getCustName() %></td>
					<td><%=member.getPhone() %></td>
					<td><%=member.getAddress() %></td>
					<td><%=member.getJoinDate() %></td>
					<td><%=member.getGrade() %></td>
					<td><%=member.getCity() %></td>
				</tr>
			</tbody>
			<%}%>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>