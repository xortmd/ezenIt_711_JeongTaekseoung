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
    <title>글수정 </title>
</head>
<body>
	<%
	NoticeDao dao = NoticeDao.getInstance();
	NoticeDto notice = null;
			
	request.setCharacterEncoding("UTF-8");
	if(request.getParameter("no") != null) {
	int no = Integer.parseInt(request.getParameter("no"));
	notice = dao.getNoticeByNo(no);
	%>
    <h1>글수정</h1>
    <div class="form-container">
        <form method="post" action="NoticeUpdate">
        	<input type="hidden" name="no" value="<%=no %>">
            <input type="text" name="title" value="<%=notice.getTitle() %>" required>
            <textarea name="content" rows="20" required><%=notice.getContent() %></textarea>
            <input type="submit" value="수정하기">
        </form>
    </div>
    <%} else {
		response.sendRedirect("noticeList"); // community 조회 실패 -> 페이지 이동
	}%>
</body>
</html>