/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maximo.Service.Impl;

import com.maximo.Datos.Interfaz.iUnidadDao;
import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
import com.maximo.Service.Interfaz.iUnidadService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Maximo
 */
public class UnidadServiceImpl implements iUnidadService{
    
    @Inject
    private iUnidadDao unidadDao;
    
    @Override
    public List<Unidad> findAllUnidad(){
        return unidadDao.findAllUnidad();
    }

    @Override
    public Unidad findByIdUnidad(Unidad unidad){
        return unidadDao.findByIdUnidad(unidad);
    }

    @Override
    public List<Unidad> findByEstado(Unidad unidad){
        return unidadDao.findByEstado(unidad);
    }

    @Override
    public List<Unidad> findProveedorByUnidad(Unidad unidad){
        return unidadDao.findProveedorByUnidad(unidad);
    }

    @Override
    public List<Unidad> findByLibroISBN(Libro libro){
        return unidadDao.findByLibroISBN(libro);
    }

    public Unidad findByLibroISBNLimit1(Libro libro){
        return unidadDao.findByLibroISBNLimit1(libro);
    }
    
    @Override
    public void insertarUnidad(Unidad unidad){
        unidadDao.insertarUnidad(unidad);
    }

    @Override
    public void updateUnidad(Unidad unidad){
        unidadDao.updateUnidad(unidad);
    }

    @Override
    public void deleteUnidad(Unidad unidad){
        unidadDao.deleteUnidad(unidad);
    }


    
}
