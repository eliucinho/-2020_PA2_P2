/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.entidades;

import java.util.Date;

/**
 *
 * @author pccinho
 */
public class Empleado2 {
    private int codigoEmpleado;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int fechaContratacion;
    
    public Empleado2() {
    }

    public Empleado2(int codigoEmpleado, String nombre, String apellido, Date fechaNacimiento, int fechaContratacion) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(int fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String toString() {
        return "Empleado2{" + "codigoEmpleado=" + codigoEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", fechaContratacion=" + fechaContratacion + '}';
    }

}
