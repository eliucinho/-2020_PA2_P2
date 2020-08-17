package hn.uth.pa2.parcial3.app.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import hn.uth.pa2.parcial3.app.global.GlobalServicioAbstractImplementacion;
import hn.uth.pa2.parcial3.app.modelos.Persona;
import hn.uth.pa2.parcial3.app.servicios.PersonaServicio;
import hn.uth.pa2.parcial3.app.repositorios.PersonaRepositorio;

@Service
public class PersonaServicioImplementacion extends GlobalServicioAbstractImplementacion<Persona, Long> implements PersonaServicio {

	@Autowired
	private PersonaRepositorio repositorio;
	
	@Override
	public CrudRepository<Persona, Long> getRepositorio() {
		return repositorio;
	}

}
