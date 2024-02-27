<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection connection;
    Statement statement;
    ResultSet rs;
    
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url =  "jdbc:oracle:thin:@//localhost:1521/xe";
    String id = "scott";
    String pw = "tiger";    
    
    String sql = "select * from dept";
    
    try{
    	Class.forName(driver);
    	connection = DriverManager.getConnection(url,id,pw);
    	statement = connection.createStatement();
    	rs = statement.executeQuery(sql);
    	
    	while(rs.next()){
    		String deptno = rs.getString("deptno");
    		String dname = rs.getString("dname");
    		String loc = rs.getString("loc");
    		
    		out.println("부서번호:" + deptno + " 부서이름:" + dname + " 위치:" + loc + "<br>"); 
    		
    	}  	
    	
    	
    }catch(Exception e){
    	
    }
    
%>
</body>
</html>