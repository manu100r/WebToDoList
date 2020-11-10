<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Web To Do List</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<!-- ${TODO_LIST}-->
		<div id="wrapper">
			<div id="header">
				<h2>TO DO LIST</h2>
				<c:url var="AddLink" value= "AddToDoServlet">
				<c:param name="ToDoId" value="${todo.id}"/>
				</c:url>
				<a href="${AddLink }"> Add</a>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>id </th>
						<th>Description</th>
						<th>Edit </th>
						<th>Delete</th>
					</tr>
					<c:forEach var="todo" items="${TODO_LIST }" >
						<c:url var="EditLink" value= "EditToDoServlet">
						<c:param name="ToDoId" value="${todo.id}"/>
						</c:url>
						<c:url var="DeleteLink" value= "DeleteToDoServlet">
						<c:param name="ToDoId" value="${todo.id}"/>
						</c:url>
						<tr>
							<td> ${todo.id}</td>
							<td> ${todo.description}</td>
							<td> <a href="${EditLink }"> Edit</a></td>
							<td> <a href="${DeleteLink }"> Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>