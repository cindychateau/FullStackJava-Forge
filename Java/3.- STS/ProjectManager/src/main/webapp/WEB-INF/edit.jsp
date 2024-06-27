<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Project</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="/projects/update" method="post" modelAttribute="project" >
			<h1>Edit Project</h1>
			<div>
				<form:label path="title">Project Title:</form:label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div>
				<form:label path="description">Project Description:</form:label>
				<form:textarea path="description" class="form-control" ></form:textarea>
				<form:errors path="description" class="text-danger" />
			</div>
			<div>
				<form:label path="dueDate">Due Date:</form:label>
				<form:input type="date" path="dueDate" class="form-control" />
				<form:errors path="dueDate" class="text-danger" />
			</div>
			<form:hidden path="lead" value="${userInSession.id}" />
			<form:hidden path="id" value="${project.id}" />
			<input type="hidden" value="put" name="_method" >
			
			<input type="submit" class="btn btn-success" value="Submit" >
			<a href="/dashboard" class="btn btn-danger" >Cancel</a>
		</form:form>
	</div>
</body>
</html>