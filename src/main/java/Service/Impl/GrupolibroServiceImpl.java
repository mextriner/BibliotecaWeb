/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;


import Datos.Interfaz.iGrupoLibroDao;
import Dominio.Grupolibro;
import Dominio.Libro;
import Service.Interfaz.iGrupolibroService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Alumno Mañana
 */
public class GrupolibroServiceImpl implements iGrupolibroService{
    
    @Inject
    private iGrupoLibroDao grupolibroDao; 
    
    
    @Override
    public List<Grupolibro> findAllGrupoLibro(){
        return grupolibroDao.findAllGrupoLibro();
    }
    
    @Override
    public Grupolibro findByIdGrupo(Grupolibro grupoLibro){
        return grupolibroDao.findByIdGrupo(grupoLibro);
    }
    
    @Override
    public List<Grupolibro> findByNombre(Grupolibro grupoLibro){
        return grupolibroDao.findByNombre(grupoLibro);
    }
    
    @Override
    public List<Libro> findLibroByGrupo(Grupolibro grupoLibro){
        return grupolibroDao.findLibroByGrupo(grupoLibro);
    }
    
    @Override
    public void insertarGrupoLibro(Grupolibro grupoLibro){
        grupolibroDao.insertarGrupoLibro(grupoLibro);
    }
    
    @Override
    public void updateGrupoLibro(Grupolibro grupoLibro){
        grupolibroDao.updateGrupoLibro(grupoLibro);
    }
    
    @Override
    public void deleteGrupoLibro(Grupolibro grupoLibro){
        grupolibroDao.deleteGrupoLibro(grupoLibro);
    }
}
