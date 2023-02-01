/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Impl;

import com.maximo.Datos.Interfaz.iAutorDao;
import com.maximo.Dominio.Autor;
import com.maximo.Dominio.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Alumno Mañana
 */


@Stateless
public class AutorDaoImpl implements iAutorDao{
    
    @PersistenceContext(unitName="bibliotecaweb")
    EntityManager em;
     
    @Override
    public List<Autor> findAllAutor(){
        return em.createNamedQuery("Autor.findAll").getResultList();
    }
    
    @Override
    public Autor findById(Autor autor){
        return em.find(Autor.class, autor.getIdAutor());
    }
    
    @Override
    public List<Autor> findByName(Autor autor){
        Query query = em.createQuery("Autor.findByNombre");
        query.setParameter("nombre", autor.getNombre());
        return query.getResultList();
    }
    
    @Override
    public List<Autor> findBySurname(Autor autor){
        Query query = em.createQuery("Autor.findByApellido");
        query.setParameter("apellido", autor.getApellido());
        return query.getResultList();
    }
    
    @Override
    public List<Autor> findByNacionalidad(Autor autor){
         Query query = em.createQuery("Autor.findByNacionalidad");
        query.setParameter("nacionalidad", autor.getNacionalidad());
        return query.getResultList();
    }
    
    @Override
    public List<Autor> findByNacimiento(Autor autor){
         Query query = em.createQuery("Autor.findByFechaNac");
        query.setParameter("fechaNac", autor.getFechaNac());
        return query.getResultList();
    }
    
    @Override
    public List<Libro> findLibroByAutor(Autor autor){
        return autor.getLibroList();
    }
    
    @Override
    public void insertarAutor(Autor autor){
        em.persist(autor);
    }
    
    @Override
    public void updateAutor (Autor autor){
        em.merge(autor);
    }
    
    @Override
    public void deleteAutor(Autor autor){
        em.remove(em.merge(autor));
    }
}
