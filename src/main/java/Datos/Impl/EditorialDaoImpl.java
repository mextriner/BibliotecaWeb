/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iEditorialDao;
import Dominio.Editorial;
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
public class EditorialDaoImpl implements iEditorialDao{
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    @Override
    public List<Editorial> findAllEditorial(){
        
        return em.createNamedQuery("Editorial.findAll").getResultList();
    }
    
    @Override
    public Editorial findByIdEditorial(Editorial editorial){
        
        return em.find(Editorial.class, editorial.getIdEditorial());
    }
    
    @Override
    public Editorial findByNombre(Editorial editorial){
        Query query = em.createQuery("Editorial.findByNombre");
        query.setParameter("nombre", editorial.getNombre());
        return (Editorial) query.getSingleResult();
        
    }
    
    @Override
    public Editorial findByDireccion(Editorial editorial){
        Query query = em.createQuery("Editorial.findByDireccion");
        query.setParameter("direccion", editorial.getDireccion());
        return (Editorial) query.getSingleResult();
        
    }
    
    @Override
    public void insertarEditorial(Editorial editorial){
        
        em.persist(editorial);
    }
    
    @Override
    public void updateEditorial(Editorial editorial){
        
        em.merge(editorial);
    }
    
    @Override
    public void deleteEditorial(Editorial editorial){
        em.remove(em.merge(editorial));

    }
    
}
