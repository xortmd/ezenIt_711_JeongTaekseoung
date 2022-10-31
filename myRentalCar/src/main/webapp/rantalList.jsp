<%@page import="car.CarDto"%>
<%@page import="car.CarDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/table.css">
    <title>차량대여</title>
</head>
<body>
	<%
	CarDao dao = CarDao.getInstance();
	ArrayList<CarDto> list = dao.getCarAll();
	%>
    <h1>자동차 리스트</h1>
    <div class="table-container">
        <table border="1">
            <thead>
                <tr>
                    <th>차량코드</th>
                    <th>모델명</th>
                    <th>차량번호</th>
                    <th>연식</th>
                    <th>키로수</th>
                    <th>비용</th>
                    <th>차량종류</th>
                    <th>연료</th>
                    <th>등록일자</th>
                </tr>
            </thead>
            <tbody>
            <%for(CarDto car: list) {%>
                <tr>
                    <td><%=car.getCode()%></td>
                    <td><%=car.getName()%></td>
                    <td><%=car.getCarNo()%></td>
                    <td><%=car.getYear()%></td>
                    <td><%=car.getKm()%></td>
                    <td><%=car.getPrice()%></td>
                    <td><%=car.getKind()%></td>
                    <td><%=car.getFuel()%></td>
                    <td><%=car.getRegDate()%></td>
                    <td>
						<form method="POST">
            				<input type="button" onclick="location.href='carUpdateForm?code=<%=car.getCode() %>'" value="수정">
							<input type="button" onclick="location.href='CarDelete?code=<%=car.getCode() %>'" value="삭제">
						</form>
					</td>
                </tr>
            <%} %>
            </tbody>
        </table>
        <button onclick="location.href='carCreateForm'">등록</button>
        <button onclick="location.href='index'">메인화면</button>
    </div>
</body>
</html>