/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno Mañana
 */
@Entity
@Table(name = "sagas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sagas.findAll", query = "SELECT s FROM Sagas s"),
    @NamedQuery(name = "Sagas.findByLibroISBN", query = "SELECT s FROM Sagas s WHERE s.sagasPK.libroISBN = :libroISBN"),
    @NamedQuery(name = "Sagas.findByGrupoLibroidGrupo", query = "SELECT s FROM Sagas s WHERE s.sagasPK.grupoLibroidGrupo = :grupoLibroidGrupo")})
public class Sagas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SagasPK sagasPK;

    public Sagas() {
    }

    public Sagas(SagasPK sagasPK) {
        this.sagasPK = sagasPK;
    }

    public Sagas(String libroISBN, int grupoLibroidGrupo) {
        this.sagasPK = new SagasPK(libroISBN, grupoLibroidGrupo);
    }

    public SagasPK getSagasPK() {
        return sagasPK;
    }

    public void setSagasPK(SagasPK sagasPK) {
        this.sagasPK = sagasPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sagasPK != null ? sagasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sagas)) {
            return false;
        }
        Sagas other = (Sagas) object;
        if ((this.sagasPK == null && other.sagasPK != null) || (this.sagasPK != null && !this.sagasPK.equals(other.sagasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Sagas[ sagasPK=" + sagasPK + " ]";
    }
    
}
