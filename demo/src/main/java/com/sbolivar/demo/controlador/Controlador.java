package com.sbolivar.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbolivar.demo.interfaceServicio.IpersonaService;
import com.sbolivar.demo.modelo.Persona;

@Controller // Indica que la clase es un controlador Spring.
@RequestMapping // Se utiliza para asignar solicitudes web a clases de manejador y métodos de
				// manejador específicos
public class Controlador {

	@Autowired
	private IpersonaService service;

	@GetMapping("/listar") // Se utiliza para asignar solicitudes HTTP GET a métodos del controlador
	public String listar(Model model) {
		List<Persona> personas = service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}

	@GetMapping("/new") // Se utiliza para asignar solicitudes HTTP GET a métodos del controlador
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}

	@PostMapping("/save") // Se utiliza para asignar solicitudes HTTP POST a métodos del controlador
	public String save(@Validated Persona p, Model model) {
		service.save(p);
		return "redirect:/listar"; // Nos sirve a redireccionar a la pagina principal después de guardar
	}

	@GetMapping("/editar/{id}") // Pasamos el parametro id para que se pueda realizar la consulta
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona> persona = service.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}") // Pasamos el parametro id para que se pueda eliminar
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}

}
