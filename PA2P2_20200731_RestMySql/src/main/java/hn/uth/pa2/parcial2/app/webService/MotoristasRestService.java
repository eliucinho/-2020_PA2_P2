/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.webService;

import hn.uth.pa2.parcial2.app.modelos.Motoristas;
import hn.uth.pa2.parcial2.app.servicios.MotoristasServicio;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author uth
 */
@RestController
@RequestMapping(path = "/motoristas")
public class MotoristasRestService {
    @Autowired
    private MotoristasServicio servicio;

    @GetMapping("/")
    public Object getMotoristas(){
        return servicio.getMotoristas();
    }
    @GetMapping("/{id}")
    public Object getMotoristasById(@PathParam("id") Integer id){
        return servicio.getMotoristaById(id);
    }
    /*@GetMapping("/{nombres}")
    public Object getMotoristasByNombre(@PathParam("nombres") String nombres){
        return servicio.getMotoristaByNombres(nombres);
    }*/
    
    @PostMapping("/guardar")
    public Object guardar(@RequestBody Motoristas motoristas){
        servicio.guardar(motoristas);
        //return servicio.getMotoristaById(motoristas.getId());
        //return motoristas;
        return "almacenado con exito!";
    }
    @PostMapping("/actualizar")
    public Object actualizar(@RequestBody Motoristas motoristas){
        servicio.guardar(motoristas);
        //return servicio.getMotoristaById(motoristas.getId());
        //return motoristas;
        return "actualizado con exito!";
    }
    @PostMapping("/eliminar")
    public Object eliminar(@RequestBody Motoristas motoristas){
        servicio.eliminar(motoristas.getId());
        //return servicio.getMotoristaById(motoristas.getId());
        //return motoristas;
        return "eliminado con exito!";
    }
}
