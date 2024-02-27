<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="empDao" class="edu.sejong.ex.dao.EmpDao"/>
	<jsp:getProperty name="empDao" property="html" /><br />
</body>
</html>