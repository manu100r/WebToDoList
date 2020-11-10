package com.manu_flo.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ToDoListDBUtil {
	
	private DataSource dataSource;
	
	public ToDoListDBUtil(DataSource theDataSource) {
	dataSource = theDataSource;
	}
	
	public List<ToDo> getToDos() throws Exception {
		List<ToDo> todolist= new ArrayList<ToDo>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "SELECT * FROM todo ORDER BY id";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				int id = myRs.getInt("id");
				String description=myRs.getString("description");
				ToDo tempToDo= new ToDo(id, description);
				todolist.add(tempToDo);
			}
			return todolist;
		} finally{
			close(myConn,myStmt,myRs);
			}
	}
	
	public ToDo fetchtodo(int id) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		ToDo todo = null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql = "SELECT * FROM todo WHERE id = "+id;
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				String description=myRs.getString("description");
				todo = new ToDo(id,description);
			}
			return todo;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		} finally{
			close(myConn,myStmt,myRs);
			}
		}
	
	public void updateTodo(ToDo todo) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "UPDATE todo SET description=? WHERE id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, todo.getDescription());
			myStmt.setInt(2,todo.getId());
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
			if(myConn!=null)
				myConn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
}
