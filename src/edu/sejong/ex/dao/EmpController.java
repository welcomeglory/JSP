package edu.sejong.ex.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.command.EmpCommand;
import edu.sejong.ex.command.EmpListCommand;


/**
 * Servlet implementation class frontController
 */
@WebServlet("/emp/*")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpController() {
        super();
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
		EmpCommand command =null;
		
		
		String uri  = request.getRequestURI();
		String conPath  = request.getContextPath();
		String commandDo  = uri.substring(conPath.length());
		
         System.out.println("uri: "+uri);
		
		System.out.println("conPath: "+conPath);
		
		System.out.println("commandDo: "+commandDo);	
		
		if(commandDo.equals("/emp/list.do")) {
			
			command = new EmpListCommand();
			command.execute(request,response);
			
			viewPage = "/emp_mvc_list.jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);


	}

}
