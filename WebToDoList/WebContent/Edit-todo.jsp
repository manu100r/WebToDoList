<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/add-todo-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Edit a student</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>TO DO LIST</h2>
</div>
</div>
<div id="container">
<h3> Edit a to do</h3>
<form action="EditToDoServlet" method = "post">
<table>
<tbody>
<tr>
<td><label>Description: </label> </td>
<td><input type="text" name = "Description" value="${ToDo.description}"/></td>
</tr>
<tr>
<td><label></label> </td>
<td><input type="submit" value = "Save"/></td>
</tr>
</tbody>
</table>
</form>
<div style="clear:both;"></div>
<a href="ToDoListControllerServlet">Back to the ToDoList</a>
</div>
</body>
</html>
