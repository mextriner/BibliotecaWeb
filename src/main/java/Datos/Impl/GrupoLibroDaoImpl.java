/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iGrupoLibroDao;
import Dominio.Grupolibro;
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
public class GrupoLibroDaoImpl implements iGrupoLibroDao{
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    @Override
    public List<Grupolibro> findAllGrupoLibro(){
        return em.createNamedQuery("grupolibro.findAll").getResultList();
    }
    
    @Override
    public Grupolibro findByIdGrupo(Grupolibro grupoLibro){
        return em.find(Grupolibro.class, grupoLibro.getIdGrupo());
    }
    
    @Override
    public List<Grupolibro> findByNombre(Grupolibro grupoLibro){
        Query query = em.createQuery("grupolibro.findByNombre");
        query.setParameter("nombre", grupoLibro.getNombre());
        return query.getResultList();
    }
    
    @Override
    public List<Libro> findLibroByGrupo(Grupolibro grupoLibro){
        return grupoLibro.getLibroList();
    }
    
    @Override
    public void insertarGrupoLibro(Grupolibro grupoLibro){
        em.persist(grupoLibro);
    }
    
    @Override
    public void updateGrupoLibro (Grupolibro grupoLibro){
        em.merge(grupoLibro);
    }
    
    @Override
    public void deleteGrupoLibro(Grupolibro grupoLibro){
         em.remove(em.merge(grupoLibro));
    }
}
