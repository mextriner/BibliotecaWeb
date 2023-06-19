/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Interfaz;

import com.maximo.Dominio.Usuario;
import com.maximo.Dominio.UsuarioHasUnidad;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iUsuarioHasUnidadDao {

    public List<UsuarioHasUnidad> findAll();

    public List<UsuarioHasUnidad> findPrestamoByidUsuario(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findPrestamoByidUnidad(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findByFecha(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findByFechaEntrega(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findByIdusuario(Usuario usuario);

    public UsuarioHasUnidad findByIdPrestamo(UsuarioHasUnidad usuariohasunidad);

    public void insertarUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad);

    public void updateUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad);

    public void deleteUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad);
}
