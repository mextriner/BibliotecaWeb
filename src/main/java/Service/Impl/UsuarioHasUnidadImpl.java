/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Datos.Interfaz.iUsuarioHasUnidadDao;
import Dominio.UsuarioHasUnidad;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Maximo
 */
public class UsuarioHasUnidadImpl {
    
    @Inject
    private iUsuarioHasUnidadDao usuarioHasUnidadDao;
    
    public List<UsuarioHasUnidad> findPrestamoByidUsuario(UsuarioHasUnidad usuariohasunidad){
        return usuarioHasUnidadDao.findPrestamoByidUsuario(usuariohasunidad);
    }

    public List<UsuarioHasUnidad> findPrestamoByidUnidad(UsuarioHasUnidad usuariohasunidad){
        return usuarioHasUnidadDao.findPrestamoByidUnidad(usuariohasunidad);
    }

    public List<UsuarioHasUnidad> findByFecha(UsuarioHasUnidad usuariohasunidad){
        return usuarioHasUnidadDao.findByFecha(usuariohasunidad);
    }
    
    public void insertarUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad){
        usuarioHasUnidadDao.insertarUsuarioHasUnidad(usuariohasunidad);
    }

    public void updateUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad){
        usuarioHasUnidadDao.updateUsuarioHasUnidad(usuariohasunidad);
    }

    public void deleteUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad){
        usuarioHasUnidadDao.deleteUsuarioHasUnidad(usuariohasunidad);
    }

}
