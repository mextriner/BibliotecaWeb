/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maximo.Service.Impl;

import com.maximo.Datos.Interfaz.iLibroDao;
import com.maximo.Dominio.Autor;
import com.maximo.Dominio.Categoria;
import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
import com.maximo.Service.Interfaz.iLibroService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Maximo
 */
public class LibroServiceImpl implements iLibroService {

    @Inject
    private iLibroDao libroDao;

    @Override
    public List<Libro> findAllLibro() {
        return libroDao.findAllLibro();
    }

    @Override
    public Libro findByIsbn(Libro libro) {
        return libroDao.findByIsbn(libro);
    }

    @Override
    public List<Libro> findByTitulo(Libro libro) {
        return libroDao.findByTitulo(libro);
    }

    @Override
    public List<Libro> findByFechaPublicacion(Libro libro) {
        return libroDao.findByFechaPublicacion(libro);
    }

    @Override
    public List<Libro> buscadorLibroBestseller(String bus, short bestseller) {
        return libroDao.buscadorLibroBestseller(bus, bestseller);
    }

    @Override
    public List<Libro> buscadorLibro(String bus) {
        return libroDao.buscadorLibro(bus);
    }

    @Override
    public List<Libro> findByBestSeller(Libro libro) {
        return libroDao.findByBestSeller(libro);
    }

    @Override
    public List<Autor> findAutorByLibro(Libro libro) {
        return libroDao.findAutorByLibro(libro);
    }

    @Override
    public List<Categoria> findCategoriaByLibro(Libro libro) {
        return libroDao.findCategoriaByLibro(libro);
    }

    @Override
    public List<Unidad> findUnidadByLibro(Libro libro) {
        return libroDao.findUnidadByLibro(libro);
    }

    @Override
    public void insertarLibro(Libro libro) {
        libroDao.insertarLibro(libro);
    }

    @Override
    public void updateLibro(Libro libro) {
        libroDao.updateLibro(libro);
    }

    @Override
    public void deleteLibro(Libro libro) {
        libroDao.deleteLibro(libro);
    }
}
