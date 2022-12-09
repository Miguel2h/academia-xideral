<!DOCTYPE html>
<html>

<head>
	<title>Actualizar piloto</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Pilotos F1</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar pilotos</h3>
		
		<form action="PilotoControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="pilotoId" value="${THE_PILOTO.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="firstName" 
								   value="${THE_PILOTO.firstName}" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_PILOTO.lastName}" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><input type="text" name="email"
								   value="${THE_PILOTO.email}" /></td>
					</tr>

					<tr>
						<td><label>Equipo:</label></td>
						<td><input type="text" name="team"
								   value="${THE_PILOTO.team}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="PilotoControllerServlet">Volver a la lista</a>
		</p>
	</div>
</body>

</html>











