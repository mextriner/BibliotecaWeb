/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alumno Mañana
 */
@Entity
@Table(name = "usuario_has_unidad")
@NamedQueries({
    @NamedQuery(name = "UsuarioHasUnidad.findAll", query = "SELECT u FROM UsuarioHasUnidad u"),
    @NamedQuery(name = "UsuarioHasUnidad.findByFecha", query = "SELECT u FROM UsuarioHasUnidad u WHERE u.fecha = :fecha")})
public class UsuarioHasUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "unidad_idUnidad", referencedColumnName = "idUnidad")
    @ManyToOne(optional = false)
    private Unidad unidadidUnidad;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public UsuarioHasUnidad() {
    }

    public UsuarioHasUnidad(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Unidad getUnidadidUnidad() {
        return unidadidUnidad;
    }

    public void setUnidadidUnidad(Unidad unidadidUnidad) {
        this.unidadidUnidad = unidadidUnidad;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasUnidad)) {
            return false;
        }
        UsuarioHasUnidad other = (UsuarioHasUnidad) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.maximo.Dominio.UsuarioHasUnidad[ fecha=" + fecha + " ]";
    }
    
}
