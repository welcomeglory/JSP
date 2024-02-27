package edu.sejong.ex.vo;
//이름     널?       유형           
//-------- -------- ------------ 
//EMPNO    NOT NULL NUMBER(4)    
//ENAME             VARCHAR2(10) 
//JOB               VARCHAR2(9)  
//MGR               NUMBER(4)    
//HIREDATE          DATE         
//SAL               NUMBER(7,2)  
//COMM              NUMBER(7,2)  
//DEPTNO            NUMBER(2) 
public class EmpDto {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	
	public EmpDto() {
		
	}	

	public EmpDto(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno ) {
		this.empno =empno;
		this.ename =ename;
		this.job=job;
		this.mgr=mgr;
		this.hiredate=hiredate;
		this.sal=sal;
		this.comm=comm;
		this.deptno=deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getImage() {
		return (int)(Math.random() *6) + 1;
	}

	@Override
	public String toString() {
		return "부서번호 : " + getEmpno() +
	            ", 부서명 : " + getEname() + 
	            ", 지역 : " + getJob() +
	            ", 매니저번호 :"+getMgr()+
	            ", 입사일 :"+getHiredate()+
	            ", 임금 :"+getSal()+
	            ", 상여 :"+getComm()+
	            ", 부서번호 :"+getDeptno();
	}

}
