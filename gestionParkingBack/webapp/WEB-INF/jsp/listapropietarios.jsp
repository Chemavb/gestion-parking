<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"/>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"/>
	<h2>Listado de propietarios</h2>
	<div id="idLista">
	<table class="tablaDatos">
		<caption>Propietarios</caption>
		<tr>
			<th>DNI</th>
			<th>Propietario</th>
			<th>Dirección</th>
			<th>Email</th>
			<th>Tel. fijo</th>
			<th>Tel. móvil</th>
			<th>Número de plaza</th>
			<th>Planta</th>
			<th>Bloqueada</th>
			<th>Dimensiones</th>
			<th>Observaciones</th>
		</tr>
		<c:forEach var="propietario" items="${propietarios}">
		<tr>
			<td>${propietario.DNI}</td>
			<td>${propietario.nombre} ${propietario.apellido1} ${propietario.apellido2}</td>
			<td>${propietario.direccion} ${propietario.numero} ${propietario.planta} ${propietario.puerta}</td>
			<td>${propietario.email}</td>
			<td>${propietario.telefonoFijo}</td>
			<td>${propietario.telefonoMovil}</td>
			<td>${propietario.plaza.numero}</td>
			<td>${propietario.plaza.planta}</td>
			<td>${propietario.plaza.bloqueada}</td>
			<td>${propietario.plaza.largo} x ${propietario.plaza.ancho}</td>
			<td>${propietario.plaza.observaciones}</td>
			<td>
			<form action="borrarpropietario" method="GET">
			<input type=image value="${propietario.DNI}" alt="Submit" name="prop" height="25" width="25" src="http://www.clker.com/cliparts/8/3/3/4/1195445190322000997molumen_red_round_error_warning_icon.svg.med.png"/>
			</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>