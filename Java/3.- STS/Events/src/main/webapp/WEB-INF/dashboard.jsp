<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between">
			<h1>Welcome ${userInSession.firstName} !</h1>
			<a class="btn btn-danger" href="/logout" >Log out</a>
		</header>
		<div class="row">
			<h2>Events in my province</h2>
			<!-- PEND -->
		</div>
		<div class="row">
			<h2>Events in other provinces</h2>
			<!-- PEND -->
		</div>
		<div class="row">
			<form:form action="/create_event" method="post" modelAttribute="newEvent" >
				<div>
					<form:label path="eventName">Event Name:</form:label>
					<form:input path="eventName" class="form-control" />
					<form:errors path="eventName" class="text-danger" />
				</div>
				<div>
					<form:label path="eventDate">Event Date:</form:label>
					<form:input path="eventDate" class="form-control" type="date" />
					<form:errors path="eventDate" class="text-danger" />
				</div>
				<div>
					<form:label path="eventLocation">Location:</form:label>
					<form:input path="eventLocation" class="form-control" />
					<form:errors path="eventLocation" class="text-danger" />
				</div>
				<div>
					<form:label path="eventProvince">Province:</form:label>
					<form:select path="eventProvince" class="form-select">
						<c:forEach items="${provinces}" var="province">
							<form:option value="${province}">${province}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<form:hidden value="${userInSession.id}" path="host" />
				<input type="submit" class="btn btn-success mt-3" value="Save" >
			</form:form>
		</div>
	</div>
</body>
</html>