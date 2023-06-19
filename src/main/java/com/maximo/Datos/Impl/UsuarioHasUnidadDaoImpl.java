/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Impl;

import com.maximo.Datos.Interfaz.iUsuarioHasUnidadDao;
import com.maximo.Dominio.Usuario;
import com.maximo.Dominio.UsuarioHasUnidad;
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
public class UsuarioHasUnidadDaoImpl implements iUsuarioHasUnidadDao {

    @PersistenceContext(unitName = "bibliotecaweb")
    EntityManager em;

    @Override
    public List<UsuarioHasUnidad> findAll() {
        Query query = em.createNamedQuery("UsuarioHasUnidad.findAll");
        return query.getResultList();
    }

    @Override
    public List<UsuarioHasUnidad> findPrestamoByidUsuario(UsuarioHasUnidad usuariohasunidad) {
        Query query = em.createNamedQuery("UsuarioHasUnidad.findByUsuarioidUsuario");
        query.setParameter("usuariohasunidad", usuariohasunidad.getUsuarioidUsuario());
        return query.getResultList();
    }

    @Override
    public List<UsuarioHasUnidad> findPrestamoByidUnidad(UsuarioHasUnidad usuariohasunidad) {
        Query query = em.createNamedQuery("UsuarioHasUnidad.findByUnidadidUnidad");
        query.setParameter("usuariohasunidad", usuariohasunidad.getUnidadidUnidad());
        return query.getResultList();

    }

    @Override
    public List<UsuarioHasUnidad> findByFecha(UsuarioHasUnidad usuariohasunidad) {
        Query query = em.createNamedQuery("UsuarioHasUnidad.findByFecha");
        query.setParameter("usuariohasunidad", usuariohasunidad.getUnidadidUnidad());
        return query.getResultList();
    }

    @Override
    public List<UsuarioHasUnidad> findByFechaEntrega(UsuarioHasUnidad usuariohasunidad) {
        Query query = em.createNamedQuery("UsuarioHasUnidad.findByFechaEntrega");
        query.setParameter("fechaEntrega", usuariohasunidad.getFechaEntrega());
        return query.getResultList();
    }

    @Override
    public List<UsuarioHasUnidad> findByIdusuario(Usuario usuario) {
        Query query = em.createNamedQuery("UsuarioHasUnidad.findByIdUsuario");
        query.setParameter("usuarioidUsuario", usuario);
        return query.getResultList();
    }

    @Override
    public UsuarioHasUnidad findByIdPrestamo(UsuarioHasUnidad usuariohasunidad) {
        Query query = em.createNamedQuery("UsuarioHasUnidad.findByIdPrestamo");
        query.setParameter("idPrestamo", usuariohasunidad.getIdPrestamo());
        return (UsuarioHasUnidad) query.getSingleResult();
    }

    @Override
    public void insertarUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad) {
        em.persist(usuariohasunidad);
    }

    @Override
    public void updateUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad) {
        em.merge(usuariohasunidad);
    }

    @Override
    public void deleteUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad) {
        em.remove(em.merge(usuariohasunidad));
    }
}
