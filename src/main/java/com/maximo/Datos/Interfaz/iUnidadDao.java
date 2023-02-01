/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Datos.Interfaz;

import com.maximo.Dominio.Unidad;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iUnidadDao {

    public List<Unidad> findAllUnidad();

    public Unidad findByIdUnidad(Unidad unidad);

    public List<Unidad> findByEstado(Unidad unidad);

    public List<Unidad> findProveedorByUnidad(Unidad unidad);

    public List<Unidad> findByLibroISBN(Unidad unidad);

    public void insertarUnidad(Unidad unidad);

    public void updateUnidad(Unidad unidad);

    public void deleteUnidad(Unidad unidad);
}
