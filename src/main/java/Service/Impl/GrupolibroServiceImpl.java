/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;


import Datos.Interfaz.iGrupoLibroDao;
import Dominio.Grupolibro;
import Service.Interfaz.iGrupolibroService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Alumno Mañana
 */
public class GrupolibroServiceImpl implements iGrupolibroService{
    
    @Inject
    iGrupoLibroDao grupolibroDao; 
    
    public List<Grupolibro> findAllGrupoLibro(){
        return grupolibroDao.findAllGrupoLibro();
    }
    
    public Grupolibro findByIdGrupo(Grupolibro grupoLibro){
        return grupolibroDao.findByIdGrupo(grupoLibro);
    }
    
    public List<Grupolibro> findByNombre(Grupolibro grupoLibro){
        return grupolibroDao.findByNombre(grupoLibro);
    }
    
    public void insertarGrupoLibro(Grupolibro grupoLibro){
        
    }
    
    public void updateGrupoLibro(Grupolibro grupoLibro){
        
    }
    
    public void deleteGrupoLibro(Grupolibro grupoLibro){
        
    }
}
