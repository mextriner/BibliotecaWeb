/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import Datos.Interfaz.iAutorDao;
import Dominio.Autor;
import Dominio.Libro;
import Service.Interfaz.iAutorService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Alumno Mañana
 */
@Stateless
public class AutorServiceImpl implements iAutorService {

    @Inject
    private iAutorDao autorDao;

    @Override
    public List<Autor> findAllAutor() {
        return autorDao.findAllAutor();
    }

    @Override
    public Autor findById(Autor autor) {
        return autorDao.findById(autor);
    }

    @Override
    public List<Autor> findByName(Autor autor) {
        return autorDao.findByName(autor);
    }

    @Override
    public List<Autor> findBySurname(Autor autor) {
        return autorDao.findBySurname(autor);
    }

    @Override
    public List<Autor> findByNacionalidad(Autor autor) {
        return autorDao.findByNacionalidad(autor);
    }

    @Override
    public List<Autor> findByNacimiento(Autor autor) {
        return autorDao.findByNacimiento(autor);
    }

    @Override
    public List<Libro> findLibroByAutor(Autor autor) {
        return autorDao.findLibroByAutor(autor);
    }

    @Override
    public boolean existAutor(Autor autor) {
        boolean ex = false;
        List <Autor> autores = findAllAutor();
        String aut = autor.getApellido().concat(autor.getNombre());
        for (int i = 0; i < autores.size(); i++) {
            String aut2 = autores.get(i).getApellido().concat(autor.getNombre());
            if (aut.equals(aut2)) {
                ex = true;
            }
        }
        return ex;
    }

    @Override
    public void insertarAutor(Autor autor) {
        autorDao.insertarAutor(autor);
    }

    @Override
    public void updateAutor(Autor autor) {
        autorDao.updateAutor(autor);
    }

    @Override
    public void deleteAutor(Autor autor) {
        autorDao.deleteAutor(autor);
    }
}
