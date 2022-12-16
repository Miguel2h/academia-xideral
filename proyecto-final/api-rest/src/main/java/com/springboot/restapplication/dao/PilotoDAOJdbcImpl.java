package com.springboot.restapplication.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import com.springboot.restapplication.entity.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PilotoDAOJdbcImpl implements PilotoDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Piloto> buscarTodos() {
		System.out.println("Implementación DAO con JDBC findAll(): " + dataSource);

		List<Piloto> listaPilotos = new ArrayList<>();

		String sql = "select * from Piloto";

		try (Connection myConn = dataSource.getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql);) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				String equipo = myRs.getString("equipo");

				// create new student object
				Piloto tempPiloto = new Piloto(id, nombre, apellido, correo, equipo);

				// add it to the list of students
				listaPilotos.add(tempPiloto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaPilotos;
	}

	@Override
	public Piloto buscarPorId(int theId) {
		
		System.out.println("Implementación DAO con JDBC findById(): ");
		Piloto thePiloto = null;

		try (Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = createPreparedStatement(myConn, theId);
			ResultSet myRs = myStmt.executeQuery();) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				String equipo = myRs.getString("equipo");

				// use the studentId during construction
				thePiloto = new Piloto(theId, nombre, apellido, correo, equipo);
			} else {
				throw new SQLException("Could not find employee id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thePiloto;
	}

	private PreparedStatement createPreparedStatement(Connection con, int pilotoId) throws SQLException {
		String sql = "select * from piloto where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, pilotoId);
		return ps;
	}

	@Override
	public void guardar(Piloto thePiloto) {
		String sql = "";

		if (thePiloto.getId() == 0)
			sql = "insert into piloto (nombre, apellido, correo, equipo) values (?, ?, ?, ?)";
		else
			sql = "update piloto set nombre=?, apellido=?, correo=?, equipo=? where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			myStmt.setString(1, thePiloto.getNombre());
			myStmt.setString(2, thePiloto.getApellido());
			myStmt.setString(3, thePiloto.getCorreo());
			myStmt.setString(4, thePiloto.getEquipo());

			if (thePiloto.getId() != 0)
				myStmt.setInt(5, thePiloto.getId());

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminarPorId(int theId) {
		
		try (Connection myConn = dataSource.getConnection(); 
			 PreparedStatement myStmt = myConn.prepareStatement("delete from piloto where id=?")) {
			
			myStmt.setInt(1, theId);
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
