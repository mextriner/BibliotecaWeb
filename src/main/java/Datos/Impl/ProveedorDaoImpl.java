/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iProveedorDao;
import Dominio.Proveedor;
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
public class ProveedorDaoImpl implements iProveedorDao{
    @PersistenceContext(unitName="bibliotecaweb")
    EntityManager em;
    
    @Override
    public List<Proveedor> findAllProveedor(){
        return em.createNamedQuery("Proveedor.findAll").getResultList();
        
    }
    
    @Override
    public Proveedor findByIdProveedor(Proveedor proveedor){
        return em.find(Proveedor.class, proveedor.getIdProveedor());
    }
    
    @Override
    public List<Proveedor> findByNombre(Proveedor proveedor){
        Query query = em.createQuery("Proveedor.findByNombre");
        query.setParameter("nombre", proveedor.getNombre());
        return query.getResultList();
    }
    
    @Override
    public List<Proveedor> findByDireccion(Proveedor proveedor){
        Query query = em.createQuery("Proveedor.findByDireccion");
        query.setParameter("direccion", proveedor.getNombre());
        return query.getResultList();
    }
    
    @Override
    public List<Unidad> findUnidadByProveedor(Proveedor proveedor){        
        return proveedor.getUnidadList();
    }

    
    @Override
    public void insertarProveedor(Proveedor proveedor){
        em.persist(proveedor);
    }
    
    @Override
    public void updateProveedor(Proveedor proveedor){
        em.merge(proveedor);
    }
    
    @Override
    public void deleteroveedor(Proveedor proveedor){
        em.remove(em.merge(proveedor));
    }
}
