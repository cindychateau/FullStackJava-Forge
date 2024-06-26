<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="col-6">
			<form action="/registro" method="POST" >
				<h1>Usuario</h1>
				<p class="text-danger text-lg">${error}</p>
				<div>
					<label for="nombreid">Nombre:</label>
					<input type="text" name="nombre" class="form-control" id="nombreid" >
					<p class="text-danger">${errorNombre}</p>
				</div>
				<div>
					<label for="emailid">E-mail:</label>
					<input type="email" name="email" class="form-control" id="emailid" >
					<p class="text-danger">${errorEmail}</p>
				</div>
				<input type="submit" class="btn btn-success mt-3" value="Enviar" >
			</form>
		</div>
	</div>
</body>
</html>