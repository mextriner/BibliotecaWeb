/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Service.Impl;

import com.maximo.Datos.Interfaz.iUsuarioDao;
import com.maximo.Dominio.Usuario;
import com.maximo.Service.Interfaz.iUsuarioService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Alumno Mañana
 */
@Stateless
public class UsuarioServiceImpl implements iUsuarioService{
    
    @Inject
    private iUsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> findAllUsuario(){
        return usuarioDao.findAllUsuario();
    }
    
    
    @Override
    public Usuario findByIdUsuario(Usuario usuario){
        return usuarioDao.findByIdUsuario(usuario);
    }
    
    
    @Override
    public List<Usuario> findByNombre(Usuario usuario){
        return usuarioDao.findByNombre(usuario);
    }
    
    
    @Override
    public List<Usuario> findByApellido(Usuario usuario){
        return usuarioDao.findByApellido(usuario);
    }
    
    
    @Override
    public List<Usuario> findByDireccion(Usuario usuario){
        return usuarioDao.findByDireccion(usuario);
    }
    
    
    @Override
    public List<Usuario> findByFechaNAc(Usuario usuario){
        return usuarioDao.findByFechaNAc(usuario);
    }
    
    @Override
    public boolean existUsuario (Usuario usuario){
        boolean ex = false;
        for(int i = 0; i < findAllUsuario().size(); i++){
            if(findAllUsuario().get(i).getIdUsuario().equals(usuario.getIdUsuario())){
                ex = true;
            }
        }
        return ex;
    }
    
    @Override
    public void insertarUsuario(Usuario usuario){
        usuarioDao.insertarUsuario(usuario);
    }
    
    
    @Override
    public void updateUsuario(Usuario usuario){
        usuarioDao.updateUsuario(usuario);
    }
    
    
    @Override
    public void deleteUsuario(Usuario usuario){
        usuarioDao.deleteUsuario(usuario);
    }
    
}
