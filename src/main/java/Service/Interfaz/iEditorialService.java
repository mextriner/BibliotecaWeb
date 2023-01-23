/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interfaz;

import Dominio.Editorial;
import Dominio.Libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno Mañana
 */
@Local
public interface iEditorialService {
    public List<Editorial> findAllEditorial();
    
    public Editorial findByIdEditorial(Editorial editorial);
    
    public List<Editorial> findByNombre(Editorial editorial);
    
    public List<Editorial> findByDireccion(Editorial editorial);
    
    public List<Libro> findLibroByEditorial(Editorial editorial);
    
    public void insertarEditorial(Editorial editorial);
    
    public void updateEditorial(Editorial editorial);
    
    public void deleteEditorial(Editorial editorial);
}
