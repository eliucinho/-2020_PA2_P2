/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.parcial2.app.global;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author desa
 */
@Service
public abstract class GlobalAbstractServiceImpl<T,ID>  implements GlobalServicios<T, ID>{
    
    public abstract CrudRepository<T,ID> getRepositorio();
    
    @Override
    public List<T> getTodos(){
        return (List<T>) getRepositorio().findAll();
    }
    @Override
    public T getValor(ID id){
        return (T) getRepositorio().findById(id);
    }
    @Override
    public T guardar(T entidad){
        return getRepositorio().save(entidad);
    }
    @Override
    public T actualizar(T entidad){
        return getRepositorio().save(entidad);
    }
    @Override
    public void eliminar(ID id){
        getRepositorio().deleteById(id);
    }
    
}
