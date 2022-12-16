package com.springboot.restapplication.service;

import java.util.List;

import com.springboot.restapplication.entity.Piloto;
import com.springboot.restapplication.dao.PilotoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PilotoServiceImpl implements PilotoService {

	
	private PilotoDAO pilotoDAO;
	
	@Autowired
	public PilotoServiceImpl(@Qualifier("pilotoDAOHibernateImpl") PilotoDAO thePilotoDAO) {
		pilotoDAO = thePilotoDAO;
	}
	
	@Override
	@Transactional
	public List<Piloto> findAll() {
		return pilotoDAO.buscarTodos();
	}

	@Override
	@Transactional
	public Piloto findById(int theId) {
		return pilotoDAO.buscarPorId(theId);
	}

	@Override
	@Transactional
	public void save(Piloto thePiloto) {
		pilotoDAO.guardar(thePiloto);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		pilotoDAO.eliminarPorId(theId);
	}

}






