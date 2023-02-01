/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Interfaz;

import com.maximo.Dominio.Usuario;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iUsuarioDao {

    public List<Usuario> findAllUsuario();

    public Usuario findByIdUsuario(Usuario usuario);

    public List<Usuario> findByNombre(Usuario usuario);

    public List<Usuario> findByApellido(Usuario usuario);

    public List<Usuario> findByDireccion(Usuario usuario);

    public List<Usuario> findByFechaNAc(Usuario usuario);

    public void insertarUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void deleteUsuario(Usuario usuario);
}
