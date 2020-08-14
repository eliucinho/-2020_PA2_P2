/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.controladores;

import hn.uth.pa2.parcial2.app.modelos.Motoristas;
import hn.uth.pa2.parcial2.app.servicios.MotoristasServicio;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author desa
 */
@Controller
public class MotoristasController {
    @Autowired
    private MotoristasServicio servicio;

    @RequestMapping(path = "/")
    public String getMotoristas(Model model){
        //model.addAttribute("listaMotorista", null);
        return "motorista-principal";
    }
    
    @GetMapping("/motorista/{id}")
    public String getMotoristasById(@PathParam("id") Long id,Model model){
        model.addAttribute("motorista",servicio.getValor(id));
        return "motorista-principal";
    }
    
    @PostMapping("/guardar")
    public Object guardar(@RequestBody Motoristas motoristas,Model model){
        servicio.guardar(motoristas);
        return "redirect:/";
    }
    @PostMapping("/actualizar")
    public String actualizar(@RequestBody Motoristas motoristas,Model model){
        servicio.guardar(motoristas);
        return "redirect:/";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model){
        servicio.eliminar(id);
        return "redirect:/";
    }
}
