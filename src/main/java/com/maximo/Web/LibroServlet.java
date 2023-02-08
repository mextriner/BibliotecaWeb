/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Editorial;
import com.maximo.Dominio.Libro;
import com.maximo.Service.Interfaz.iLibroService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LibroServlet", urlPatterns = {"/Libro"})
public class LibroServlet extends HttpServlet {

    @Inject
    iLibroService libroService;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String portada = request.getParameter("foto");
        
        String f = request.getParameter("Fecha");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        f = formato.format(f);
        Date fecha = Formatter.parse(f);
        
        
        
        String unidades = request.getParameter("Unidades");
        
        String descripcion = request.getParameter("descripcion");
        String editorial = request.getParameter("editorial");
        
        
        short bestseller = 0;
        
        if (Short.valueOf(request.getParameter("bestseller")) == 1){
            bestseller = 1;
        }
        
        Libro libro = new Libro(isbn,titulo,fecha,bestseller);
        
        //Libro libro = new Libro(isbn);
        
        String edit[] = editorial.split("-");
        Editorial ed = new Editorial (Integer.valueOf(edit[0]));
        libro.setEditorialidEditorial(ed);
        
        libro.setDescripcion(descripcion);
        
        libroService.insertarLibro(libro);
        this.accionDefault(request, response);
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
