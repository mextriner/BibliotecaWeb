/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alumno Mañana
 */
@Stateless
public class EditorialDaoImpl {
    @PersistenceContext(unitName="com.ceep_BibliotecaWeb_war_1.0-SNAPSHOTPU")
    EntityManager em;
}
