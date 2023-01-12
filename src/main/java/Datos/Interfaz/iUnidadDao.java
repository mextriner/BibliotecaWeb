/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Unidad;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iUnidadDao {
    public List<Unidad> findAllUnidad();
    public Unidad findByIdUnidad(Unidad unidad);
    public Unidad findByEstado(Unidad unidad);
    public Unidad findByProveedoridProveedor(Unidad unidad);
    public Unidad findByLibroISBN(Unidad unidad);
    public void insertarUnidad(Unidad unidad);
    public void updateUnidad(Unidad unidad);
    public void deleteUnidad(Unidad unidad);
}
