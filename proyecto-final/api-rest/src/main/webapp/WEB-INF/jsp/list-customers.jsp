<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset=UTF-8">
	<title>Lista de pilotos</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Pilotos F1</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar piloto"
				   onclick="window.location.href='mostrarFormularioAnadir'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Equipo</th>
					<th>Tarea</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPilotos" items="${pilotos}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="enlaceActualizar" value="/mvc/mostrarFormularioActualizar">
						<c:param name="pilotoId" value="${tempPilotos.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="enlaceEliminar" value="/mvc/delete">
						<c:param name="pilotoId" value="${tempPilotos.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPilotos.nombre} </td>
						<td> ${tempPilotos.apellido} </td>
						<td> ${tempPilotos.correo} </td>
						<td> ${tempPilotos.equipo} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${enlaceActualizar}">Actualizar</a>
							|
							<a href="${enlaceEliminar}"
							   onclick="if (!(confirm('Estas seguro que quieres eliminar al piloto'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









