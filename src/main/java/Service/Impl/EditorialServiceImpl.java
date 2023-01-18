/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Datos.Interfaz.iEditorialDao;
import Dominio.Editorial;
import Service.Interfaz.iEditorialService;
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
    iEditorialDao editorialDao;
    
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
