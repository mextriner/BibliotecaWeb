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
import com.maximo.Dominio.Unidad;
import com.maximo.Service.Interfaz.iLibroService;
import com.maximo.Service.Interfaz.iUnidadService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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
import javax.servlet.http.Part;

/**
 *
 * @author Alumno Mañana
 */
@WebServlet("/Libro")
@MultipartConfig
public class LibroServlet extends HttpServlet {
    

    @Inject
    iLibroService libroService;
    
    @Inject
    iUnidadService unidadService;
    
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
                    case "listar":
                        this.listarLibro(request, response);
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
                    case "listar":
                        this.listarLibro(request, response);
                        break;
                    default:
                        //this.accionDefault(request, response);
                }
            } else {
                //this.accionDefault(request, response);
            }
    }

    
    
    
    private void listarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Libro> libros = libroService.findAllLibro();
        System.out.println("libros: "+ libros);
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
    
    private void insertarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Categoria> c = new ArrayList<>();
        List<Autor> a = new ArrayList<>();
        
        
        String [] categorias = request.getParameterValues("categoria");
        for(String i: categorias){
            c.add(new Categoria(Integer.valueOf(i)));
        }
        
        String [] autores = request.getParameterValues("autor");
        for(String i: autores){
            a.add(new Autor(Integer.valueOf(i)));
        }
        
        String isbn = request.getParameter("ISBN");     
        String titulo = request.getParameter("Titulo");
                
        Part origen = (request.getPart("foto"));
        String or = getFilename(origen);
        File ar = new File(or);
        ar.renameTo(new File("/BibliotecaWeb/img/"+ar));
        String foto = ar.toPath().toString();
        
        String f = request.getParameter("Fecha");
        String fe [] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]),Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());
        
        int unidades = Integer.valueOf(request.getParameter("Unidades"));
        String descripcion = request.getParameter("descripcion");
        String editorial = request.getParameter("editorial");
        
        
        short bestseller = Short.valueOf(request.getParameter("bestseller"));
        
        Editorial ed = new Editorial (Integer.valueOf(editorial));
        Libro libro = new Libro(isbn, titulo, fecha, bestseller, foto, descripcion, ed);
        
        libro.setAutorList(a);
        libro.setCategoriaList(c);
        
        /*for(int i = 0 ; i < unidades ; i++){
            unidadService.insertarUnidad(new Unidad("disponible","administración",libro));
        }*/
        libroService.insertarLibro(libro);
        this.listarLibro(request, response);
        
    }
    
    private static String getFilename(Part part) {
        String r = null;
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                r = filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
    return r;
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
