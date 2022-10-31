<%@page import="community.CommunityDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="community.CommunityDao"%>
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
    <title>커뮤니티</title>
</head>
<body>
	<%
	CommunityDao dao = CommunityDao.getInstance();
	ArrayList<CommunityDto> list = dao.getCommunityAll();
	%>
    <h1>커뮤니티</h1>
    <div class="table-container">
        <table border="1">
            <thead>
                <tr>
                    <th>번호</th>
                    <th width="200px">제목</th>
                    <th>작성자</th>
                    <th>작성일자</th>
                    <th>수정일자</th>
                </tr>
            </thead>
            <tbody>
            <%
            for(CommunityDto community: list) {
            %>
                <tr>
                    <td><%=community.getNo()%></td>
                    <td><a href="communityView?no=<%=community.getNo()%>"><%=community.getTitle()%></a></td>
                    <td><%=community.getUser()%></td>
                    <td><%=community.getRegDate()%></td>
                    <td><%=community.getModDate()%></td>
                </tr>
            <%} %>
            </tbody>
        </table>
        <button onclick="location.href='communityWriteForm'">글쓰기</button>
        <button onclick="location.href='index'">메인화면</button>
    </div>
</body>
</html>