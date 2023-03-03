/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Service.Interfaz;

import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno Mañana
 */
@Local
public interface iUnidadService {
    
    public List<Unidad> findAllUnidad();

    public Unidad findByIdUnidad(Unidad unidad);

    public List<Unidad> findByEstado(Unidad unidad);

    public List<Unidad> findProveedorByUnidad(Unidad unidad);

    public List<Unidad> findByLibroISBN(Unidad unidad);
    
    public Unidad findByLibroISBNLimit1(Libro libro);

    public void insertarUnidad(Unidad unidad);

    public void updateUnidad(Unidad unidad);

    public void deleteUnidad(Unidad unidad);

}
