package com.manu_flo.web.jdbc;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AddToDoServlet
 */
@WebServlet("/AddToDoServlet")
public class AddToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ToDoListDBUtil ToDoListDbUtil;
	
	@Resource(name="jdbc/webtodolist")
	private DataSource dataSource;
	
	public void init() throws ServletException {
		super.init();
		ToDoListDbUtil = new ToDoListDBUtil(dataSource);
	}
	
	public AddToDoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("Add-todo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String description = request.getParameter("description");
		ToDo todo = new ToDo(description);
		ToDoListDbUtil.updateTodo(todo);
		response.sendRedirect("ToDoListControllerServlet");
	}

}
