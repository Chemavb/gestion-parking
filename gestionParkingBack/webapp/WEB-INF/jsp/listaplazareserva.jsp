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
	<form action="realizar_reserva" method="GET">
	<table class="tablaDatos">
		<caption>Plazas</caption>
		<tr>
			<th>Número</th>
			<th>Planta</th>
			<th>Dimensiones</th>
			<th>Bloqueada</th>
			<th>Observaciones</th>
			
		</tr>
		<c:forEach var="plaza" items="${plazas2}">
		<tr>
			<td>${plaza2.numero}</td>
			<td>${plaza2.planta}</td>
			<td>${plaza2.largo} x ${plaza.ancho}</td>
			<td>${plaza2.bloqueada}</td>
			<td>${plaza2.observaciones}</td>
			<td>
			<input name="plaza" type="hidden" value="${plaza2.numero}"/>
			<input name="DNI" type="hidden" value="${DNI}"/>
			<input name="inicio" type="hidden" value="${inicio}"/>
			<input name="fin" type="hidden" value="${fin}"/>
			<input type="submit" value="RESERVAR" />
			</td>
		</tr>
		</c:forEach>
	</table>
	</form>
	</div>
</body>
</html>