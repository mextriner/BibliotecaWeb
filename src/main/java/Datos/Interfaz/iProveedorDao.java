/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Interfaz;

import Dominio.Proveedor;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public interface iProveedorDao {
    public List<Proveedor> findAllProveedor();
    public Proveedor findByIdProveedor(Proveedor proveedor);
    public List<Proveedor> findByNombre(Proveedor proveedor);
    public List<Proveedor> findByDireccion(Proveedor proveedor);
    public void insertarProveedor(Proveedor proveedor);
    public void updateProveedor(Proveedor proveedor);
    public void deleteroveedor(Proveedor proveedor);
}
