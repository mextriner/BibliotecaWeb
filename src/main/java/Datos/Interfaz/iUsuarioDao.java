/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iUsuarioDao {
    public List<Usuario> findAllUsuario();
    public Usuario findByIdUsuario(Usuario usuario);
    public Usuario findByNombre(Usuario usuario);
    public Usuario findByApellido(Usuario usuario);
    public Usuario findByDireccion(Usuario usuario);
    public Usuario findByFechaNAc(Usuario usuario);
    public void insertarUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
}
