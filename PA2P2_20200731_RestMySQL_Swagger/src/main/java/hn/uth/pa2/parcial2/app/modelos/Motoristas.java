/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author uth
 */
@Entity
public class Motoristas implements Serializable{
    @Id
    private Long id;
    private String identidad;
    private String nombres;
    private String apellidos;

    public Motoristas() {
    }

    public Motoristas(Long id, String identidad, String nombres, String apellidos) {
        this.id = id;
        this.identidad = identidad;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Motoristas{" + "id=" + id + ", identidad=" + identidad + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
    
    
}
