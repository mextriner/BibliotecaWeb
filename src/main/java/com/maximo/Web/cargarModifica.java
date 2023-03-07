/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Autor;
import com.maximo.Dominio.Categoria;
import com.maximo.Dominio.Editorial;
import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Usuario;
import com.maximo.Service.Interfaz.iAutorService;
import com.maximo.Service.Interfaz.iCategoriaService;
import com.maximo.Service.Interfaz.iEditorialService;
import com.maximo.Service.Interfaz.iLibroService;
import com.maximo.Service.Interfaz.iUsuarioService;
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
@WebServlet("/cargarModifica")
public class cargarModifica extends HttpServlet {

    @Inject
    iUsuarioService usuarioService;
    @Inject
    iLibroService libroService;
    @Inject
    iAutorService autorService;
    @Inject
    iCategoriaService categoriaService;
    @Inject
    iEditorialService editorialService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cargarModifica</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cargarModifica at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clase = request.getParameter("clase");
        if (clase != null) {
            switch (clase) {
                case "usuario":
                    this.modificarUsuario(request, response);
                    break;
                case "libro":
                    //this.iniciarSesion(request, response);
                    break;
                case "autor":
                    this.modificararAutor(request, response);
                    break;
                case "categoria":
                    this.modificararCategoria(request, response);
                    break;
                case "editorial":
                    this.modificararEditorial(request, response);
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
        String clase = request.getParameter("clase");
        if (clase != null) {
            switch (clase) {
                case "usuario":
                    this.modificarUsuario(request, response);
                    break;
                case "libro":
                    this.modificarLibro(request, response);
                    break;
                case "autor":
                    //this.editarCliente(request, response);
                    break;
                default:
                //this.accionDefault(request, response);
                }
        } else {
            //this.accionDefault(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String u = (String) sesion.getAttribute("usuario");
        Usuario usuario = new Usuario(u);
        usuario = usuarioService.findByIdUsuario(usuario);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("gestionPerfil.jsp").forward(request, response);

    }

    private void modificarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Editorial> editoriales = (List)request.getAttribute("editoriales");
        request.setAttribute("editoriales", editoriales);
        String isbn = (String) request.getParameter("idLibro");
        Libro libro = new Libro(isbn);
        libro = libroService.findByIsbn(libro);
        request.setAttribute("libro", libro);
        request.getRequestDispatcher("editarLibro.jsp").forward(request, response);

    }

    private void modificararAutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Autor autor = autorService.findByIdAutor(new Autor(Integer.valueOf(request.getParameter("autorId"))));
        int id = Integer.valueOf(request.getParameter("autorId"));
        request.setAttribute("autor", autor);
        request.setAttribute("id", id);
        request.getRequestDispatcher("editarAutor.jsp").forward(request, response);
    }

    private void modificararCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Categoria categoria = categoriaService.findByIdCategoria(new Categoria(Integer.valueOf(request.getParameter("categoriaId"))));
        int id = Integer.valueOf(request.getParameter("categoriaId"));
        request.setAttribute("categoria", categoria);
        request.setAttribute("id", id);
        request.getRequestDispatcher("editarCategoria.jsp").forward(request, response);
    }
    
    private void modificararEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("editorialId"));
        Editorial editorial = editorialService.findByIdEditorial(new Editorial(Integer.valueOf(request.getParameter("editorialId"))));
        
        request.setAttribute("editorial", editorial);
        request.setAttribute("id", id);
        request.getRequestDispatcher("editarEditorial.jsp").forward(request, response);
    }

}
