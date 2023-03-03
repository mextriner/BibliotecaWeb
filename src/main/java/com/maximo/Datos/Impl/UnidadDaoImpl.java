/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Impl;

import com.maximo.Datos.Interfaz.iUnidadDao;
import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alumno Mañana
 */
@Stateless
public class UnidadDaoImpl implements iUnidadDao {

    @PersistenceContext(unitName = "bibliotecaweb")
    EntityManager em;

    @Override
    public List<Unidad> findAllUnidad() {
        return em.createNamedQuery("Unidad.findAll").getResultList();
    }

    @Override
    public Unidad findByIdUnidad(Unidad unidad) {

        return em.find(Unidad.class, unidad.getIdUnidad());
    }

    @Override
    public List<Unidad> findByEstado(Unidad unidad) {
        Query query = em.createQuery("Unidad.findByEstado");
        query.setParameter("unidad", unidad.getEstado());
        return query.getResultList();
    }

    @Override
    public List<Unidad> findProveedorByUnidad(Unidad unidad) {
        Query query = em.createQuery("Unidad.findByProveedoridProveedor");
        query.setParameter("unidad", unidad.getProveedor());
        return query.getResultList();
    }

    @Override
    public List<Unidad> findByLibroISBN(Unidad unidad) {
        Query query = em.createQuery("Unidad.findByLibroISBN");
        query.setParameter("unidad", unidad.getProveedor());
        return query.getResultList();
    }

    @Override
    public Unidad findByLibroISBNLimit1(Libro libro) {
        Query query = em.createNamedQuery("Unidad.findByIsbn");
        query.setParameter("libro_ISBN", libro);
        query.setParameter("estado", 1);
        Unidad unidad;
        try {
            unidad = (Unidad) query.setFirstResult(0).setMaxResults(1).getSingleResult();
            return unidad;
        } catch (NoResultException e) {
            // Manejar la excepción si no se encuentra ningún resultado
            return null;
        }
    }

    @Override
    public void insertarUnidad(Unidad unidad) {
        em.persist(unidad);
    }

    @Override
    public void updateUnidad(Unidad unidad) {
        em.merge(unidad);
    }

    @Override
    public void deleteUnidad(Unidad unidad) {
        em.remove(em.merge(unidad));
    }
}
