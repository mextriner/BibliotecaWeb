/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Datos.Interfaz.iLibroDao;
import Dominio.Autor;
import Dominio.Categoria;
import Dominio.Libro;
import Dominio.Unidad;
import Service.Interfaz.iLibroService;
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
    public List<Libro> findByTitulo(Libro libro){
        return libroDao.findByTitulo(libro);
    }

    @Override
    public List<Libro> findByFechaPublicacion(Libro libro){
        return libroDao.findByFechaPublicacion(libro);
    }

    @Override
    public List<Libro> findByBestSeller(Libro libro){
        return libroDao.findByBestSeller(libro);
    }

    @Override
    public List<Autor> findAutorByLibro(Libro libro){
        return libroDao.findAutorByLibro(libro);
    }

    @Override
    public List<Categoria> findCategoriaByLibro(Libro libro){
        return libroDao.findCategoriaByLibro(libro);
    }

    @Override
    public List<Unidad> findUidadByLibro(Libro libro){
        return libroDao.findUidadByLibro(libro);
    }

    @Override
    public void insertarLibro(Libro libro){
        libroDao.insertarLibro(libro);
    }

    @Override
    public void updateLibro(Libro libro){
        libroDao.updateLibro(libro);
    }

    @Override
    public void deleteLibro(Libro libro){
        libroDao.deleteLibro(libro);
    }
}
