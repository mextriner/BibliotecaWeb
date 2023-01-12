/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alumno Mañana
 */
@Entity
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByIdUnidad", query = "SELECT u FROM Unidad u WHERE u.unidadPK.idUnidad = :idUnidad"),
    @NamedQuery(name = "Unidad.findByEstado", query = "SELECT u FROM Unidad u WHERE u.estado = :estado"),
    @NamedQuery(name = "Unidad.findByProveedoridProveedor", query = "SELECT u FROM Unidad u WHERE u.unidadPK.proveedoridProveedor = :proveedoridProveedor"),
    @NamedQuery(name = "Unidad.findByLibroISBN", query = "SELECT u FROM Unidad u WHERE u.unidadPK.libroISBN = :libroISBN")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UnidadPK unidadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "Libro_ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro;
    @JoinColumn(name = "Proveedor_idProveedor", referencedColumnName = "idProveedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad")
    private List<UsuarioHasUnidad> usuarioHasUnidadList;

    public Unidad() {
    }

    public Unidad(UnidadPK unidadPK) {
        this.unidadPK = unidadPK;
    }

    public Unidad(UnidadPK unidadPK, String estado) {
        this.unidadPK = unidadPK;
        this.estado = estado;
    }

    public Unidad(int idUnidad, int proveedoridProveedor, String libroISBN) {
        this.unidadPK = new UnidadPK(idUnidad, proveedoridProveedor, libroISBN);
    }

    public UnidadPK getUnidadPK() {
        return unidadPK;
    }

    public void setUnidadPK(UnidadPK unidadPK) {
        this.unidadPK = unidadPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @XmlTransient
    public List<UsuarioHasUnidad> getUsuarioHasUnidadList() {
        return usuarioHasUnidadList;
    }

    public void setUsuarioHasUnidadList(List<UsuarioHasUnidad> usuarioHasUnidadList) {
        this.usuarioHasUnidadList = usuarioHasUnidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadPK != null ? unidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.unidadPK == null && other.unidadPK != null) || (this.unidadPK != null && !this.unidadPK.equals(other.unidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Unidad[ unidadPK=" + unidadPK + " ]";
    }
    
}
