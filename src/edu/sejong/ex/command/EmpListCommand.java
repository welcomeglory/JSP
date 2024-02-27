package edu.sejong.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.dao.EmpDao;
import edu.sejong.ex.vo.DeptVO;
import edu.sejong.ex.vo.EmpDto;

public class EmpListCommand implements EmpCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		EmpDao dao = new EmpDao();
		List<EmpDto> emps = dao.empList();
		request.setAttribute("emps",emps);

	}

}
