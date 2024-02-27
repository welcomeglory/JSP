package edu.sejong.ex.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.command.DeptCommand;
import edu.sejong.ex.command.DeptInsertCommand;
import edu.sejong.ex.command.DeptListCommand;
import edu.sejong.ex.command.DeptUpdateCommand;
import edu.sejong.ex.command.DeptdeleteCommand;


/**
 * Servlet implementation class frontController
 */
@WebServlet("/dept/*")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet() ..");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ..");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("actionDo() ..");
				
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		DeptCommand command =null;
		
		
		String uri  = request.getRequestURI();
		String conPath  = request.getContextPath();
		String commandDo  = uri.substring(conPath.length());
		
         System.out.println("uri: "+uri);
		
		System.out.println("conPath: "+conPath);
		
		System.out.println("commandDo: "+commandDo);	
		
		if(commandDo.equals("/dept/list.do")) {
			command = new DeptListCommand();
			command.execute(request,response);
			viewPage = "/dept_mvc_list.jsp";
			
		}else if(commandDo.equals("/dept/insert.do")) {
			command = new DeptInsertCommand();
			command.execute(request,response);
			
			response.setContentType("text/html; charset=UTF-8");
		     PrintWriter writer = response.getWriter();
	                
	        writer.println("유저가 추가되었습니다.");
			viewPage = "/dept/list.do";

			}else if(commandDo.equals("/dept/delete.do")) {
				command = new DeptdeleteCommand();
				command.execute(request,response);
				
				response.setContentType("text/html; charset=UTF-8");
			     PrintWriter writer = response.getWriter();
		                
		        writer.println("유저가 삭제되었습니다.");
				viewPage = "/dept/list.do";

				}
			else if(commandDo.equals("/dept/update.do")) {
				command = new DeptUpdateCommand();
				command.execute(request,response);
				
				response.setContentType("text/html; charset=UTF-8");
			     PrintWriter writer = response.getWriter();
		                
		        writer.println("유저가 갱신되었습니다.");
				viewPage = "/dept/list.do";

				}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);


	}

}
