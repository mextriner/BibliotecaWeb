/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iUnidadDao;
import Dominio.Unidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alumno Mañana
 */
@Stateless
public class UnidadDaoImpl implements iUnidadDao{
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    
    @Override
    public List<Unidad> findAllUnidad(){
        return em.createNamedQuery("Unidad.findAll").getResultList();
    }
    
    @Override
    public Unidad findByIdUnidad(Unidad unidad){
        return em.find(Unidad.class, unidad.getUnidadPK().getIdUnidad());
    }
    
    @Override
    public List<Unidad> findByEstado(Unidad unidad){
        Query query = em.createQuery("Unidad.findByEstado");
        query.setParameter("unidad", unidad.getEstado());
        return query.getResultList();
    }
    
    @Override
    public List<Unidad> findByProveedoridProveedor(Unidad unidad){
        Query query = em.createQuery("Unidad.findByProveedoridProveedor");
        query.setParameter("unidad", unidad.getProveedor());
        return query.getResultList();
    }
    
    @Override
    public List<Unidad> findByLibroISBN(Unidad unidad){
        Query query = em.createQuery("Unidad.findByProveedoridProveedor");
        query.setParameter("unidad", unidad.getProveedor());
        return query.getResultList();
    }
    
    @Override
    public void insertarUnidad(Unidad unidad){
        em.persist(unidad);
    }
    
    @Override
    public void updateUnidad(Unidad unidad){
        em.merge(unidad);
    }
    
    @Override
    public void deleteUnidad(Unidad unidad){
        em.remove(em.merge(unidad));
    }
}
