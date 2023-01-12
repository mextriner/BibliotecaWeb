/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iAutorDao;
import Dominio.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Alumno Mañana
 */


@Stateless
public class AutorDaoImpl implements iAutorDao{
    
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
    EntityManager em;
     
    @Override
    public List<Autor> findAllAutor(){
        return em.createNamedQuery("Autor.findAll").getResultList();
    }
    
    @Override
    public Autor findAutorById(Autor autor){
        return em.find(Autor.class, autor.getIdAutor());
    }
    
    @Override
    public Autor findAutorByName(Autor autor){
        Query query = em.createQuery("Autor.findByNombre");
        query.setParameter("nombre", autor.getNombre());
        return (Autor) query.getSingleResult();
    }
    
    @Override
    public Autor findAutorBySurname(Autor autor){
        Query query = em.createQuery("Autor.findByApellido");
        query.setParameter("apellido", autor.getApellido());
        return (Autor) query.getSingleResult();
    }
    
    @Override
    public Autor findAutorByNacionalidad(Autor autor){
         Query query = em.createQuery("Autor.findByNacionalidad");
        query.setParameter("nacionalidad", autor.getNacionalidad());
        return (Autor) query.getSingleResult();
    }
    
    @Override
    public Autor findAutorByNacimiento(Autor autor){
         Query query = em.createQuery("Autor.findByFechaNac");
        query.setParameter("fechaNac", autor.getFechaNac());
        return (Autor) query.getSingleResult();
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
