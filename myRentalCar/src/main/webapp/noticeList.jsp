<%@page import="notice.NoticeDto"%>
<%@page import="notice.NoticeDao"%>
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
    <title>공지사항</title>
</head>
<body>
	<%
	NoticeDao dao = NoticeDao.getInstance();
	ArrayList<NoticeDto> list = dao.getNoticeAll();
	%>
    <h1>공지사항</h1>
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
            for(NoticeDto notice : list) {
            %>
                <tr>
                    <td><%=notice.getNo()%></td>
                    <td><a href="noticeView?no=<%=notice.getNo()%>"><%=notice.getTitle()%></a></td>
                    <td><%=notice.getUser()%></td>
                    <td><%=notice.getRegDate()%></td>
                    <td><%=notice.getModDate()%></td>
                </tr>
            <%} %>
            </tbody>
        </table>
        <button onclick="location.href='noticeWriteForm'">글쓰기</button>
        <button onclick="location.href='index'">메인화면</button>
    </div>
</body>
</html>