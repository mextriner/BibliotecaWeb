/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Editorial;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno Mañana
 */
@WebServlet("/Editorial")
public class EditorialServlet extends HttpServlet {
    
    @Inject
    iEditorialService editorialService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //1. Leer los parametros de nuestro request
            String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "insertar":
                        this.insertarEditorial(request, response);
                        break;
                    case "editar":
                        //this.editarCliente(request, response);
                        break;
                    case "eliminar":
                        //this.eliminarCliente(request, response);
                        break;
                    default:
                        this.accionDefault(request, response);
                }
            } else {
                //this.accionDefault(request, response);
            }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //1. Leer los parametros de nuestro request
            String accion = request.getParameter("accion");
            if (accion != null){
                switch (accion){
                    case "insertar":
                        this.insertarEditorial(request, response);
                        break;
                    case "editar":
                        this.editarEditorial(request, response);
                        break;
                    case "eliminar":
                        //this.eliminarCliente(request, response);
                        break;
                    default:
                        this.accionDefault(request, response);
                }
            } else {
                //this.accionDefault(request, response);
            }
    }
    
     private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Obtenemos el listado de los cliente
        
        
        // 2. Definimos un objeto session para compartir nuestro atributos en un contexto más amplio
        //HttpSession sesion = request.getSession();
        
        // 3. Compartir en el nuevo alcance los atributos
//        sesion.setAttribute("clientes", clientes);
//        sesion.setAttribute("totalClientes", clientes.size());
//        sesion.setAttribute("saldoTotal", calcularTotal(clientes));
        
        // 4. Redigir el flujo desde el controlador a un JSP
        List<Editorial> editoriales = editorialService.findAllEditorial();
        System.out.println("Editorial: "+ editoriales);
        request.setAttribute("editoriales", editoriales);
        request.getRequestDispatcher("/TablaEditorial.jsp").forward(request, response);
        
    }
    
    
    private void insertarEditorial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        
        Editorial ed = new Editorial(nombre,direccion);
        
        editorialService.insertarEditorial(ed);
        this.accionDefault(request, response);
        
    }
    private void editarEditorial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        int id = Integer.valueOf(request.getParameter("id"));
        Editorial ed = new Editorial(id,nombre,direccion);
        
        editorialService.updateEditorial(ed);
        this.accionDefault(request, response);
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
