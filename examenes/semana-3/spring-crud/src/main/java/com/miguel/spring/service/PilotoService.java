package com.miguel.spring.service;

import java.util.List;

import com.miguel.spring.entity.Piloto;

public interface PilotoService {

	public List<Piloto> getPilotos();

	public void savePiloto(Piloto thePiloto);

	public Piloto getPiloto(int theId);

	public void deletePiloto(int theId);
	
}
