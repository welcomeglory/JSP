package edu.sejong.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.DeptDao;
import edu.sejong.ex.vo.DeptVO;



public class DeptListCommand implements DeptCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		DeptDao dao = new DeptDao();
		List<DeptVO> depts = dao.deptList();
		System.out.println(depts.size());
		request.setAttribute("depts",depts);
	}
}
