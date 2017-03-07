<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"/>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"/>
	<h2>Listado de plazas</h2>
	<div id="idLista">
	<table class="tablaDatos">
		<caption>Plazas</caption>
		<tr>
			<th>Número</th>
			<th>Planta</th>
			<th>Dimensiones</th>
			<th>Bloqueada</th>
			<th>Observaciones</th>
			
		</tr>
		<c:forEach var="plaza" items="${plazas}">
		<tr>
			<td>${plaza.numero}</td>
			<td>${plaza.planta}</td>
			<td>${plaza.largo} x ${plaza.ancho}</td>
			<td>${plaza.bloqueada}</td>
			<td>${plaza.observaciones}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>