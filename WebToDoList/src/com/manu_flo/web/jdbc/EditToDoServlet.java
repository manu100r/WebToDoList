package com.manu_flo.web.jdbc;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EditToDoServlet
 */
@WebServlet("/EditToDoServlet")
public class EditToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoListDBUtil ToDoListDbUtil;
	
	@Resource(name="jdbc/webtodolist")
	private DataSource dataSource;
	
	int id;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		super.init();
		ToDoListDbUtil = new ToDoListDBUtil(dataSource);
	}
	
	public EditToDoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("ToDoId"));
		ToDo todo= ToDoListDbUtil.fetchtodo(id);
		request.setAttribute("Todo", todo);
		request.getRequestDispatcher("Edit-todo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String description = request.getParameter("description");
		ToDo todo = new ToDo(id, description);
		ToDoListDbUtil.updateTodo(todo);
		response.sendRedirect("ToDoListControllerServlet");
	}
	wfbdbdb
}
