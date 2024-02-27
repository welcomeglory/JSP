<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="edu.sejong.ex.dao.EmpDao"%>
<%@page import="edu.sejong.ex.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejong.ex.dao.DeptDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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

List<EmpDto> etos = empDao.empList();
for(EmpDto evo : etos){
		out.print(evo+"<br>");
	}

%>
</body>
</html>


