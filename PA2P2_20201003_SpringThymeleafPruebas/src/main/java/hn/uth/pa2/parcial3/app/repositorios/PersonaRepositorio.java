package hn.uth.pa2.parcial3.app.repositorios;

import org.springframework.data.repository.CrudRepository;

import hn.uth.pa2.parcial3.app.modelos.Persona;

public interface PersonaRepositorio extends CrudRepository<Persona, Long> {

}
