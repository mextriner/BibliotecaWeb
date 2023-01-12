/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Grupolibro;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iGrupoLibroDao {
    public List<Grupolibro> findAllGrupoLibro();
    public Grupolibro findByIdGrupo(Grupolibro grupoLibro);
    public Grupolibro findByNombre(Grupolibro grupoLibro);
    public void insertarAutor(Grupolibro grupoLibro);
    public void updateAutor (Grupolibro grupoLibro);
    public void deleteAutor(Grupolibro grupoLibro);
}
