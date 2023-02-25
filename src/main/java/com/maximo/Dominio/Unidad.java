/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Maximo
 */
@Entity
@Table(name = "unidad")
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByIdUnidad", query = "SELECT u FROM Unidad u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "Unidad.findByEstado", query = "SELECT u FROM Unidad u WHERE u.estado = :estado"),
    @NamedQuery(name = "Unidad.findByProveedor", query = "SELECT u FROM Unidad u WHERE u.proveedor = :proveedor")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidad")
    private Integer idUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @Size(max = 45)
    @Column(name = "proveedor")
    private String proveedor;
    @JoinColumn(name = "libro_ISBN", referencedColumnName = "ISBN")
    @ManyToOne(optional = false)
    private Libro libroISBN;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadidUnidad")
    private List<UsuarioHasUnidad> usuarioHasUnidadList;

    public Unidad() {
    }

    public Unidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Unidad(Integer idUnidad, short estado) {
        this.idUnidad = idUnidad;
        this.estado = estado;
    }

    public Unidad(short estado, String proveedor, Libro libroISBN) {
        this.estado = estado;
        this.proveedor = proveedor;
        this.libroISBN = libroISBN;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Libro getLibroISBN() {
        return libroISBN;
    }

    public void setLibroISBN(Libro libroISBN) {
        this.libroISBN = libroISBN;
    }

    public List<UsuarioHasUnidad> getUsuarioHasUnidadList() {
        return usuarioHasUnidadList;
    }

    public void setUsuarioHasUnidadList(List<UsuarioHasUnidad> usuarioHasUnidadList) {
        this.usuarioHasUnidadList = usuarioHasUnidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.maximo.Dominio.Unidad[ idUnidad=" + idUnidad + " ]";
    }
    
}
