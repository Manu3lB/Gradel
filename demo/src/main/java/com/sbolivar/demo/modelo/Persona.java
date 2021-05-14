package com.sbolivar.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Se hace referencia de que va ser el ID de la tabla persona
	private int id;
	private String name;
	private String telefono;
	
	public Persona() {
		super();
	}
	public Persona(int id, String name, String telefono) {
		super();
		this.id = id;
		this.name = name;
		this.telefono = telefono;
	}
	
	
	
}