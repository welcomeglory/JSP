package edu.sejong.ex.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpDeptDto;
import edu.sejong.ex.vo.EmpDto;


public class EmpDao {
   
   //커넥션 풀 객체
   private DataSource dataSource = null;

   public EmpDao() {
      try {
         Context context = new InitialContext();
         dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public List<EmpDto> empList(){
      List<EmpDto> emps = new ArrayList<>();
      
      Connection con=null;
      Statement stmt=null;
      ResultSet rs=null;
      
      String sql = "select * from emp";
      
      try {
   
          con = dataSource.getConnection();
          stmt = con.createStatement();
          rs = stmt.executeQuery(sql);
         
            while(rs.next()){
             
               int empno = rs.getInt("empno");
             String ename = rs.getString("ename");
             String job = rs.getString("job");
             
             int mgr = rs.getInt("mgr");
             
             String hiredate = rs.getString("hiredate");
             int sal = rs.getInt("sal");
             int comm = rs.getInt("comm");
             int deptno = rs.getInt("deptno");
             
             EmpDto dto = new EmpDto(empno, ename,  job, mgr, hiredate, sal, comm,deptno);
          
             emps.add(dto);
          }     
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         
         try {
               if(rs != null)
                  rs.close();
               
               if(stmt != null)
                  stmt.close();
      
               if(con != null)
                  con.close();      
               
         } catch (Exception e2) {
            e2.printStackTrace();
         }
         
      }
      
      return emps;
   }

	public List<EmpDeptDto> empDeptList(){
		List<EmpDeptDto> emps = new ArrayList<>();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql = "select * from emp, dept where emp.deptno = dept.deptno ";
		
		try {
	
	    	con = dataSource.getConnection();
	    	stmt = con.createStatement();
	    	rs = stmt.executeQuery(sql);
			
	      	while(rs.next()){
	    		
	      		int empno = rs.getInt("empno");
	    		String ename = rs.getString("ename");
	    		String job = rs.getString("job");	    		
	    		int mgr = rs.getInt("mgr");	    		
	    		String hiredate = rs.getString("hiredate");
	    		int sal = rs.getInt("sal");
	    		String comm = rs.getString("comm");
	    		int deptno = rs.getInt("deptno");
	    		
	    		DeptVO deptVo = new DeptVO();
	    		deptVo.setDeptno(deptno);
	    		deptVo.setDname(rs.getString("dname"));
	    		deptVo.setLoc(rs.getString("loc"));
	    		
	    		
	    		EmpDeptDto dto = new EmpDeptDto(empno, ename,  job, mgr, hiredate, sal, deptno, deptVo);
	    	
	    		emps.add(dto);
	    	}  	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
					if(rs != null)
						rs.close();
					
					if(stmt != null)
						stmt.close();
		
					if(con != null)
						con.close();		
					
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return emps;
	}
   //자바 1.7 이상 일때
   public List<EmpDto> empList2(){
      List<EmpDto> emps = new ArrayList<>();   
      
      String sql = "select * from emp";
      //Try-with-resources
      try(Connection con =  dataSource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            ) {
         
            while(rs.next()){
             
               int empno = rs.getInt("empno");
             String ename = rs.getString("ename");
             String job = rs.getString("job");
             
             int mgr = rs.getInt("mgr");
             
             String hiredate = rs.getString("hiredate");
             int sal = rs.getInt("sal");
             int comm = rs.getInt("comm");
             int deptno = rs.getInt("deptno");
             
             EmpDto dto = new EmpDto(empno, ename,  job, mgr, hiredate, sal, comm,deptno);
          
             emps.add(dto);
          }     
         
      } catch (Exception e) {
         e.printStackTrace();
      } 
      
      return emps;
   }
   
   public String getHtml() {
      String html = "";
      List<EmpDto> emps = empList();
      
      for (EmpDto emp : emps) {
         html  = html + emp.toString() + "<br>";
      }
      
      return html;
   }
   
   //자바 1.11 이상 일때
//      public List<EmpDto> empList3(){
//         List<EmpDto> emps = new ArrayList<>();   
//         
//         String sql = "select * from emp";
//         //Try-with-resources
//         Connection con =  DriverManager.getConnection(url,id,pw);
//         Statement stmt = con.createStatement();
//         ResultSet rs=stmt.executeQuery(sql);
//         
//         try(con; stmt; rs) {
//            
//               while(rs.next()){
//                
//                  int empno = rs.getInt("empno");
//                String ename = rs.getString("ename");
//                String job = rs.getString("job");
//                
//                int mgr = rs.getInt("mgr");
//                
//                String hiredate = rs.getString("hiredate");
//                int sal = rs.getInt("sal");
//                String comm = rs.getString("comm");
//                int deptno = rs.getInt("deptno");
//                
//                EmpDto dto = new EmpDto(empno, ename,  job, mgr, hiredate, sal, deptno);
//             
//                emps.add(dto);
//             }     
//            
//         } catch (Exception e) {
//            e.printStackTrace();
//         } 
//         
//         return emps;
//      }

   public int insert(EmpDto emp){
         
      Connection con=null;
      PreparedStatement pstmt=null;
      int row = 0;
      
      String sql = "insert into emp (empno, ename , deptno, job)"
                         + " values (?,?,?,?)";
      
      try {
   
          con = dataSource.getConnection();
          pstmt = con.prepareStatement(sql);
          
          pstmt.setInt(1, emp.getEmpno());
          pstmt.setString(2, emp.getEname());
          pstmt.setInt(3, emp.getDeptno());
          pstmt.setString(4, emp.getJob());
          
          row = pstmt.executeUpdate();         
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         
         try {
            
               if(pstmt != null)
                  pstmt.close();
      
               if(con != null)
                  con.close();      
               
         } catch (Exception e2) {
            e2.printStackTrace();
         }
         
      }
      
      return row;
   }
   

}