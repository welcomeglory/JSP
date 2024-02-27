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
	Connection connection;
    Statement statement;
    ResultSet rs;
    
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url =  "jdbc:oracle:thin:@//localhost:1521/xe";
    String id = "scott";
    String pw = "tiger";    
    
    String sql = "select * from emp";
    
    try{
    	Class.forName(driver);
    	connection = DriverManager.getConnection(url,id,pw);
    	statement = connection.createStatement();
    	rs = statement.executeQuery(sql);
    	
    	while(rs.next()){
    		int empno = rs.getInt("empno");
    		String ename = rs.getString("ename");
    		String job = rs.getString("job");
    		String mgr = rs.getString("mgr");
    		String hiredate = rs.getString("hiredate");
    		//Timestamp hiredate2 = rs.getTimestamp("hiredate");
    		
    		
    		out.println("사원번호" + empno + "이름:" + ename + " 부서이름:" + job + " 메니져" + mgr + "<br>"); 
    		
    	}  	
    	
    	
    }catch(Exception e){
    	
    }
    
%>
</body>
</html>