/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Interfaz;

import Dominio.Proveedor;
import Dominio.Unidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alumno Mañana
 */
@Local
public interface iProveedorService {
    
    public List<Proveedor> findAllProveedor();

    public Proveedor findByIdProveedor(Proveedor proveedor);

    public List<Proveedor> findByNombre(Proveedor proveedor);

    public List<Proveedor> findByDireccion(Proveedor proveedor);

    public List<Unidad> findUnidadByProveedor(Proveedor proveedor);

    public void insertarProveedor(Proveedor proveedor);

    public void updateProveedor(Proveedor proveedor);

    public void deleteroveedor(Proveedor proveedor);

}
