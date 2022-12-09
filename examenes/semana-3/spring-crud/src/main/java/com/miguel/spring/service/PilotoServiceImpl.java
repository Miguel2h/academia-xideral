package com.miguel.spring.service;

import java.util.List;

import com.miguel.spring.entity.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miguel.spring.dao.PilotoDAO;

@Service
public class PilotoServiceImpl implements PilotoService {

	// need to inject piloto dao
	@Autowired
	private PilotoDAO pilotoDAO;
	
	@Override
	@Transactional
	public List<Piloto> getPilotos() {
		return pilotoDAO.getPilotos();
	}

	@Override
	@Transactional
	public void savePiloto(Piloto thePiloto) {

		pilotoDAO.savePiloto(thePiloto);
	}

	@Override
	@Transactional
	public Piloto getPiloto(int theId) {
		
		return pilotoDAO.getPiloto(theId);
	}

	@Override
	@Transactional
	public void deletePiloto(int theId) {
		
		pilotoDAO.deletePiloto(theId);
	}
}





