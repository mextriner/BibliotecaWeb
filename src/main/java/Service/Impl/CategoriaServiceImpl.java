/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Datos.Interfaz.iCategoriaDao;
import Dominio.Categoria;
import Dominio.Libro;
import Service.Interfaz.iCategoriaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Alumno Mañana
 */

@Stateless
public class CategoriaServiceImpl implements iCategoriaService{
    @Inject
    private iCategoriaDao categoriaDao;
    
    
    @Override
    public List<Categoria> findAllCategoria(){
        return categoriaDao.findAllCategoria();
    }
    
    @Override
    public Categoria findByIdCategoria(Categoria categoria){
        return categoriaDao.findByIdCategoria(categoria);
    }
    
    @Override
    public Categoria findByNombre(Categoria categoria){
        return categoriaDao.findByNombre(categoria);
    }
    
    @Override
    public Categoria findByDescripcion(Categoria categoria){
        return categoriaDao.findByDescripcion(categoria);
    }
    
    @Override
    public List<Libro> findLibroByCategoria(Categoria categoria){
        return categoriaDao.findLibroByCategoria(categoria);
    }
    
    @Override
    public void insertarCategoria(Categoria categoria){
        categoriaDao.insertarCategoria(categoria);
    }
    
    @Override
    public void updateCategoria (Categoria categoria){
        categoriaDao.updateCategoria(categoria);
    }
    
    @Override
    public void deleteCategoria(Categoria categoria){
        categoriaDao.deleteCategoria(categoria);
    }
}
