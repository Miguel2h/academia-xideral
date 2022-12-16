package com.miguelortega.clienterest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String equipo;

	public Piloto(String nombre, String apellido, String correo, String equipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.equipo = equipo;
	}
		
}











