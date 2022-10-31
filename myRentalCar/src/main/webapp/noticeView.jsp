<%@page import="notice.NoticeDao"%>
<%@page import="notice.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/form.css">
    <title>글내용</title>
</head>
<body>
	<%
	NoticeDao dao = NoticeDao.getInstance();
	NoticeDto notice = null;
			
	request.setCharacterEncoding("UTF-8");
	if(request.getParameter("no") != null) {
		int no = Integer.parseInt(request.getParameter("no"));
		notice = dao.getNoticeByNo(no);
		String user = (String)session.getAttribute("id");
	%>
		
    <h1>글내용</h1>
    <div class="form-container">
        <form method="post" action="NoticeDelete">
            <input type="text" value="<%=notice.getTitle() %>" readonly>
            <textarea rows="20" readonly><%=notice.getContent() %></textarea>
            <input type="button" onclick="location.href='noticeList'" value="글목록">
            <%if(user.equals(notice.getUser())) {%>
            	<input type="button" onclick="location.href='noticeUpdateForm?no=<%=no %>'" value="글수정">
            	<input type="hidden" name="no" value="<%=no %>">
            	<input type="submit" value="글삭제">
            <%} %>
        </form>
    </div>
	<%} else {
		response.sendRedirect("noticeList"); // board 조회 실패 -> 페이지 이동
	}%>
</body>
</html>