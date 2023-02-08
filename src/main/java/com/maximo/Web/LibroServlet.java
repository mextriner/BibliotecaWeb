/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Editorial;
import com.maximo.Dominio.Libro;
import com.maximo.Service.Interfaz.iLibroService;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno Mañana
 */
@WebServlet("/Libro")
@MultipartConfig
public class LibroServlet extends HttpServlet {
    

    @Inject
    iLibroService libroService;
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "insertar":
                        this.insertarLibro(request, response);
                        break;
                    case "editar":
                        //this.editarCliente(request, response);
                        break;
                    case "eliminar":
                        //this.eliminarCliente(request, response);
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
            if (accion != null){
                switch (accion){
                    case "insertar":
                        this.insertarLibro(request, response);
                        break;
                    case "editar":
                        //this.editarCliente(request, response);
                        break;
                    case "eliminar":
                        //this.eliminarCliente(request, response);
                        break;
                    default:
                        //this.accionDefault(request, response);
                }
            } else {
                //this.accionDefault(request, response);
            }
    }

    
    
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Libro> libros = libroService.findAllLibro();
        System.out.println("libros: "+ libros);
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
    
    private void insertarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String isbn = request.getParameter("ISBN");
        String titulo = request.getParameter("Titulo");
        
        
        String foto = (String)(request.getParameter("foto"));
        
        String f = request.getParameter("Fecha");
        String fe [] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]),Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());
        
        String unidades = request.getParameter("Unidades");
        String descripcion = request.getParameter("descripcion");
        String editorial = request.getParameter("editorial");
        
        
        short bestseller = Short.valueOf(request.getParameter("bestseller"));
        
        Editorial ed = new Editorial (Integer.valueOf(editorial));
        Libro libro = new Libro(isbn, titulo, fecha, bestseller, foto, descripcion, ed);
        
        libroService.insertarLibro(libro);
        this.accionDefault(request, response);
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
