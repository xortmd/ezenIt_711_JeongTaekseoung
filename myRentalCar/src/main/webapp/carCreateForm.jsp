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
	int code = dao.codeGenerator();
	%>
    <h1>자동차 등록</h1>
    <div class="table-container">
    	<form method="POST" action="CarCreate">
	   		<table border="1">
				<tr>
					<td>차량코드(자동발생)</td>
					<td><input type="text" id="code" name="code" value="<%=code%>" readonly></td>
				</tr>
				<tr>
					<td>모델명</td>
					<td><input type="text" id="name" name="name" placeholder="차량명을 입력하세요." autofocus required></td>
				</tr>
				<tr>
					<td>차량번호</td>
					<td><input type="text" id="carNo" name="carNo" placeholder="차량번호를 입력하세요." autofocus required></td>
				</tr>
				<tr>
					<td>연식</td>
					<td><input type="text" id="year" name="year" placeholder="연식을 입력하세요." required></td>
				</tr>
				<tr>
					<td>키로수</td>
					<td><input type="text" id="km" name="km" placeholder="키로수를 입력하세요." required></td>
				</tr>
				<tr>
					<td>비용</td>
					<td><input type="text" id="price" name="price" placeholder="비용을 입력하세요." required></td>
				</tr>
				<tr>
					<td>차량종류</td>
					<td>
						<select id="kind" name="kind" required>
							<option value="경차">경차</option>
							<option value="소형차">소형차</option>
							<option value="중형차">중형차</option>
							<option value="대형차">대형차</option>
							<option value="화물차">화물차</option>
							<option value="스포츠카">스포츠카</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>연료</td>
					<td>
						<select id="fuel" name="fuel" required>
							<option value="가솔린">가솔린</option>
							<option value="디젤">디젤</option>
							<option value="LPG">LPG</option>
						</select>
					</td>
				</tr>
			</table>
			<input class="btn" type="submit" value="등록">
    	</form>
    	<button onclick="location.href='carList'">뒤로가기</button>
    </div>
</body>
</html>