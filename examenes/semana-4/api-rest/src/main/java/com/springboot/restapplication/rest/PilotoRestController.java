package com.springboot.restapplication.rest;

import java.util.List;

import com.springboot.restapplication.entity.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapplication.service.PilotoService;

@RestController
@RequestMapping("/rest")
public class PilotoRestController {

	private PilotoService pilotoService;
	
	@Autowired
	public PilotoRestController(PilotoService thePilotoService) {
		pilotoService = thePilotoService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/pilotos")
	public List<Piloto> findAll() {
		return pilotoService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/pilotos/{pilotoId}")
	public Piloto getEmployee(@PathVariable int pilotoId) throws Exception {
		
		Piloto thePiloto = pilotoService.findById(pilotoId);
		
		if (thePiloto == null) {
			throw new Exception("No se encontró el piloto con Id - " + pilotoId);
		}
		
		return thePiloto;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/pilotos")
	public Piloto addEmployee(@RequestBody Piloto thePiloto) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		thePiloto.setId(0);
		
		pilotoService.save(thePiloto);
		
		return thePiloto;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/pilotos")
	public Piloto updateEmployee(@RequestBody Piloto thePiloto) {
		
		pilotoService.save(thePiloto);
		
		return thePiloto;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/pilotos/{pilotoId}")
	public String deleteEmployee(@PathVariable int pilotoId) {
		
		Piloto tempPiloto = pilotoService.findById(pilotoId);
		
		// throw exception if null
		
		if (tempPiloto == null) {
			throw new RuntimeException("No se ha encontrado el piloto con Id- " + pilotoId);
		}
		
		pilotoService.deleteById(pilotoId);
		
		return "Se ha eliminado el piloto con Id - " + pilotoId;
	}
	
}










