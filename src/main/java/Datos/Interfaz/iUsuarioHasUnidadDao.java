/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Unidad;
import Dominio.Usuario;
import Dominio.UsuarioHasUnidad;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iUsuarioHasUnidadDao {

    public List<UsuarioHasUnidad> findByUsuarioidUsuario(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findByUnidadidUnidad(UsuarioHasUnidad usuariohasunidad);

    public List<UsuarioHasUnidad> findByFecha(UsuarioHasUnidad usuariohasunidad);
    
    public List<Usuario> findUsuarioByUnidad(UsuarioHasUnidad usuariohasunidad);
    
    public List<Unidad> findUnidadByUsuario(UsuarioHasUnidad usuariohasunidad);
}
