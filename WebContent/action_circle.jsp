<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>원 넓이 계산</title>
</head>
<body>
<h1>액션태그 예제입니다.</h1>
<%   double radius = Double.valueOf(request.getParameter("radius")); 
System.out.println(radius);


%>

<jsp:useBean id="circle" class="edu.sejong.ex.Circle"/>
<jsp:setProperty property="r" name="circle"     value="<%=radius %>" />

반지름:<jsp:getProperty property="r" name="circle"/><br/>
넓이:<jsp:getProperty property="area" name="circle"/>
        
        
</body>
</html>
