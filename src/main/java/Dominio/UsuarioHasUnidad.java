/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno Mañana
 */
@Entity
@Table(name = "usuario_has_unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasUnidad.findAll", query = "SELECT u FROM UsuarioHasUnidad u"),
    @NamedQuery(name = "UsuarioHasUnidad.findByUsuarioidUsuario", query = "SELECT u FROM UsuarioHasUnidad u WHERE u.usuarioHasUnidadPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "UsuarioHasUnidad.findByUnidadidUnidad", query = "SELECT u FROM UsuarioHasUnidad u WHERE u.usuarioHasUnidadPK.unidadidUnidad = :unidadidUnidad"),
    @NamedQuery(name = "UsuarioHasUnidad.findByFecha", query = "SELECT u FROM UsuarioHasUnidad u WHERE u.usuarioHasUnidadPK.fecha = :fecha")})
public class UsuarioHasUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasUnidadPK usuarioHasUnidadPK;
    @JoinColumn(name = "Unidad_idUnidad", referencedColumnName = "idUnidad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unidad unidad;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioHasUnidad() {
    }

    public UsuarioHasUnidad(UsuarioHasUnidadPK usuarioHasUnidadPK) {
        this.usuarioHasUnidadPK = usuarioHasUnidadPK;
    }

    public UsuarioHasUnidad(String usuarioidUsuario, int unidadidUnidad, String fecha) {
        this.usuarioHasUnidadPK = new UsuarioHasUnidadPK(usuarioidUsuario, unidadidUnidad, fecha);
    }

    public UsuarioHasUnidadPK getUsuarioHasUnidadPK() {
        return usuarioHasUnidadPK;
    }

    public void setUsuarioHasUnidadPK(UsuarioHasUnidadPK usuarioHasUnidadPK) {
        this.usuarioHasUnidadPK = usuarioHasUnidadPK;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasUnidadPK != null ? usuarioHasUnidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasUnidad)) {
            return false;
        }
        UsuarioHasUnidad other = (UsuarioHasUnidad) object;
        if ((this.usuarioHasUnidadPK == null && other.usuarioHasUnidadPK != null) || (this.usuarioHasUnidadPK != null && !this.usuarioHasUnidadPK.equals(other.usuarioHasUnidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.UsuarioHasUnidad[ usuarioHasUnidadPK=" + usuarioHasUnidadPK + " ]";
    }
    
}
