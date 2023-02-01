/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Impl;

import com.maximo.Datos.Interfaz.iCategoriaDao;
import com.maximo.Dominio.Categoria;
import com.maximo.Dominio.Libro;
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
public class CategoriaDaoImpl implements iCategoriaDao{
    
    @PersistenceContext(unitName="bibliotecaweb")
    EntityManager em;
    
    @Override
    public List<Categoria> findAllCategoria(){
       return em.createNamedQuery("Categoria.findAll").getResultList(); 
    }
    
    @Override
    public Categoria findByIdCategoria(Categoria categoria){
        return em.find(Categoria.class, categoria.getIdCategoria());
    }
    
    @Override
    public Categoria findByNombre(Categoria categoria){
        Query query = em.createQuery("Categoria.findByNombre");
        query.setParameter("nombre", categoria.getNombre());
        return (Categoria) query.getSingleResult();
    }
    
    @Override
    public Categoria findByDescripcion(Categoria categoria){
        Query query = em.createQuery("Categoria.findByDescripcion");
        query.setParameter("descripcion", categoria.getDescripcion());
        return (Categoria) query.getSingleResult();
    }
    
    @Override
    public List<Libro> findLibroByCategoria(Categoria categoria){
        return categoria.getLibroList();
    }
    
    @Override
    public void insertarCategoria(Categoria categoria){
        em.persist(categoria);
    }
    @Override
    public void updateCategoria(Categoria categoria){
        em.merge(categoria);

    }
    @Override
    public void deleteCategoria(Categoria categoria){
        em.remove(em.merge(categoria));

    }
}
