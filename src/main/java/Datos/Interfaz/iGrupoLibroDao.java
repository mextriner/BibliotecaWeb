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
    public List<Grupolibro> findByNombre(Grupolibro grupoLibro);
    public void insertarGrupoLibro(Grupolibro grupoLibro);
    public void updateGrupoLibro(Grupolibro grupoLibro);
    public void deleteGrupoLibro(Grupolibro grupoLibro);
}
