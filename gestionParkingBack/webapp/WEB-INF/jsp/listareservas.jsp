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
	<h2>Listado de reservas</h2>
	<div id="idLista">
	<table class="tablaDatos">
		<caption>Reservas</caption>
		<tr>
			<th>Código</th>
			<th>Fecha</th>
			<th>Propietario</th>
			<th>Plaza Reservada</th>
			<th>Inicio</th>
			<th>Fin</th>
		</tr>
		<c:forEach var="reserva" items="${reservas}">
		<tr>
			<td>${reserva.codigo}</td>
			<td><fmt:formatDate pattern="dd-MM-yyyy" value="${reserva.fecha}" /></td>
			<td>${reserva.propietario.nombre} ${reserva.propietario.apellido1} ${reserva.propietario.apellido2}</td>
			<td>${reserva.plaza.numero}</td>
			<td><fmt:formatDate pattern="dd-MM-yyyy" value="${reserva.inicio}" /></td>
			<td><fmt:formatDate pattern="dd-MM-yyyy" value="${reserva.fin}" /></td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>