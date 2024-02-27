<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 정보 입력</h1>
	<hr>
	<form action="emp_insert.jsp" method="post">
		<table>
			<tr>
				<td>사원번호</td>
				<td>
					<input type="number" name="empno">
				</td>
			</tr>
			<tr>
				<td>사원이름</td>
				<td>
					<input type="text" name="ename">
				</td>
			</tr>
			<tr>
				<td>직급</td>
				<td>
					<select  name="job">
						<option value="CLERK">CLERK</option>
					    <option value="SALESMAN">SALESMAN</option>
                        <option value="ANALYST">ANALYST</option>
                        <option value="MANAGER">MANAGER</option>
                        <option value="PRESIDENT">PRESIDENT</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>메니져</td>
				<td>
					<select  name="mgr">
	                    <option value="7698">BLAKE</option>
	                    <option value="7782">CLARK</option>
	                    <option value="7566">JONES</option>
	                    <option value="7839">KING</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>
					<input type="date" name="hiredate">
				</td>
			</tr>
			<tr>
				<td>급여</td>
				<td>
					<input type="number" name="sal">
				</td>
			</tr>
			<tr>
				<td>커미션</td>
				<td>
					<input type="number" name="comm">
				</td>
			</tr>
			<tr>
				<td>부서명</td>
				<td>
					<select  name="deptno">
	                    <option value="10">ACCOUNTING</option>
	                    <option value="20">RESEARCH</option>
	                    <option value="30">SALES</option>
	                    <option value="40">OPERATIONS</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>