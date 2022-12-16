package com.springboot.restapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.springboot.restapplication.entity.Piloto;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PilotoDAOHibernateImpl implements PilotoDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public PilotoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Piloto> buscarTodos() {
		System.out.println("EmployeeDAOHibernateImpl");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Piloto> theQuery =
				currentSession.createQuery("from Piloto", Piloto.class);
		
		// execute query and get result list
		List<Piloto> pilotos = theQuery.getResultList();
		
		// return the results		
		return pilotos;
	}


	@Override
	public Piloto buscarPorId(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Piloto thePiloto = currentSession.get(Piloto.class, theId);
		
		// return the employee
		return thePiloto;
	}


	@Override
	public void guardar(Piloto thePiloto) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(thePiloto);
	}


	@Override
	public void eliminarPorId(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Piloto where id=:pilotoId");
		
		theQuery.setParameter("pilotoId", theId);
		
		theQuery.executeUpdate();
	}

}







