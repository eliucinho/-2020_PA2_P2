package hn.uth.pa2.parcial3.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hn.uth.pa2.parcial3.app.modelos.Persona;
import hn.uth.pa2.parcial3.app.servicios.PersonaServicio;

@Controller
public class PersonaUIControlador {
	
	@Autowired
	private PersonaServicio personaServiceAPI;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("lista", personaServiceAPI.getTodos());
		return "index";
	}
	
	
	@GetMapping("/guardar/{id}")
	public String irPersona(@PathVariable("id") Long id , Model model) {
		if(id != null && id != 0) {
			model.addAttribute("persona", personaServiceAPI.getValor(id));
		}else {
			model.addAttribute("persona", new Persona());
		}
		return "persona";
	}
	
	@PostMapping("/guardar")
	public String guardar(Persona persona, Model model) {
		personaServiceAPI.guardar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		personaServiceAPI.eliminar(id);
		
		return "redirect:/";
	}
	
	

}
