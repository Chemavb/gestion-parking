<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/templates/head.jsp"/>
</head>
<body>
	<jsp:include page="/WEB-INF/templates/header.jsp"/>
	<h2>Alta de propietario</h2>
	<form action="pruebas/altapropietario" method="GET">
		<div  id="idIzquierda" style="float: left; margin-right: 20px">
		<table> 
		<caption>Datos del Propietario</caption>
			<tr>
				<td>DNI</td>
				<td><input type="text" name="p1"/></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="p2"/></td>
			</tr>
			<tr>
				<td>Primer Apellido</td>
				<td><input type="text" name="p3"/></td>
			</tr>
			<tr>
				<td>Segundo Apellido</td>
				<td><input type="text" name="p4"/></td>
			</tr>
			<tr>
				<td>Dirección</td>
				<td><input type="text" name="p5"/></td>
			</tr>
			<tr>
				<td>Número</td>
				<td><input type="text" name="p6"/></td>
			</tr>
			<tr>
				<td>Planta</td>
				<td><input type="text" name="p7"/></td>
			</tr>
			<tr>
				<td>Puerta</td>
				<td><input type="text" name="p8"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="p9"/></td>
			</tr>
			<tr>
				<td>Teléfono fijo</td>
				<td><input type="text" name="p10"/></td>
			</tr>
			<tr>
				<td>Teléfono móvil</td>
				<td><input type="text" name="p11"/></td>
			</tr>
		</table>
		</div>
		<div id="idDerecha">
		<table> 
		<caption>Datos de la Plaza</caption>
			<tr>
				<td>Número de plaza</td>
				<td><input type="text" name="p12"/></td>
			</tr>
			<tr>
				<td>Planta</td>
				<td>
					<select name="p13">
						<option>SOTANO_1</option>
						<option>SOTANO_2</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Largo</td>
				<td><input type="text" name="p14"/></td>
			</tr>
			<tr>
				<td>Ancho</td>
				<td><input type="text" name="p15"/></td>
			</tr>
			<tr>
				<td>Bloqueada</td>
				<td><input type="checkbox" name="p16"/></td>
			</tr>
			<tr>
				<td>Observaciones</td>
				<td><input type="text" name="p17"/></td>
			</tr>
		</table>
		<input type="submit" value="ALTA"/>
		</div>
	</form>
</body>
</html>