/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Unidad;
import com.maximo.Dominio.UsuarioHasUnidad;
import com.maximo.Service.Interfaz.iUnidadService;
import com.maximo.Service.Interfaz.iUsuarioHasUnidadService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maximo
 */
@WebServlet(name = "PrestamoServlet", urlPatterns = {"/Prestamo"})
public class PrestamoServlet extends HttpServlet {

    @Inject
    iUsuarioHasUnidadService usuarioHasUnidad;
    @Inject
    iUnidadService unidadService;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrestamoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PrestamoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
                case "listar":
                    this.listarPrestamo(request, response);
                    break;
                case "listarU":
                    //this.procesarPrestamo(request, response);
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
        if (accion != null) {
            switch (accion) {
                case "listar":
                    this.listarPrestamo(request, response);
                    break;
                case "entregar":
                    this.finalizarPrestamo(request, response);
                    break;
                case "listarU":
                    //this.procesarPrestamo(request, response);
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

    private void listarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UsuarioHasUnidad> prestamos = usuarioHasUnidad.findAll();
        float media = this.mediaTiempoPorPrestamo(prestamos);
        request.setAttribute("prestamos", prestamos);
        request.setAttribute("media", String.valueOf(media));
        request.getRequestDispatcher("/TablaPrestamo.jsp").forward(request, response);
    }

    private void finalizarPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioHasUnidad uhu = new UsuarioHasUnidad(Integer.valueOf(request.getParameter("prestamo")));
        UsuarioHasUnidad prestamo = usuarioHasUnidad.findByIdPrestamo(uhu);
        prestamo.setFechaEntrega(new Date());
        usuarioHasUnidad.updateUsuarioHasUnidad(prestamo);

        Unidad unidad = unidadService.findByIdUnidad(prestamo.getUnidadidUnidad());
        unidad.setEstado((short) 1);
        unidadService.updateUnidad(unidad);
        request.getRequestDispatcher("cargarModifica?clase=usuario").forward(request, response);
    }

    private float mediaTiempoPorPrestamo(List<UsuarioHasUnidad> prestamos) {
        long suma = 0;
        float media = 0;
        for (UsuarioHasUnidad p : prestamos) {
            if (p.getFechaEntrega() != null) {
                suma += this.diferenciaFechas(p.getFecha(), p.getFechaEntrega());
            }
        }
        if (prestamos.size() != 0) {
            media = suma / prestamos.size();
        }
        return media;
    }

    private long diferenciaFechas(Date fecha1, Date fecha2) {
        final int miliAHoras = 3600000;
        long date = fecha1.getTime();
        long date2 = fecha2.getTime();
        return (Math.abs(date - date2)) / miliAHoras;
    }
}
