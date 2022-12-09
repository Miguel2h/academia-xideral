<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Pilotos F1</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div class="principal">
		<div id="wrapper">
			<div id="header">
				<h2>Lista de pilotos</h2>
			</div>
		</div>
		<div id="container">

			<div id="content">

				<!-- put new button: Add Piloto -->

				<input type="button" value="Agregar piloto"
					   onclick="window.location.href='add-piloto-form.html'; return false;"
					   class="add-student-button"
				/>

				<table>

					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Correo</th>
						<th>Equipo</th>
						<th>Action</th>
					</tr>

					<c:forEach var="tempPiloto" items="${LISTA_PILOTOS}">

						<!-- set up a link for each student -->
						<c:url var="tempLink" value="PilotoControllerServlet">
							<c:param name="command" value="LOAD" />
							<c:param name="studentId" value="${tempPiloto.id}" />
						</c:url>

						<!--  set up a link to delete a student -->
						<c:url var="deleteLink" value="PilotoControllerServlet">
							<c:param name="command" value="DELETE" />
							<c:param name="studentId" value="${tempPiloto.id}" />
						</c:url>

						<tr>
							<td> ${tempPiloto.firstName} </td>
							<td> ${tempPiloto.lastName} </td>
							<td> ${tempPiloto.email} </td>
							<td> ${tempPiloto.team} </td>
							<td>
								<a href="${tempLink}">Update</a>
								 |
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								Delete</a>
							</td>
						</tr>

					</c:forEach>

				</table>

			</div>

		</div>
	</div>
</body>


</html>








