/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Libro;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iLibroDao {
    public List<Libro> findAllLibro();
    public Libro findByIsbn(Libro libro);
    public Libro findByTitulo(Libro libro);
    public Libro findByFechaPublicacion(Libro libro);
    public Libro findByBestSeller(Libro libro);
    public void insertarLibro(Libro libro);
    public void updateLibro(Libro libro);
    public void deleteLibro(Libro libro);
}
