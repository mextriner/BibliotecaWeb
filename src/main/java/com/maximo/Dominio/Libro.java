/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Maximo
 */

@Entity
@Table(name = "libro")
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByFechaPublicacion", query = "SELECT l FROM Libro l WHERE l.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "Libro.findByBestSeller", query = "SELECT l FROM Libro l WHERE l.bestSeller = :bestSeller"),
    @NamedQuery(name = "Libro.findByPortada", query = "SELECT l FROM Libro l WHERE l.portada = :portada")})
public class Libro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fechaPublicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Column(name = "bestSeller")
    private Short bestSeller;
    @Size(max = 140)
    @Column(name = "portada")
    private String portada;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "libroList")
    private List<Categoria> categoriaList;
    @ManyToMany(mappedBy = "libroList")
    private List<Grupolibro> grupolibroList;
    @ManyToMany(mappedBy = "libroList")
    private List<Autor> autorList;
    @JoinColumn(name = "editorial_idEditorial", referencedColumnName = "idEditorial")
    @ManyToOne(optional = false)
    private Editorial editorialidEditorial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libroISBN")
    private List<Unidad> unidadList;

    public Libro() {
    }

    
    
    public Libro(String isbn, String titulo, Date fechaPublicacion, Short bestSeller, String portada, String descripcion, Editorial editorialidEditorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.bestSeller = bestSeller;
        this.portada = portada;
        this.descripcion = descripcion;
        this.editorialidEditorial = editorialidEditorial;
    }

    public Libro(String isbn) {
        this.isbn = isbn;
    }

    public Libro(String isbn, String titulo, Date fechaPublicacion, Short bestSeller, String portada, String descripcion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.bestSeller = bestSeller;
        this.portada = portada;
        this.descripcion = descripcion;
    }
    
    

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Short getBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(Short bestSeller) {
        this.bestSeller = bestSeller;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public List<Grupolibro> getGrupolibroList() {
        return grupolibroList;
    }

    public void setGrupolibroList(List<Grupolibro> grupolibroList) {
        this.grupolibroList = grupolibroList;
    }

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    public Editorial getEditorialidEditorial() {
        return editorialidEditorial;
    }

    public void setEditorialidEditorial(Editorial editorialidEditorial) {
        this.editorialidEditorial = editorialidEditorial;
    }

    public List<Unidad> getUnidadList() {
        return unidadList;
    }

    public void setUnidadList(List<Unidad> unidadList) {
        this.unidadList = unidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "com.maximo.Dominio.Libro[ isbn=" + isbn + " ]";
    }

}
