/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.controladores;

import hn.uth.pa2.app.objetos.Vehiculo;
import hn.uth.pa2.app.repositorios.VehiculoRepositorio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pccinho
 */
public class indexController {
    VehiculoRepositorio vr=new VehiculoRepositorio();
    
    public String getTablaVehiculos(){
        String tabla="<table>";
        try {
            List<Vehiculo> listaVehiculos = vr.buscarTodo();
            for (Vehiculo tmp : listaVehiculos) {
                String fila="<tr>";
                fila+="<td>"+tmp.getPlaca()+"</td>";
                fila+="<td>"+tmp.getMarca()+"</td>";
                fila+="<td>"+tmp.getModelo()+"</td>";
                fila+="<td>"+tmp.getId_duenio()+"</td>";
                
                tabla+=fila;
            }
        } catch (Exception ex) {
            Logger.getLogger(indexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
}
