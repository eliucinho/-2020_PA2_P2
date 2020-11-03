package hn.uth.pa2.parcial3.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.uth.pa2.parcial3.app.modelos.Persona;
import hn.uth.pa2.parcial3.app.servicios.PersonaServicio;

@RestController
@RequestMapping(value = "/ws/personas/")
@CrossOrigin("*")
public class PersonaRestControlador {

	@Autowired
	private PersonaServicio personaServiceAPI;

	@GetMapping(value = "/")
	public List<Persona> getTodos() {
		return personaServiceAPI.getTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Persona getById(@PathVariable Long id) {
		return personaServiceAPI.getValor(id);
	}

	@PostMapping(value = "/guardar")
	public ResponseEntity<Persona> guardar(@RequestBody Persona persona) {
		Persona obj = personaServiceAPI.guardar(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/eliminar/{id}")
	public ResponseEntity<Persona> eliminar(@PathVariable Long id) {
		Persona persona = personaServiceAPI.getValor(id);
		if (persona != null) {
			personaServiceAPI.eliminar(id);
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

}
