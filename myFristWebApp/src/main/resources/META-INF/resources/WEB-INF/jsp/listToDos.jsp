
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
		<h1>your Todos</h1>
		<table class="table">
			<thead>
				<tr>
			<%-- 		<th>id</th>		 --%>
			<th>Description</th>
			<th>Target Date</th>
			<th>is Done?</th>
			<th></th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
		<%--	<td>${todo.id}</td>		 --%>
				<td>${todo.description}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
				<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete </a></td>
				<td><a href="update-todo?id=${todo.id}" class="btn btn-Success">Update </a></td>
				<td>
   <a href="complete-todo?id=${todo.id}" class="btn btn-info"
      onclick="return confirm('Mark this task as complete?')">Complete</a>
</td>
				
				
			</tr>
		</c:forEach>
			</tbody>
		</table>

<a href="add-todo" class="btn btn-success">Add Todo</a>

	</div>

<%@ include file="common/footer.jspf" %>




















