<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE-edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="index.css">
	<title>쇼핑몰 회원관리</title>
</head>
<body>
	<% 
	request.setCharacterEncoding("UTF-8");
	
	MemberDao memberDao = MemberDao.getInstance();
	String custno = request.getParameter("custno");
	
	
	if(custno == null) {
		response.sendRedirect("list.jsp");
	} else {
		MemberDto member = memberDao.getMember(Integer.parseInt(custno));
		if(member == null) {
			response.sendRedirect("list.jsp");
		} else { %>
			
	<jsp:include page="header.jsp"/>
	<section>
		<h3>홈쇼핑 회원 정보 수정</h3>
		<form method="post" action="updatePro.jsp">
			<table border="1" style="border-collapse: collapse">
				<tr>
					<td>회원번호</td>
					<td><input type="text" id="custno" name="custno" value="<%=member.getCustno() %>" readonly></td>
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" id="custName" name="custName" value="<%=member.getCustName() %>"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" id="phone" name="phone" value="<%=member.getPhone() %>"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" id="address" name="address" value="<%=member.getAddress() %>"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="date" id="joinDate" name="joinDate" value="<%=member.getJoinDate() %>"></td>
				</tr>
				<tr>
					<td>고객등급[A:VIP, B:일반, C:직원]</td>
					<td><select id="grade" name="grade">
						<option value="A" <%=member.getGrade().equals("A") ? "selected" : "" %>>A</option>
						<option value="B" <%=member.getGrade().equals("B") ? "selected" : "" %>>B</option>
						<option value="C" <%=member.getGrade().equals("C") ? "selected" : "" %>>C</option>
					</select></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" id="city" name="city" value="<%=member.getCity() %>"></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="조회">
					<input type="button" value="삭제">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp"/>
		<%}
	}%>
</body>
</html>