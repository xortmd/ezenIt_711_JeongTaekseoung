<%@page import="java.util.ArrayList"%>
<%@page import="money.MoneyDao"%>
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
	MoneyDao moneyDao = MoneyDao.getInstance();
	ArrayList<String[]> list = moneyDao.getSalesReport();
	%>
	<jsp:include page="header.jsp"/>
	<section>
		<h3>회원매출조회</h3>
		<table border="1" style="border-collapse: collapse;">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>고객등급</th>
					<th>매출</th>
				</tr>
			</thead>
			<%for(String[] data : list) {%>
			<tbody>
				<tr>
					<%for(int i = 0; i < data.length; i++) {%>
					<td><%=data[i] %></td>
					<%} %>
				</tr>
			</tbody>
			<%} %>
		</table>
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>