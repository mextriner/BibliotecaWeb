/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interfaz;

import Dominio.Autor;
import Dominio.Categoria;
import Dominio.Libro;
import Dominio.Unidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno Mañana
 */
@Local
public interface iLibroService {
    
    public List<Libro> findAllLibro();

    public Libro findByIsbn(Libro libro);

    public List<Libro> findByTitulo(Libro libro);

    public List<Libro> findByFechaPublicacion(Libro libro);

    public List<Libro> findByBestSeller(Libro libro);

    public List<Autor> findAutorByLibro(Libro libro);

    public List<Categoria> findCategoriaByLibro(Libro libro);
    
    public List<Unidad> findUnidadByLibro(Libro libro);

    public void insertarLibro(Libro libro);

    public void updateLibro(Libro libro);

    public void deleteLibro(Libro libro);
}
