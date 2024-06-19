<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header>
			<h1>¡Bienvenid@ a tu Dashboard!</h1>
			<!-- Boton para crear un nuevo usuario -->
			<a href="/nuevo" class="btn btn-success">Nuevo Usuario</a>
		</header>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Salón</th>
					<th>Hobbies</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario" >
					<tr>
						<td>${usuario.nombre}</td>
						<td>${usuario.apellido}</td>
						<td>${usuario.email}</td>
						<td>${usuario.salon.nombre}</td>
						<td>
							<ul>
								<c:forEach items="${usuario.hobbies}" var="hobby" >
									<li>${hobby.actividad}</li>
								</c:forEach>
							</ul>
						</td>
						<td>
							
							<form action="/borrar/${usuario.id}" method="post" >
							 	<!-- forzamos a que sea solicitud delete -->
								<input type="hidden" name="_method" value="DELETE" >
								<input type="submit" value="Borrar" class="btn btn-danger" >
							</form>
							<a href="/editar/${usuario.id}" class="btn btn-warning" >Editar</a>
							<a href="/asignar/${usuario.id}" class="btn btn-info" >Asignar Hobbies</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>