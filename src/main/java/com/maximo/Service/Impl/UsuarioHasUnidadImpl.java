/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maximo.Service.Impl;

import com.maximo.Datos.Interfaz.iUsuarioHasUnidadDao;
import com.maximo.Dominio.Usuario;
import com.maximo.Dominio.UsuarioHasUnidad;
import com.maximo.Service.Interfaz.iUsuarioHasUnidadService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Maximo
 */
public class UsuarioHasUnidadImpl implements iUsuarioHasUnidadService {

    @Inject
    private iUsuarioHasUnidadDao usuarioHasUnidadDao;

    @Override
    public List<UsuarioHasUnidad> findAll() {
        return usuarioHasUnidadDao.findAll();
    }

    @Override
    public List<UsuarioHasUnidad> findPrestamoByidUsuario(UsuarioHasUnidad usuariohasunidad) {
        return usuarioHasUnidadDao.findPrestamoByidUsuario(usuariohasunidad);
    }

    @Override
    public List<UsuarioHasUnidad> findPrestamoByidUnidad(UsuarioHasUnidad usuariohasunidad) {
        return usuarioHasUnidadDao.findPrestamoByidUnidad(usuariohasunidad);
    }

    @Override
    public List<UsuarioHasUnidad> findByFecha(UsuarioHasUnidad usuariohasunidad) {
        return usuarioHasUnidadDao.findByFecha(usuariohasunidad);
    }

    @Override
    public List<UsuarioHasUnidad> findByFechaEntrega(UsuarioHasUnidad usuariohasunidad) {
        return usuarioHasUnidadDao.findByFechaEntrega(usuariohasunidad);
    }

    @Override
    public List<UsuarioHasUnidad> findByIdusuario(Usuario usuario) {
        return usuarioHasUnidadDao.findByIdusuario(usuario);
    }

    @Override
    public UsuarioHasUnidad findByIdPrestamo(UsuarioHasUnidad usuariohasunidad) {
        return usuarioHasUnidadDao.findByIdPrestamo(usuariohasunidad);
    }

    @Override
    public void insertarUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad) {
        usuarioHasUnidadDao.insertarUsuarioHasUnidad(usuariohasunidad);
    }

    @Override
    public void updateUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad) {
        usuarioHasUnidadDao.updateUsuarioHasUnidad(usuariohasunidad);
    }

    @Override
    public void deleteUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad) {
        usuarioHasUnidadDao.deleteUsuarioHasUnidad(usuariohasunidad);
    }

}
