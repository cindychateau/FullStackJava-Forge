<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center ">
			<h1>Welcome ${userInSession.firstName} !</h1>
			<a class="btn btn-success" href="/projects/new">New Project</a>
			<a class="btn btn-danger" href="/logout" >Log out</a>
		</header>
		<div class="row">
			<h2>All Projects</h2>
			<!-- Proyectos a los que NO SE HA UNIDO mi usuario -->
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${otherProjects}" var="project" >
						<tr>
							<td>${project.title}</td>
							<td>${project.lead.firstName}</td>
							<td>${project.dueDate}</td>
							<td>
								<a href="/projects/join/${project.id}" class="btn btn-primary">Join team</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<h2>Your Projects</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${myProjects}" var="project">
						<tr>
							<td>${project.title}</td>
							<td>${project.lead.firstName}</td>
							<td>${project.dueDate}</td>
							<td>
								<c:if test="${userInSession.id == project.lead.id}" >
									<!-- Usuario en sesión es el líder -->
									<a href="/projects/edit/${project.id}" class="btn btn-warning">Edit</a>
								</c:if>
								
								<c:if test="${userInSession.id != project.lead.id}" >
									<a href="/projects/leave/${project.id}" class="btn btn-danger" >Leave team</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>