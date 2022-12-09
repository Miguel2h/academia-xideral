<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Pilotos F1</title>
	
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
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Equipo</th>
					<th>Accion</th>
				</tr>
				
				<!-- loop over and print our pilotos -->
				<c:forEach var="tempPiloto" items="${pilotos}">
				
					<!-- construct an "update" link with piloto id -->
					<c:url var="updateLink" value="/piloto/showFormForUpdate">
						<c:param name="pilotoId" value="${tempPiloto.id}" />
					</c:url>					

					<!-- construct an "delete" link with piloto id -->
					<c:url var="deleteLink" value="/piloto/delete">
						<c:param name="pilotoId" value="${tempPiloto.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPiloto.firstName} </td>
						<td> ${tempPiloto.lastName} </td>
						<td> ${tempPiloto.email} </td>
						<td> ${tempPiloto.team} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this piloto?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









