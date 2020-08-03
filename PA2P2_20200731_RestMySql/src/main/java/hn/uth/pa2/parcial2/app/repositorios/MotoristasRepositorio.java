/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.repositorios;

import hn.uth.pa2.parcial2.app.modelos.Motoristas;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author uth
 */
public interface MotoristasRepositorio extends CrudRepository<Motoristas,Integer>{

    public Optional<Motoristas> findByNombres(String nombres);
    
}
