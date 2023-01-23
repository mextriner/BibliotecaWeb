/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iCategoriaDao;
import Dominio.Categoria;
import Dominio.Libro;
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
    
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
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
