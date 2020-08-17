/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author desa
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class Perssona {
    private String id;
    private  String nombre; 
    private String direccion;
    private int edad;
}
