package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PilotoDbUtil {

	private DataSource dataSource;

	public PilotoDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Piloto> getPilotos() throws Exception {
		
		List<Piloto> pilotos = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from piloto order by id";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("nombre");
				String lastName = myRs.getString("apellido");
				String email = myRs.getString("correo");
				String team = myRs.getString("equipo");
				
				// create new student object
				Piloto tempPiloto = new Piloto(id, firstName, lastName, email, team);
				
				// add it to the list of pilotos
				pilotos.add(tempPiloto);
			}
			
			return pilotos;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addPiloto(Piloto thePiloto) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into piloto "
					   + "(nombre, apellido, correo, equipo) "
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, thePiloto.getFirstName());
			myStmt.setString(2, thePiloto.getLastName());
			myStmt.setString(3, thePiloto.getEmail());
			myStmt.setString(4, thePiloto.getTeam());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Piloto getPiloto(String thePilotoId) throws Exception {

		Piloto thePiloto = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int pilotoId;
		
		try {
			// convert student id to int
			pilotoId = Integer.parseInt(thePilotoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from piloto where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, pilotoId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("nombre");
				String lastName = myRs.getString("apellido");
				String email = myRs.getString("correo");
				String team = myRs.getString("equipo");
				
				// use the pilotoId during construction
				thePiloto = new Piloto(pilotoId, firstName, lastName, email, team);
			}
			else {
				throw new Exception("Could not find student id: " + pilotoId);
			}				
			
			return thePiloto;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updatePiloto(Piloto thePiloto) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update piloto "
						+ "set nombre=?, apellido=?, correo=?, equipo=?"
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, thePiloto.getFirstName());
			myStmt.setString(2, thePiloto.getLastName());
			myStmt.setString(3, thePiloto.getEmail());
			myStmt.setString(4, thePiloto.getTeam());
			myStmt.setInt(5, thePiloto.getId());

			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deletePiloto(String thePilotoId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int pilotoId = Integer.parseInt(thePilotoId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from piloto where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, pilotoId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















