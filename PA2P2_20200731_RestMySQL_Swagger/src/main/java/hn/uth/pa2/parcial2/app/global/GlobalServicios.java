/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.global;

import java.util.List;

/**
 *
 * @author desa
 */
public interface GlobalServicios<T,ID> {
    List<T> getTodos();
    T getValor(ID id);
    T guardar(T entidad);
    T actualizar(T entidad);
    void eliminar(ID id);
}
