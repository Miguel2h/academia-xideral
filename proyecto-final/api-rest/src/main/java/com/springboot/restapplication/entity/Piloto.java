package com.springboot.restapplication.entity;

import javax.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="piloto")
public class Piloto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="correo")
	private String correo;

	@Column(name="equipo")
	private String equipo;
	
}











