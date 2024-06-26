<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Evento</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- Detalles del evento -->
			<div class="col-6">
				<h1>${event.eventName}</h1>
				<p>
					<b>Host:</b>${event.host.firstName}
				</p>
				<p>
					<b>Date:</b>${event.eventDate}
				</p>
				<p>
					<b>Location:</b>${event.eventLocation}, ${event.eventProvince}
				</p>
				<p>
					<b>People who are attending this event:</b>${event.joinedUsers.size()}
				</p>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${event.joinedUsers}" var="user">
							<tr>
								<td>${user.firstName}</td>
								<td>${user.location}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- Muro de Mensajes -->
			<div class="col-6">
				<h2>Message Wall</h2>
				<div class="border mb-3">
					<!-- mostrar mensajes -->
					<c:forEach items="${event.eventMessages}" var="msg">
						<p>
							${msg.author.firstName} says: ${msg.content}
						</p>
					</c:forEach>
				</div>
				
				<form:form action="/create_message" method="post" modelAttribute="message">
					<form:errors path="content" class="text-danger" />
					<form:label path="content">Add Comment:</form:label>
					<form:textarea path="content" class="form-control"></form:textarea>
					<form:hidden path="author" value="${userInSession.id}" />
					<form:hidden path="event" value="${event.id}" />
					<input type="submit" value="submit" class="btn btn-info" >
				</form:form>
				
			</div>
		</div>
	</div>
</body>
</html>