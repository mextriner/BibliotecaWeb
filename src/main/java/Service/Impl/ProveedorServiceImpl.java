/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Datos.Interfaz.iProveedorDao;
import Dominio.Proveedor;
import Dominio.Unidad;
import Service.Interfaz.iProveedorService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Maximo
 */
public class ProveedorServiceImpl implements iProveedorService{
    
    @Inject
    private iProveedorDao proveedorDao;
    
    @Override
    public List<Proveedor> findAllProveedor(){
        return proveedorDao.findAllProveedor();
    }

    @Override
    public Proveedor findByIdProveedor(Proveedor proveedor){
        return proveedorDao.findByIdProveedor(proveedor);
    }

    @Override
    public List<Proveedor> findByNombre(Proveedor proveedor){
        return proveedorDao.findByNombre(proveedor);
    }

    @Override
    public List<Proveedor> findByDireccion(Proveedor proveedor){
        return proveedorDao.findByDireccion(proveedor);
    }

    @Override
    public List<Unidad> findUnidadByProveedor(Proveedor proveedor){
        return proveedorDao.findUnidadByProveedor(proveedor);
    }

    @Override
    public void insertarProveedor(Proveedor proveedor){
        proveedorDao.insertarProveedor(proveedor);
    }

    @Override
    public void updateProveedor(Proveedor proveedor){
        proveedorDao.updateProveedor(proveedor);
    }

    @Override
    public void deleteroveedor(Proveedor proveedor){
        proveedorDao.deleteroveedor(proveedor);
    }

}
