/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Autor;
import com.maximo.Dominio.Categoria;
import com.maximo.Dominio.Editorial;
import com.maximo.Service.Interfaz.iAutorService;
import com.maximo.Service.Interfaz.iCategoriaService;
import com.maximo.Service.Interfaz.iEditorialService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "FkLibroServlet", urlPatterns = {"/NuevoLibro"})
public class FkLibroServlet extends HttpServlet {
    
    @Inject
    iEditorialService editorialService;
    
    @Inject
    iCategoriaService categoriaService;
    
    @Inject
    iAutorService autorService;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
}
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Editorial> editoriales = editorialService.findAllEditorial();
        System.out.println("Editorial: "+ editoriales);
        request.setAttribute("editoriales", editoriales);
        
        
        List <Categoria> categorias = categoriaService.findAllCategoria();
        request.setAttribute("categorias",categorias);
        
        List <Autor> autores = autorService.findAllAutor();
        request.setAttribute("autores", autores);
        
        request.getRequestDispatcher("/registroLibro.jsp").forward(request, response);
    }

}
