/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import Datos.Interfaz.iUsuarioDao;
import Dominio.Usuario;
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
public class UsuarioDaoImpl implements iUsuarioDao{
    @PersistenceContext(unitName="bibliotecaweb")
    EntityManager em;
    
    @Override
    public List<Usuario> findAllUsuario(){
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }
    
    @Override
    public Usuario findByIdUsuario(Usuario usuario){
        return em.find(Usuario.class, usuario.getIdUsuario());
    }
    
    @Override
    public List<Usuario> findByNombre(Usuario usuario){
        Query query = em.createQuery("Unidad.findByNombre");
        query.setParameter("usuario", usuario.getNombre());
        return query.getResultList();
    }
    
    @Override
    public List<Usuario> findByApellido(Usuario usuario){
        Query query = em.createQuery("Usuario.findByApellido");
        query.setParameter("usuario", usuario.getApellido());
        return query.getResultList();
    }
    
    @Override
    public List<Usuario> findByDireccion(Usuario usuario){
        Query query = em.createQuery("Usuario.findByDireccion");
        query.setParameter("usuario", usuario.getDireccion());
        return query.getResultList();
    }
    
    @Override
    public List<Usuario> findByFechaNAc(Usuario usuario){
        Query query = em.createQuery("Usuario.findByFechaNac");
        query.setParameter("usuario", usuario.getFechaNac());
        return query.getResultList();
    }
    
    @Override
    public void insertarUsuario(Usuario usuario){
        em.persist(usuario);
    }
    
    @Override
    public void updateUsuario(Usuario usuario){
        em.merge(usuario);
    }
    
    @Override
    public void deleteUsuario(Usuario usuario){
        em.remove(em.merge(usuario));
    }
}
