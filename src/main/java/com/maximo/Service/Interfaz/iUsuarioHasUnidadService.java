/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maximo.Service.Interfaz;

import com.maximo.Dominio.UsuarioHasUnidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maximo
 */
@Local
public interface iUsuarioHasUnidadService {

    public List<UsuarioHasUnidad> findPrestamoByidUsuario(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findPrestamoByidUnidad(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findByFecha(UsuarioHasUnidad usuariohasunidad);

    public void insertarUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad);

    public void updateUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad);

    public void deleteUsuarioHasUnidad(UsuarioHasUnidad usuariohasunidad);

}
