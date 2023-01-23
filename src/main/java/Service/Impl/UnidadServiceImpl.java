/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Datos.Interfaz.iUnidadDao;
import Dominio.Unidad;
import Service.Interfaz.iUnidadService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Maximo
 */
public class UnidadServiceImpl implements iUnidadService{
    
    @Inject
    private iUnidadDao unidadDao;
    
       
    public List<Unidad> findAllUnidad(){
        return unidadDao.findAllUnidad();
    }

    public Unidad findByIdUnidad(Unidad unidad){
        return unidadDao.findByIdUnidad(unidad);
    }

    public List<Unidad> findByEstado(Unidad unidad){
        return unidadDao.findByEstado(unidad);
    }

    public List<Unidad> findProveedorByUnidad(Unidad unidad){
        return unidadDao.findProveedorByUnidad(unidad);
    }

    public List<Unidad> findByLibroISBN(Unidad unidad){
        return unidadDao.findByLibroISBN(unidad);
    }

    public void insertarUnidad(Unidad unidad){
        unidadDao.insertarUnidad(unidad);
    }

    public void updateUnidad(Unidad unidad){
        unidadDao.updateUnidad(unidad);
    }

    public void deleteUnidad(Unidad unidad){
        unidadDao.deleteUnidad(unidad);
    }


    
}
