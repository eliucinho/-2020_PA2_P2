/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial3.app.servicios;

import hn.uth.pa2.parcial3.app.modelos.Vehiculos;
import hn.uth.pa2.parcial3.app.repositorios.VehiculoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pccinho
 */
@Service
public class VehiculoServicio {
    @Autowired
    private VehiculoRepositorio repositorio;
    
    public void eliminarVehiculoByPlaca(String placa){
        repositorio.deleteById(placa);
    }
    public void guardarVehiculo(Vehiculos vehiculo){
        repositorio.save(vehiculo);
    }
    public Optional<Vehiculos> getVehiculoByPlaca(String placa){
       return repositorio.findById(placa);
    }
    public List<Vehiculos> getVehiculos(){
        return (List<Vehiculos>) repositorio.findAll();
    }
}
