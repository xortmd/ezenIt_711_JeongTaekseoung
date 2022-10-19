<%@page import="user.UserDto"%>
<%@page import="user.UserDao"%>
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
	request.setCharacterEncoding("UFT-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	UserDao userDao = UserDao.getInstance();
	UserDto user = userDao.getUser(id);
	
	if(user != null && password.equals(user.getPassword())) {
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>