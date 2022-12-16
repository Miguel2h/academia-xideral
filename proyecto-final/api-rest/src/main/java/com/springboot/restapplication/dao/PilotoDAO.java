package com.springboot.restapplication.dao;

import java.util.List;
import com.springboot.restapplication.entity.Piloto;

public interface PilotoDAO {

	List<Piloto> buscarTodos();
	
	Piloto buscarPorId(int theId);
	
	void guardar(Piloto thePiloto);
	
	void eliminarPorId(int theId);
	
}
