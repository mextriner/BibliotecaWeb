/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Autor;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iAutorDao {
    public List<Autor> findAllAutor();
    public Autor findAutorById(Autor autor);
    public Autor findAutorByName(Autor autor);
    public Autor findAutorBySurname(Autor autor);
    public Autor findAutorByNacionalidad(Autor autor);
    public Autor findAutorByNacimiento(Autor autor);
    public void insertarAutor(Autor autor);
    public void updateAutor (Autor autor);
    public void deleteAutor(Autor autor);
}
