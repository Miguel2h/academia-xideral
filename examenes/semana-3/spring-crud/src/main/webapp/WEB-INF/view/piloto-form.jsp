<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Administrador de pilotos</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar piloto</h3>
	
		<form:form action="savePiloto" modelAttribute="piloto" method="POST">

			<!-- need to associate this data with piloto id -->
			<form:hidden path="id"/>
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label>Equipo:</label></td>
						<td><form:input path="team" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/piloto/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










