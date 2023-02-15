/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Interfaz;

import com.maximo.Dominio.Autor;
import com.maximo.Dominio.Libro;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iAutorDao {

    public List<Autor> findAllAutor();

    public Autor findByIdAutor(Autor autor);

    public List<Autor> findByName(Autor autor);

    public List<Autor> findBySurname(Autor autor);

    public List<Autor> findByNacionalidad(Autor autor);

    public List<Autor> findByNacimiento(Autor autor);

    public List<Libro> findLibroByAutor(Autor autor);

    public void insertarAutor(Autor autor);

    public void updateAutor(Autor autor);

    public void deleteAutor(Autor autor);
}
