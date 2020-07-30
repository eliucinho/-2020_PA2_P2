/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.controladores;


import hn.uth.pa2.app.entidades.Vehiculos;
import hn.uth.pa2.app.repositorios.VehiculoJPARepositorio;
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
    //VehiculoJPARepositorio vr=new VehiculoJPARepositorio();
    
    
    public String getTablaVehiculos(){
        String tabla="<table>";
        try {
            //Vehiculos buscar = vr.buscar("P01");
            List<Vehiculos> listaVehiculos = vr.buscarTodo();
            for (Vehiculos tmp : listaVehiculos) {
                String fila="<tr>";
                fila+="<td>"+tmp.getPlaca()+"</td>";
                fila+="<td>"+tmp.getMarca()+"</td>";
                fila+="<td>"+tmp.getModelo()+"</td>";
                fila+="<td>"+tmp.getIdDuenio()+"</td>";
                fila+="<td><a href=\"controladorPrincipal?accion=consultar&placa="+tmp.getPlaca()+"\"> consultar</a></td>";
                tabla+=fila;
            }
        } catch (Exception ex) {
            Logger.getLogger(indexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
}
