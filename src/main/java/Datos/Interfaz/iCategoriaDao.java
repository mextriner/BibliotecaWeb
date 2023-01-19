/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Categoria;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iCategoriaDao {
    public List<Categoria> findAllCategoria();
    
    public Categoria findByIdCategoria(Categoria categoria);
    
    public Categoria findByNombre(Categoria categoria);
    
    public Categoria findByDescripcion(Categoria categoria);
    
    public void insertarCategoria(Categoria categoria);
    
    public void updateCategoria (Categoria categoria);
    
    public void deleteCategoria(Categoria categoria);
}
