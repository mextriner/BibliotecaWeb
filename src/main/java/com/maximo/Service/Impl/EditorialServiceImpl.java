/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Service.Impl;

import com.maximo.Datos.Interfaz.iEditorialDao;
import com.maximo.Dominio.Editorial;
import com.maximo.Dominio.Libro;
import com.maximo.Service.Interfaz.iEditorialService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Alumno Mañana
 */
@Stateless
public class EditorialServiceImpl implements iEditorialService{
    
    @Inject
    private iEditorialDao editorialDao;
    
    @Override
    public List<Editorial> findAllEditorial(){
        return editorialDao.findAllEditorial();
    }
    
    public Editorial findByIdEditorial(Editorial editorial) {
        return editorialDao.findByIdEditorial(editorial);
    }
    
    @Override
    public List<Editorial> findByNombre(Editorial editorial){
        return editorialDao.findByNombre(editorial);
    }
    
    @Override
    public List<Editorial> findByDireccion(Editorial editorial){
        return editorialDao.findByDireccion(editorial);
    }
    
    @Override
    public List<Libro> findLibroByEditorial(Editorial editorial){
        return editorialDao.findLibroByEditorial(editorial);
    }
    
    @Override
    public void insertarEditorial(Editorial editorial){
        editorialDao.insertarEditorial(editorial);
    }
    
    @Override
    public void updateEditorial(Editorial editorial){
        editorialDao.updateEditorial(editorial);
    }
    
    @Override
    public void deleteEditorial(Editorial editorial){
        editorialDao.deleteEditorial(editorial);
    }
}
