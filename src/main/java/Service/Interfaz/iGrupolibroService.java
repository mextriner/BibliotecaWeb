/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interfaz;

import Dominio.Grupolibro;
import Dominio.Libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno Mañana
 */
@Local
public interface iGrupolibroService {
        
    public List<Grupolibro> findAllGrupoLibro();
    
    public Grupolibro findByIdGrupo(Grupolibro grupoLibro);
    
    public List<Grupolibro> findByNombre(Grupolibro grupoLibro);
    
    public List<Libro> findLibroByGrupo(Grupolibro grupoLibro);
    
    public void insertarGrupoLibro(Grupolibro grupoLibro);
    
    public void updateGrupoLibro(Grupolibro grupoLibro);
    
    public void deleteGrupoLibro(Grupolibro grupoLibro);
}
