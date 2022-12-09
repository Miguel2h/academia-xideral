package com.miguel.spring.controller;

import java.util.List;

import com.miguel.spring.entity.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miguel.spring.service.PilotoService;

@Controller
@RequestMapping("/piloto")
public class PilotoController {

	// need to inject our piloto service
	@Autowired
	private PilotoService pilotoService;
	
	@GetMapping("/list")
	public String listPilotos(Model theModel) {
		
		// get customers from the service
		List<Piloto> thePilotos = pilotoService.getPilotos();
				
		// add the customers to the model
		theModel.addAttribute("pilotos", thePilotos);
		
		return "list-pilotos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Piloto thePiloto = new Piloto();
		
		theModel.addAttribute("piloto", thePiloto);
		
		return "piloto-form";
	}
	
	@PostMapping("/savePiloto")
	public String savePiloto(@ModelAttribute("piloto") Piloto thePiloto) {
		
		// save the piloto using our service
		pilotoService.savePiloto(thePiloto);
		
		return "redirect:/piloto/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("pilotoId") int theId, Model theModel) {
		
		// get the piloto from our service
		Piloto thePiloto = pilotoService.getPiloto(theId);
		
		// set piloto as a model attribute to pre-populate the form
		theModel.addAttribute("piloto", thePiloto);
		
		// send over to our form		
		return "piloto-form";
	}
	
	@GetMapping("/delete")
	public String deletePiloto(@RequestParam("pilotoId") int theId) {
		
		// delete the piloto
		pilotoService.deletePiloto(theId);
		
		return "redirect:/piloto/list";
	}
}










