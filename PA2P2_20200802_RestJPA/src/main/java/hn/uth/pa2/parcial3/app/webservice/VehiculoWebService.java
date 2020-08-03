/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial3.app.webservice;

import hn.uth.pa2.parcial3.app.modelos.Vehiculos;
import hn.uth.pa2.parcial3.app.servicios.VehiculoServicio;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pccinho
 */
@RestController
@RequestMapping(path="/vehiculo")
public class VehiculoWebService {
    @Autowired
    private VehiculoServicio servicio;
    
    @GetMapping("/")
    public Object getVehiculos(){
        return servicio.getVehiculos();
    }
    
    @GetMapping("/{placa}")
    public Object getVehiculos(@PathParam("placa") String placa){
        return servicio.getVehiculos();
    }
    
    @PostMapping("/guardar")
    public Object guardar(@RequestBody Vehiculos vehiculo){
        servicio.guardarVehiculo(vehiculo);
        return servicio.getVehiculoByPlaca(vehiculo.getPlaca());
    }
    
     @PostMapping("/eliminar")
    public Object eliminar(@RequestBody Vehiculos vehiculo){
        servicio.eliminarVehiculoByPlaca(vehiculo.getPlaca());
        return servicio.getVehiculoByPlaca(vehiculo.getPlaca());
    }
}
