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
    public Autor findAutorById(Autor pautor);
    public Autor findAutorByName(Autor pautor);
    public Autor findAutorBySurname(Autor pautor);
    public Autor findAutorByNacionalidad(Autor pautor);
    public Autor findAutorByNacimiento(Autor pautor);
    public void insertarAutor(Autor pautor);
    public void updateAutor (Autor pautor);
    public void deleteAutor(Autor pautor);
}
