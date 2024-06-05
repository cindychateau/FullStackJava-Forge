<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<link rel="stylesheet" href="/css/style.css" >
</head>
<body>
	<h1>${titulo}</h1>
	<ul>
		<!-- 
		listaUsuarios = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo"}
		usuario = "Elena de Troya"
		usuario = "Juana de Arco"
		usuario = "Pablo Picasso"
		usuario = "Pedro Páramo"
		 -->
		<c:forEach items="${listaUsuarios}" var="usuario" >
			<li>${usuario}</li>
		</c:forEach>
	</ul>
	
	<ol>
		<c:forEach items="${paises}" var="pais">
			<li>
				${pais.key} : ${pais.value}
				<c:if test="${pais.key == 'Mexico'}">
					<b>México lindo y querido</b>
				</c:if>
			</li>
		</c:forEach>
	</ol>
	
</body>
</html>