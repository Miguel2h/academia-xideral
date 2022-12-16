<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de pilotos</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

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
				
				<!-- loop over and print our pilotos -->
				<c:forEach var="tempPiloto" items="${pilotos}">
				
					<!-- construct an "update" link with piloto id -->
					<c:url var="enlaceActualizar" value="/piloto/mostrarFormularioActualizar">
						<c:param name="pilotoId" value="${tempPiloto.id}" />
					</c:url>					

					<!-- construct an "delete" link with piloto id -->
					<c:url var="enlaceEliminar" value="/piloto/eliminar">
						<c:param name="pilotoId" value="${tempPiloto.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPiloto.nombre} </td>
						<td> ${tempPiloto.apellido} </td>
						<td> ${tempPiloto.correo} </td>
						<td> ${tempPiloto.equipo} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${enlaceActualizar}">Actualizar</a>
							|
							<a href="${enlaceEliminar}"
							   onclick="if (!(confirm('Are you sure you want to delete this piloto?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









