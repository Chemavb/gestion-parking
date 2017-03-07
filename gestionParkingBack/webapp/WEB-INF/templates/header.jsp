<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="idHeader">
	<h1>Gestión Parking</h1>
	<div id="idNav">
		<nav>
			<ul>
				<li><a href="${contextPath}/index.jsp">Indice</a></li>
				<li><a href="${contextPath}/altapropietario.jsp">Alta de propietarios</a></li>
				<li><a href="${contextPath}/pruebas/reserva_alta">Realizar una reserva</a></li>
				<li><a href="${contextPath}/pruebas/propietarios">Listado de propietarios</a></li>
			    <li><a href="${contextPath}/pruebas/plazas">Listado de plazas</a></li>
				<li><a href="${contextPath}/pruebas/reservas">Listado de reservas</a></li>
			</ul>
		</nav>
	</div>
</div>