package com.sbolivar.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbolivar.demo.interfaceServicio.IpersonaService;
import com.sbolivar.demo.modelo.Persona;

@Controller //Indica que la clase es un controlador Spring.
@RequestMapping //Se utiliza para asignar solicitudes web a clases de manejador y métodos de manejador específicos
public class Controlador {
	
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar") //Se utiliza para asignar solicitudes HTTP GET a métodos de controlador
	public String listar(Model model) {
		List<Persona>personas=service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}

}
