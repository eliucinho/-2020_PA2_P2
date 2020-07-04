/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa2.app.repositorios;

import hn.uth.pa2.app.entidades.Vehiculos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pccinho
 */
public class VehiculoJPARepositorio implements Repositorio<Vehiculos>{

    private EntityManager em;
    
    private EntityManager getEm(){
        try {
            String nombreUnidadPersistencia="my_persistence_unit";
            EntityManagerFactory ef=Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
            return ef.createEntityManager();
        } catch (Exception e) {
            System.out.println("Error getEm: "+e.toString());
        }   
        return null;
    }

    public VehiculoJPARepositorio() {
        inicializarTransaccion();
    }
    
    private void inicializarTransaccion(){
        em=getEm();
        em.getTransaction().begin();
    }
        
    private void guardarCambios(){
        em.getTransaction().commit();
    }
    
    @Override
    public void crear(Vehiculos t) throws Exception {
        inicializarTransaccion();
        em.persist(t);
        guardarCambios();
    }

    @Override
    public void eliminar(Vehiculos t) throws Exception {
        inicializarTransaccion();
        String placa=t.getPlaca();
        em.remove(buscar(placa));
        guardarCambios();
    }

    @Override
    public void actualizar(Vehiculos t) throws Exception {
        inicializarTransaccion();
        
        Vehiculos vehiculoActual=buscar(t.getPlaca());
        vehiculoActual.setIdDuenio(t.getIdDuenio());
        vehiculoActual.setMarca(t.getMarca());
        vehiculoActual.setModelo(t.getModelo());
                
        em.persist(vehiculoActual);
        guardarCambios();
    }

    @Override
    public Vehiculos buscar(Object id) throws Exception {
        return em.find(Vehiculos.class, id);
    }

    @Override
    public List<Vehiculos> buscarTodo() throws Exception {
        //return em.createQuery("SELECT c FROM VEHICULOS c ",Vehiculos.class).getResultList();
        return em.createQuery("SELECT c FROM VEHICULOS c ",Vehiculos.class).getResultList();
    }
    
}
