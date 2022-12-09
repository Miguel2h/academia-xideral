package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PilotoControllerServlet
 */
@WebServlet("/PilotoControllerServlet")
public class PilotoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PilotoDbUtil pilotoDbUtil;

	@Resource(name="jdbc/pilotos") //SE COMENTO PARA HACER USO DE JNDI
	private DataSource dataSource;


	@Override
	public void init() throws ServletException {
		super.init();
		// create our student db util ... and pass in the conn pool / datasource
		try {
			//https://www.digitalocean.com/community/tutorials/tomcat-datasource-jndi-example-java
			//Context ctx = new InitialContext(); //USO DE JNDI
			//dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/javatechie"); //USO DE JNDI
			//System.out.println("Demo con JNDI, Datasource: "+dataSource);
			pilotoDbUtil = new PilotoDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}


		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
						
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listPilotos(request, response);
				break;
				
			case "ADD":
				addPiloto(request, response);
				break;
				
			case "LOAD":
				loadPiloto(request, response);
				break;
				
			case "UPDATE":
				updatePiloto(request, response);
				break;
			
			case "DELETE":
				deletePiloto(request, response);
				break;
				
			default:
				listPilotos(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deletePiloto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// delete student from database
		pilotoDbUtil.deletePiloto(theStudentId);
		
		// send them back to "list students" page
		listPilotos(request, response);
	}

	private void updatePiloto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("pilotoId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String team = request.getParameter("team");
		
		// create a new student object
		Piloto thePiloto = new Piloto(id, firstName, lastName, email, team);
		
		// perform update on database
		pilotoDbUtil.updatePiloto(thePiloto);
		
		// send them back to the "list students" page
		listPilotos(request, response);
		
	}

	private void loadPiloto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theStudentId = request.getParameter("studentId");
		
		// get student from database (db util)
		Piloto thePiloto = pilotoDbUtil.getPiloto(theStudentId);
		
		// place student in the request attribute
		request.setAttribute("THE_PILOTO", thePiloto);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addPiloto(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String team = request.getParameter("team");
		
		// create a new student object
		Piloto thePiloto = new Piloto(firstName, lastName, email, team);
		
		// add the student to the database
		pilotoDbUtil.addPiloto(thePiloto);
				
		// send back to main page (the student list)
		listPilotos(request, response);
	}

	private void listPilotos(
			HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get pilotos from db util
		List<Piloto> pilotos = pilotoDbUtil.getPilotos();
		
		for (Piloto s: pilotos) {
			System.out.println(s);
		}
		
		pilotos.add(new Piloto(999, "FirstName","lastName", "email@gmail", "team"));
		// add pilotos to the request
		request.setAttribute("LISTA_PILOTOS", pilotos);
		
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-pilotos.jsp");
		dispatcher.forward(request, response);
	}

}













