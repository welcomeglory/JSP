<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>성적산출</title>
</head>
<body>
<%   
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
double kor = Double.valueOf(request.getParameter("kor")); 
double eng = Double.valueOf(request.getParameter("eng")); 
double math = Double.valueOf(request.getParameter("math")); 
%>

<jsp:useBean id="grade" class="edu.sejong.ex.grade"/>
<jsp:setProperty property="name" name="grade"     value="<%=name %>" />
<jsp:setProperty property="kor" name="grade"     value="<%=kor %>" />
<jsp:setProperty property="eng" name="grade"     value="<%=eng %>" />
<jsp:setProperty property="math" name="grade"     value="<%=math %>" />

<h2>
이름: <jsp:getProperty property="name" name="grade"/><br/>
총점: <jsp:getProperty property="sum" name="grade"/><br/>
평균: <jsp:getProperty property="avg" name="grade"/><br/>
<jsp:getProperty property="grades" name="grade"/></h2>
      
        
</body>
</html>
