package com.miguel.spring.dao;

import java.util.List;

import com.miguel.spring.entity.Piloto;

public interface PilotoDAO {

	public List<Piloto> getPilotos();

	public void savePiloto(Piloto thePiloto);

	public Piloto getPiloto(int theId);

	public void deletePiloto(int theId);
	
}
