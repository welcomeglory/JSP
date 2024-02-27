<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1></h1>
<table border="1">
<tr>
<td>부서번호</td>
<td>직종이름</td>
<td>지역</td>
</tr>
<c:forEach var="dept" items="${depts}">
<tr>
<td>${dept.deptno}</td>
<td>${dept.dname}</td>
<td>${dept.getLoc()}</td>
</tr>
</c:forEach>	
</table>
	
</body>
</html>