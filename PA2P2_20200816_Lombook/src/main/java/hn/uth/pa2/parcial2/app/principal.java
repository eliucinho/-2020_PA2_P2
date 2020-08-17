/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app;

/**
 *
 * @author desa
 */
public class principal {
    public static void main(String [] args){
        String id="ID01";
        String nombre="ELIUD";
        String direccion="VARELA Street";
        int Edad=18;
        Perssona persona=new Perssona(id, nombre, direccion, Edad);
        Perssona personaContructorDefault=new Perssona();
        Perssona personaBuilt=Perssona.builder()
                                        .id("HND")
                                        .nombre("Honduras")
                                        .direccion("CA")
                                        .edad(186)
                                        .build();
    
        System.out.println("hola mundo");
    }
}
