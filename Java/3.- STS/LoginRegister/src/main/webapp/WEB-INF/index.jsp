<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register and Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>Register</h2>
				<!-- Generar una instancia -->
				<form:form action="/register" method="POST" modelAttribute="newUser" >
					<div>
						<form:label path="firstName" >First Name:</form:label>
						<form:input path="firstName" class="form-control" />
						<form:errors path="firstName" class="text-danger" />
					</div>
					<div>
						<form:label path="lastName" >Last Name:</form:label>
						<form:input path="lastName" class="form-control" />
						<form:errors path="lastName" class="text-danger" />
					</div>
					<div>
						<form:label path="email" >E-mail:</form:label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div>
						<form:label path="password" >Password:</form:label>
						<form:password path="password" class="form-control" />
						<form:errors path="password" class="text-danger"/>
					</div>
					<div>
						<form:label path="confirm" >Conf. Password:</form:label>
						<form:password path="confirm" class="form-control" />
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<input type="submit" class="btn btn-primary" value="Register" >
				</form:form>
			</div>
			<div class="col-6">
				<h2>Login</h2>
				<p class="text-danger">${errorLogin}</p>
				<form action="/login" method="POST">
					<div>
						<label>E-mail:</label>
						<input type="email" class="form-control" name="email" >
					</div>
					<div>
						<label>Password:</label>
						<input type="password" class="form-control" name="password" >
					</div>
					<input type="submit" class="btn btn-info mt-3" value="Login" >
				</form>
			</div>
		</div>
	</div>
</body>
</html>