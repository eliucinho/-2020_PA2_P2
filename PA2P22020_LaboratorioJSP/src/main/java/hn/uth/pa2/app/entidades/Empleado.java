/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.entidades;

/**
 *
 * @author pccinho
 */
public class Empleado {
    private int codigoEmpleado;
    private String nombre;
    private String apellido;

    public Empleado() {
    }
    
    public Empleado(int codigoEmpleado, String nombre, String apellido) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigoEmpleado=" + codigoEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
    
}
