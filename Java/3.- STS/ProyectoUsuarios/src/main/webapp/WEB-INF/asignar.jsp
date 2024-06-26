<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asignar Hobbies</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Asignar hobbies a: ${usuario.nombre} </h1>
		<h2>Hobbies</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Actividad</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hobbies}" var="hobby" >
					<tr>
						<td>${hobby.actividad}</td>
						<td>
							
							<c:if test="${ usuario.hobbies.contains(hobby) }" >
								<a href="/quitarHobby/${usuario.id}/${hobby.id}" class="btn btn-danger">Quitar Hobby</a>
							</c:if>
							
							<c:if test="${not usuario.hobbies.contains(hobby) }" >
								<a class="btn btn-info" href="/asignarHobby/${usuario.id}/${hobby.id}" >Asignar Hobby</a>
							</c:if>
							
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>