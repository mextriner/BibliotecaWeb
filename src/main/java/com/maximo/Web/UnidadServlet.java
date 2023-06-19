/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
import com.maximo.Dominio.Usuario;
import com.maximo.Dominio.UsuarioHasUnidad;
import com.maximo.Service.Interfaz.iUnidadService;
import com.maximo.Service.Interfaz.iUsuarioHasUnidadService;
import com.maximo.Service.Interfaz.iUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maximo
 */
@WebServlet("/Unidad")
public class UnidadServlet extends HttpServlet {

    @Inject
    iUnidadService unidadService;
    @Inject
    iUsuarioService usuarioService;
    @Inject
    iUsuarioHasUnidadService usuarioHasUnidadService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        if (accion != null) {
            switch (accion) {
                case "unidadesPorIsbn":
                    this.unidadesPorIsbn(request, response);
                    break;
                case "procesar":
                    this.procesarPrestamo(request, response);
                    break;
                default:
                //this.accionDefault(request, response);
            }
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
        if (accion != null) {
            switch (accion) {
                case "procesar":
                    this.procesarPrestamo(request, response);
                    break;
                case "unidadesPorIsbn":
                    this.unidadesPorIsbn(request, response);
                    break;
                default:
                //this.accionDefault(request, response);
                }
        } else {
            //this.accionDefault(request, response);
        }
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

    protected void procesarPrestamo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final int id = Integer.valueOf(request.getParameter("idUnidad"));

        final Unidad idUnidad = new Unidad(id);

        Unidad unidad = (unidadService.findByIdUnidad(idUnidad));

        if (unidad == null) {
            String msj = "No hay unidades disponibles";
            request.setAttribute("msj", msj);
            request.getRequestDispatcher("/miCarrito.jsp").forward(request, response);
        } else {
            HttpSession sesion = request.getSession();
            Usuario usuario = usuarioService.findByIdUsuario(new Usuario((String) sesion.getAttribute("usuario")));
            UsuarioHasUnidad prestamo = new UsuarioHasUnidad(new Date());
            prestamo.setUnidadidUnidad(unidad);
            prestamo.setUsuarioidUsuario(usuario);
            usuarioHasUnidadService.insertarUsuarioHasUnidad(prestamo);
            unidad.setEstado((short) 0);
            unidadService.updateUnidad(unidad);
            List <Unidad> carrito = (List <Unidad>)sesion.getAttribute("carrito");
            carrito.remove(unidad);
            request.getRequestDispatcher("Libro?accion=default").forward(request, response);
        }

    }
    

    protected void unidadesPorIsbn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object libro = (Libro) request.getAttribute("libro");

        Libro isbn = (Libro) libro;

        List<Unidad> unidades = unidadService.findByLibroISBN(isbn);

        request.setAttribute("unidades", unidades);

        request.getRequestDispatcher("/detalleLibro.jsp").forward(request, response);

    }

}
