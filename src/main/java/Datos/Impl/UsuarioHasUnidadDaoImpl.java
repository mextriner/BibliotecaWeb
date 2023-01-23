/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iUsuarioHasUnidadDao;
import Dominio.UsuarioHasUnidad;
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
public class UsuarioHasUnidadDaoImpl implements iUsuarioHasUnidadDao{
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
    EntityManager em;
    
    @Override
    public List<UsuarioHasUnidad> findPrestamoByidUsuario(UsuarioHasUnidad usuariohasunidad){
        Query query = em.createQuery("UsuarioHasUnidad.findByUsuarioidUsuario");
        query.setParameter("usuariohasunidad", usuariohasunidad.getUsuario());
        return query.getResultList();
    }

    @Override
    public List<UsuarioHasUnidad> findPrestamoByidUnidad(UsuarioHasUnidad usuariohasunidad){
        Query query = em.createQuery("UsuarioHasUnidad.findByUnidadidUnidad");
        query.setParameter("usuariohasunidad", usuariohasunidad.getUnidad());
        return query.getResultList();

    }

    @Override
    public List<UsuarioHasUnidad> findByFecha(UsuarioHasUnidad usuariohasunidad){
        Query query = em.createQuery("UsuarioHasUnidad.findByFecha");
        query.setParameter("usuariohasunidad", usuariohasunidad.getUnidad());
        return query.getResultList();
    }
    
    @Override
    public void insertarUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad){
        em.persist(usuariohasunidad);
    }

    @Override
    public void updateUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad){
        em.merge(usuariohasunidad);
    }

    @Override
    public void deleteUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad){
        em.remove(em.merge(usuariohasunidad));
    }
}
