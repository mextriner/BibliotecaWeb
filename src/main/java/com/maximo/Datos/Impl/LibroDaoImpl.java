/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Impl;

import com.maximo.Datos.Interfaz.iLibroDao;
import com.maximo.Dominio.Autor;
import com.maximo.Dominio.Categoria;
import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
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
public class LibroDaoImpl implements iLibroDao {

    @PersistenceContext(unitName = "bibliotecaweb")
    EntityManager em;

    @Override
    public List<Libro> findAllLibro() {
        return em.createNamedQuery("Libro.findAll").getResultList();
    }

    @Override
    public Libro findByIsbn(Libro libro) {
        return em.find(Libro.class, libro.getIsbn());
    }

    @Override
    public List<Libro> findByTitulo(Libro libro) {
        Query query = em.createQuery("Libro.findByTitulo");
        query.setParameter("titulo", libro.getTitulo());
        return query.getResultList();
    }

    @Override
    public List<Libro> findByFechaPublicacion(Libro libro) {
        Query query = em.createQuery("Libro.findByFechaPublicacion");
        query.setParameter("fechaPublicacion", libro.getFechaPublicacion());
        return query.getResultList();
    }

    @Override
    public List<Libro> findByBestSeller(Libro libro) {
        Query query = em.createQuery("Libro.findByFechaNac");
        query.setParameter("bestSeller", libro.getBestSeller());
        return query.getResultList();
    }
    
    @Override
    public List<Libro> buscadorLibroBestseller(String bus, short bestseller){
        Query query = em.createNamedQuery("Libro.buscadorBestseller");
        query.setParameter("isbn", bus);
        query.setParameter("titulo", bus);
        query.setParameter("fechaPublicacion",bus);
        query.setParameter("descripcion",bus);
        query.setParameter("bestSeller",bestseller);
        return query.getResultList();
    }
    
    @Override
    public List<Libro> buscadorLibro(String bus){
        Query query = em.createNamedQuery("Libro.buscadorBestseller");
        query.setParameter("isbn", bus);
        query.setParameter("titulo", bus);
        query.setParameter("fechaPublicacion",bus);
        query.setParameter("descripcion",bus);
        return query.getResultList();
    }

    @Override
    public List<Autor> findAutorByLibro(Libro libro) {
        return libro.getAutorList();
    }

    @Override
    public List<Categoria> findCategoriaByLibro(Libro libro) {
        return libro.getCategoriaList();
    }

    @Override
    public List<Unidad> findUnidadByLibro(Libro libro) {
        return libro.getUnidadList();
    }

    @Override
    public void insertarLibro(Libro libro) {
        em.persist(libro);
    }

    @Override
    public void updateLibro(Libro libro) {
        em.merge(libro);
    }

    @Override
    public void deleteLibro(Libro libro) {
        em.remove(em.merge(libro));
    }
}
