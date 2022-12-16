package com.miguelortega.clienterest.service;

import java.util.List;

import com.miguelortega.clienterest.model.Piloto;

public interface PilotoService {

	public List<Piloto> obtenerPilotos();

	public void guardarPiloto(Piloto thePiloto);

	public Piloto obtenerPiloto(int theId);

	public void eliminarPiloto(int theId);
	
}
