<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.sejong.ex.dao.EmpDao"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="edu.sejong.ex.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejong.ex.dao.DeptDao"%>
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
<%
	EmpDao empDao = new EmpDao();
	
	List<EmpDto> dtos = empDao.empList();

	for(EmpDto emp : dtos){
		out.print(emp+"<br>");
	}
%>
</body>
</html>