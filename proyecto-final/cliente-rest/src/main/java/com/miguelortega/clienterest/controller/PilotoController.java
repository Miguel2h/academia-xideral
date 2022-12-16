package com.miguelortega.clienterest.controller;

import java.util.List;

import com.miguelortega.clienterest.model.Piloto;
import com.miguelortega.clienterest.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/piloto")
public class PilotoController {

	// need to inject our piloto service
	@Autowired
	private PilotoService pilotoService;
	
	@GetMapping("/list")
	public String listarPilotos(Model theModel) {
		
		// get pilotos from the service
		List<Piloto> thePilotos = pilotoService.obtenerPilotos();
				
		// add the pilotos to the model
		theModel.addAttribute("pilotos", thePilotos);
		
		return "list-customers";
	}
	
	@GetMapping("/mostrarFormularioAnadir")
	public String mostrarFormularioAnadir(Model theModel) {
		
		// create model attribute to bind form data
		Piloto thePiloto = new Piloto();
		
		theModel.addAttribute("piloto", thePiloto);
		
		return "customer-form";
	}
	
	@PostMapping("/guardarPiloto")
	public String guardarPiloto(@ModelAttribute("piloto") Piloto thePiloto) {
		
		// save the piloto using our service
		pilotoService.guardarPiloto(thePiloto);
		
		return "redirect:/piloto/list";
	}
	
	@GetMapping("/mostrarFormularioActualizar")
	public String mostrarFormularioActualizar(@RequestParam("pilotoId") int theId, Model theModel) {
		
		// get the piloto from our service
		Piloto thePiloto = pilotoService.obtenerPiloto(theId);
		
		// set piloto as a model attribute to pre-populate the form
		theModel.addAttribute("piloto", thePiloto);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/eliminar")
	public String eliminarPiloto(@RequestParam("pilotoId") int theId) {
		
		// delete the piloto
		pilotoService.eliminarPiloto(theId);
		
		return "redirect:/piloto/list";
	}
}










