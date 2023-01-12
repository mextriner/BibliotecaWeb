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
public class UsuarioHasUnidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Usuario_idUsuario")
    private String usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Unidad_idUnidad")
    private int unidadidUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha")
    private String fecha;

    public UsuarioHasUnidadPK() {
    }

    public UsuarioHasUnidadPK(String usuarioidUsuario, int unidadidUnidad, String fecha) {
        this.usuarioidUsuario = usuarioidUsuario;
        this.unidadidUnidad = unidadidUnidad;
        this.fecha = fecha;
    }

    public String getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(String usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getUnidadidUnidad() {
        return unidadidUnidad;
    }

    public void setUnidadidUnidad(int unidadidUnidad) {
        this.unidadidUnidad = unidadidUnidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioidUsuario != null ? usuarioidUsuario.hashCode() : 0);
        hash += (int) unidadidUnidad;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasUnidadPK)) {
            return false;
        }
        UsuarioHasUnidadPK other = (UsuarioHasUnidadPK) object;
        if ((this.usuarioidUsuario == null && other.usuarioidUsuario != null) || (this.usuarioidUsuario != null && !this.usuarioidUsuario.equals(other.usuarioidUsuario))) {
            return false;
        }
        if (this.unidadidUnidad != other.unidadidUnidad) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.UsuarioHasUnidadPK[ usuarioidUsuario=" + usuarioidUsuario + ", unidadidUnidad=" + unidadidUnidad + ", fecha=" + fecha + " ]";
    }
    
}
