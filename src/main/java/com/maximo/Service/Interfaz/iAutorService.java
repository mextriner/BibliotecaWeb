/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Service.Interfaz;

import com.maximo.Dominio.Autor;
import com.maximo.Dominio.Libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno Mañana
 */
@Local
public interface iAutorService {
    
    public List<Autor> findAllAutor();
    
    public Autor findById(Autor autor);
    
    public List<Autor> findByName(Autor autor);
    
    public List<Autor> findBySurname(Autor autor);
    
    public List<Autor> findByNacionalidad(Autor autor);
    
    public List<Autor> findByNacimiento(Autor autor);
    
    public List<Libro> findLibroByAutor(Autor autor);
    
    public boolean existAutor(Autor autor);

    public void insertarAutor(Autor autor);
    
    public void updateAutor (Autor autor);
    
    public void deleteAutor(Autor autor);
}
