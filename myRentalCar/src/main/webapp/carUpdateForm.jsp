<%@page import="car.CarDto"%>
<%@page import="car.CarDao"%>
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
	CarDao dao = CarDao.getInstance();
	request.setCharacterEncoding("UTF-8");
	
	int code = Integer.parseInt(request.getParameter("code"));
	CarDto car = dao.getCarByCode(code);
	%>
    <h1>자동차 수정</h1>
    <div class="table-container">
    	<form method="POST" action="CarUpdate">
	   		<table border="1">
				<tr>
					<td>차량코드(자동발생)</td>
					<td><input type="hidden" id="code" name="code" value="<%=car.getCode()%>"><%=code%></td>
				</tr>
				<tr>
					<td>모델명</td>
					<td><%=car.getName()%></td>
				</tr>
				<tr>
					<td>차량번호</td>
					<td><%=car.getCarNo()%></td>
				</tr>
				<tr>
					<td>연식</td>
					<td><%=car.getYear()%></td>
				</tr>
				<tr>
					<td>키로수</td>
					<td><input type="text" id="km" name="km" value="<%=car.getKm()%>" required></td>
				</tr>
				<tr>
					<td>비용</td>
					<td><input type="text" id="price" name="price" value="<%=car.getPrice()%>" required></td>
				</tr>
				<tr>
					<td>차량종류</td>
					<td><%=car.getKind()%></td>
				</tr>
				<tr>
					<td>연료</td>
					<td><%=car.getFuel()%></td>
				</tr>
			</table>
			<input class="btn" type="submit" value="등록">
    	</form>
    	<button onclick="location.href='carList'">뒤로가기</button>
    </div>
</body>
</html>