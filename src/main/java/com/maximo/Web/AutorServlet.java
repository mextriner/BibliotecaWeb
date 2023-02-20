/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Autor;
import com.maximo.Service.Interfaz.iAutorService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno Mañana
 */
@WebServlet(name = "AutorServlet", urlPatterns = {"/Autor"})
public class AutorServlet extends HttpServlet {

    @Inject
    iAutorService autorService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarAutor(request, response);
                    break;
                case "editar":
                    //this.editarCliente(request, response);
                    break;
                case "eliminar":
                    //this.eliminarCliente(request, response);
                    break;
                case "listar":
                    //this.listarLibro(request, response);
                    break;
                default:
                //this.accionDefault(request, response);
                }
        } else {
            //this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarAutor(request, response);
                    break;
                case "editar":
                    //this.editarCliente(request, response);
                    break;
                case "eliminar":
                    //this.eliminarCliente(request, response);
                    break;
                case "listar":
                    //this.listarLibro(request, response);
                    break;
                default:
                //this.accionDefault(request, response);
                }
        } else {
            //this.accionDefault(request, response);
        }
    }
    
    private void insertarAutor(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nacionalidad = request.getParameter("nacionalidad");

        String f = request.getParameter("fecha");
        String fe[] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]), Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());
        
        Autor autor = new Autor(nombre,apellido,nacionalidad,fecha);
        autorService.insertarAutor(autor);
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
