<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Juego Ninja Gold</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Tu puntuación: ${oro} </h1>
		<div class="row">
			<div class="col-3 border text-center">
				<h2>Granja</h2>
				<p>Ganas 10 - 20 monedas</p>
				<form action="/buscar" method="post">
					<input type="hidden" name="lugar" value="granja" >
					<input type="submit" class="btn btn-success" value="¡Buscar Oro!">
				</form>
			</div>
			<div class="col-3 border text-center">
				<h2>Cueva</h2>
				<p>Ganas 5 - 10 monedas</p>
				<form action="/buscar" method="post">
					<input type="hidden" name="lugar" value="cueva" >
					<input type="submit" class="btn btn-info" value="¡Buscar Oro!">
				</form>
			</div>
			<div class="col-3 border text-center">
				<h2>Casa</h2>
				<p>Ganas 2 - 5 monedas</p>
				<form action="/buscar" method="post">
					<input type="hidden" name="lugar" value="casa" >
					<input type="submit" class="btn btn-primary" value="¡Buscar Oro!">
				</form>
			</div>
			<div class="col-3 border text-center">
				<h2>Casino</h2>
				<p>Ganas/Pierdes 0 - 50 monedas</p>
				<form action="/buscar" method="post">
					<input type="hidden" name="lugar" value="casino" >
					<input type="submit" class="btn btn-warning" value="¡Buscar Oro!">
				</form>
			</div>
		</div>
		<div class="row">
			<div class="card">
				<c:forEach items="${actividades}" var="actividad">
					
					<c:if test="${actividad.contains('ganaste')}">
						<p class="text-success">${actividad}</p>
					</c:if>
					
					<c:if test="${actividad.contains('perdiste')}">
						<p class="text-danger">${actividad}</p>
					</c:if>
					
					
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>