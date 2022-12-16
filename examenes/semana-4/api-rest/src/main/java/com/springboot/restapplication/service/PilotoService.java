package com.springboot.restapplication.service;

import java.util.List;

import com.springboot.restapplication.entity.Piloto;

public interface PilotoService {

	public List<Piloto> findAll();
	
	public Piloto findById(int theId);
	
	public void save(Piloto thePiloto);
	
	public void deleteById(int theId);
	
}
