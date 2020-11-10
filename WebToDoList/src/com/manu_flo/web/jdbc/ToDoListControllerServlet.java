package com.manu_flo.web.jdbc;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ToDoListControllerServlet
 */
@WebServlet("/ToDoListControllerServlet")
public class ToDoListControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ToDoListDBUtil ToDoListDbUtil;
	@Resource(name="jdbc/webtodolist")
	private DataSource dataSource;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listToDo(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listToDo(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		List<ToDo> todolist = ToDoListDbUtil.getToDos();
		request.setAttribute("TODO_LIST", todolist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ToDo-List.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ToDoListDbUtil = new ToDoListDBUtil(dataSource);
	}
}
