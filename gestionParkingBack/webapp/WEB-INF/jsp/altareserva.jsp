<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/templates/header.jsp"/>
	<h2>Alta de reserva</h2>
	<form action="listaplazasreserva" method="GET">
		<div  id="idIzquierda" style="float: left; margin-right: 20px">
			<table>
				<tr>
					<td>Propietario</td>
					<td>
					<select name="DNI">
					<c:forEach var="propietario" items="${propietarios}">
					<option value="${propietario.DNI}">${propietario.nombre} ${propietario.apellido1} ${propietario.apellido2}</option>
					</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>Fecha Inicio</td>
					<td><input type="date" name="inicio"/></td>
				</tr>
				<tr>
					<td>Fecha Fin</td>
					<td><input type="date" name="fin"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="ACEPTAR"/></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>