/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial3.app.modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author pccinho
 */
@Entity
public class Vehiculos implements Serializable {
    @Id
    private String placa;
    private String marca;
    private String modelo;
    private int idDuenio;

    public Vehiculos() {
    }

    public Vehiculos(String placa, String marca, String modelo, int idDuenio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.idDuenio = idDuenio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDuenio) {
        this.idDuenio = idDuenio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", idDuenio=" + idDuenio + '}';
    }
    
    
}
