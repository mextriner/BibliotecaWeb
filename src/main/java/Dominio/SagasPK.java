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
public class SagasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "Libro_ISBN")
    private String libroISBN;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GrupoLibro_idGrupo")
    private int grupoLibroidGrupo;

    public SagasPK() {
    }

    public SagasPK(String libroISBN, int grupoLibroidGrupo) {
        this.libroISBN = libroISBN;
        this.grupoLibroidGrupo = grupoLibroidGrupo;
    }

    public String getLibroISBN() {
        return libroISBN;
    }

    public void setLibroISBN(String libroISBN) {
        this.libroISBN = libroISBN;
    }

    public int getGrupoLibroidGrupo() {
        return grupoLibroidGrupo;
    }

    public void setGrupoLibroidGrupo(int grupoLibroidGrupo) {
        this.grupoLibroidGrupo = grupoLibroidGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libroISBN != null ? libroISBN.hashCode() : 0);
        hash += (int) grupoLibroidGrupo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SagasPK)) {
            return false;
        }
        SagasPK other = (SagasPK) object;
        if ((this.libroISBN == null && other.libroISBN != null) || (this.libroISBN != null && !this.libroISBN.equals(other.libroISBN))) {
            return false;
        }
        if (this.grupoLibroidGrupo != other.grupoLibroidGrupo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.SagasPK[ libroISBN=" + libroISBN + ", grupoLibroidGrupo=" + grupoLibroidGrupo + " ]";
    }
    
}
