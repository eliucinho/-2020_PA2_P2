/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.intro.repositorios;

import java.util.List;

/**
 *
 * @author pccinho
 */
public interface Repositorio<T> {
    public void crear(T t) throws Exception ;
    public void eliminar(T t) throws Exception ;
    public void actualizar(T t) throws Exception ;
    
    public T buscar(Object id) throws Exception ;
    public List<T> buscarTodo() throws Exception ;
}
