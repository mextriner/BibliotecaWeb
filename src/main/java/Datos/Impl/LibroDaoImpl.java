/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iLibroDao;
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
public class LibroDaoImpl implements iLibroDao{
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    @Override
    public List<Libro> findAllLibro(){
        return em.createNamedQuery("Libro.findAll").getResultList();
    }
    
    @Override
    public Libro findLibroById(Libro libro){
        return em.find(Libro.class, libro.getIsbn());
    }
    
    @Override
    public Libro findLibroByName(Libro libro){
        Query query = em.createQuery("Libro.findByNombre");
        query.setParameter("titulo", libro.getTitulo());
        return (Libro) query.getSingleResult();
    }
    
    @Override
    public Libro findLibroByNacionalidad(Libro libro){
         Query query = em.createQuery("Libro.findByNacionalidad");
        query.setParameter("fechaPublicacion", libro.getNacionalidad());
        return (Libro) query.getSingleResult();
    }
    
    @Override
    public Libro findLibroByBestSeller(Libro libro){
         Query query = em.createQuery("Libro.findByFechaNac");
        query.setParameter("bestSeller", libro.getBestSeller());
        return (Libro) query.getSingleResult();
    }
    
    @Override
    public void insertarLibro(Libro libro){
        em.persist(libro);
    }
    
    @Override
    public void updateLibro (Libro libro){
        em.merge(libro);
    }
    
    @Override
    public void deleteLibro(Libro libro){
         em.remove(em.merge(libro));
    }
}
