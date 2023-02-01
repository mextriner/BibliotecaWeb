/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alumno Mañana
 */
@Entity
@Table(name = "grupolibro")
@NamedQueries({
    @NamedQuery(name = "Grupolibro.findAll", query = "SELECT g FROM Grupolibro g"),
    @NamedQuery(name = "Grupolibro.findByIdGrupo", query = "SELECT g FROM Grupolibro g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "Grupolibro.findByNombre", query = "SELECT g FROM Grupolibro g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grupolibro.findByTipo", query = "SELECT g FROM Grupolibro g WHERE g.tipo = :tipo")})
public class Grupolibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGrupo")
    private Integer idGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo")
    private String tipo;
    @JoinTable(name = "sagas", joinColumns = {
        @JoinColumn(name = "GrupoLibro_idGrupo", referencedColumnName = "idGrupo")}, inverseJoinColumns = {
        @JoinColumn(name = "Libro_ISBN", referencedColumnName = "ISBN")})
    @ManyToMany
    private List<Libro> libroList;

    public Grupolibro() {
    }

    public Grupolibro(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Grupolibro(Integer idGrupo, String nombre, String tipo) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupolibro)) {
            return false;
        }
        Grupolibro other = (Grupolibro) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.maximo.Dominio.Grupolibro[ idGrupo=" + idGrupo + " ]";
    }
    
}
