/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.servicios;

import hn.uth.pa2.parcial2.app.modelos.Motoristas;
import hn.uth.pa2.parcial2.app.repositorios.MotoristasRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author uth
 */
@Service
public class MotoristasServicio {
    @Autowired
    private MotoristasRepositorio repositorio;
    
    public void eliminar(int id){
        repositorio.deleteById(id);
    }
    
    public void guardar(Motoristas motorista){
        repositorio.save(motorista);
    }
    
    public void actualizar(Motoristas motorista){
        repositorio.save(motorista);
    }
    
    public List<Motoristas> getMotoristas(){
        return (List<Motoristas>) repositorio.findAll();
    }
    
    public Optional<Motoristas> getMotoristaById(Integer id){
        return repositorio.findById(id);
    }
    
    public Optional<Motoristas> getMotoristaByNombres(String nombres){
        return repositorio.findByNombres(nombres);
    }
}
