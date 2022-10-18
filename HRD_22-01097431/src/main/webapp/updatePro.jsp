<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	MemberDao memberDao = MemberDao.getInstance();
	int custno = Integer.parseInt(request.getParameter("custno"));
	String custName = request.getParameter("custName");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String joinDate = request.getParameter("joinDate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	
	if(custName != null && phone != null && address != null && joinDate != null && grade != null && city != null) {
		memberDao.updateMember(new MemberDto(custno, custName, phone, address, joinDate, grade, city));
		
		response.sendRedirect("list.jsp");
	} else {
		response.sendRedirect("update.jsp");
	}
	%>
</body>
</html>