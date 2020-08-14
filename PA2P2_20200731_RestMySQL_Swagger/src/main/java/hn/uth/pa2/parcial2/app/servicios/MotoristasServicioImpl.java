/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.servicios;

import hn.uth.pa2.parcial2.app.modelos.Motoristas;
import hn.uth.pa2.parcial2.app.repositorios.MotoristasRepositorio;
import hn.uth.pa2.parcial2.app.global.GlobalAbstractServiceImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author desa
 */
@Service
public class MotoristasServicioImpl extends GlobalAbstractServiceImpl<Motoristas, Long> implements MotoristasServicio{

    private MotoristasRepositorio repositorio;
    
    @Override
    public CrudRepository<Motoristas, Long> getRepositorio() {
        return repositorio;
    }
    
}
