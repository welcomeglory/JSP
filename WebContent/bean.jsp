<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
        <h1>Bean 액션태그 예제입니다.</h1>
       
        <jsp:setProperty property="name" name="student" value="홍길동"/>
        이름:<jsp:getProperty property="name" name="student"/>
        
</body>
</html>
