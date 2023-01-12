/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alumno Mañana
 */
@Embeddable
public class UnidadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idUnidad")
    private int idUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Proveedor_idProveedor")
    private int proveedoridProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "Libro_ISBN")
    private String libroISBN;

    public UnidadPK() {
    }

    public UnidadPK(int idUnidad, int proveedoridProveedor, String libroISBN) {
        this.idUnidad = idUnidad;
        this.proveedoridProveedor = proveedoridProveedor;
        this.libroISBN = libroISBN;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public int getProveedoridProveedor() {
        return proveedoridProveedor;
    }

    public void setProveedoridProveedor(int proveedoridProveedor) {
        this.proveedoridProveedor = proveedoridProveedor;
    }

    public String getLibroISBN() {
        return libroISBN;
    }

    public void setLibroISBN(String libroISBN) {
        this.libroISBN = libroISBN;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUnidad;
        hash += (int) proveedoridProveedor;
        hash += (libroISBN != null ? libroISBN.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadPK)) {
            return false;
        }
        UnidadPK other = (UnidadPK) object;
        if (this.idUnidad != other.idUnidad) {
            return false;
        }
        if (this.proveedoridProveedor != other.proveedoridProveedor) {
            return false;
        }
        if ((this.libroISBN == null && other.libroISBN != null) || (this.libroISBN != null && !this.libroISBN.equals(other.libroISBN))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.UnidadPK[ idUnidad=" + idUnidad + ", proveedoridProveedor=" + proveedoridProveedor + ", libroISBN=" + libroISBN + " ]";
    }
    
}
