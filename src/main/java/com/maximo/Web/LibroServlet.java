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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
        if (accion != null) {
            switch (accion) {
                case "buscar":
                    //this.buscarLibro(request, response);
                    break;
                case "editar":
                    this.editarLibro(request, response);
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
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarLibro(request, response);
                    break;
                case "editar":
                    this.editarLibro(request, response);
                    break;
                case "eliminar":
                    //this.eliminarCliente(request, response);
                    break;
                case "listar":
                    this.listarLibro(request, response);
                    break;
                case "buscar":
                    this.buscarLibro(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            //this.accionDefault(request, response);
        }
    }
    
    private void listarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Libro> libros = libroService.findAllLibro();
        System.out.println("libros: " + libros);
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
        
    }
    
    private void buscarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bus = request.getParameter("bus");
        List<Libro> libros = libroService.buscadorLibro(bus);
        System.out.println("libros: " + libros);
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
        
    }
    
    private void insertarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Categoria> c = new ArrayList<>();
        List<Autor> a = new ArrayList<>();
        List<Unidad> unidad = new ArrayList<>();
<<<<<<< HEAD

=======
        
>>>>>>> 598233af741d19e43aef5762d485f60ec0bc4798
        String isbn = request.getParameter("ISBN");
        String titulo = request.getParameter("Titulo");
        
        Part origen = (request.getPart("foto"));
        String or = getFilename(origen);
        File ar = new File(or);
        ar.renameTo(new File("/BibliotecaWeb/img/" + ar));
        String foto = ar.toPath().toString();
        //String foto = cargarImagen(request, response, origen);

        String f = request.getParameter("Fecha");
        String fe[] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]), Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());
        
        String descripcion = request.getParameter("descripcion");
        String editorial = request.getParameter("editorial");
        
        short bestseller = Short.valueOf(request.getParameter("bestseller"));
        
        Editorial ed = new Editorial(Integer.valueOf(editorial));
        Libro libro = new Libro(isbn, titulo, fecha, bestseller, foto, descripcion, ed);

        List<Libro> l = new ArrayList<>();
        l.add(libro);

        int unidades = Integer.valueOf(request.getParameter("Unidades"));
        for (int i = 0; i < Integer.valueOf(unidades); i++) {
            unidad.add(new Unidad((short) 1, "administración", libro));
        }

        String[] categorias = request.getParameterValues("categoria");
        for (String i : categorias) {
            c.add(new Categoria(Integer.valueOf(i), l));
        }
        
        String[] autores = request.getParameterValues("autor");
        for (String i : autores) {
            a.add(new Autor(Integer.valueOf(i), l));
        }

        libro.setUnidadList(unidad);
        libro.setAutorList(a);
        libro.setCategoriaList(c);

        /*for (int i = 0; i < unidades; i++) {
            unidadService.insertarUnidad(new Unidad("disponible", "administración", libro));
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

    /*private String cargarImagen(HttpServletRequest request, HttpServletResponse response, Part origen)
            throws ServletException, IOException {
        String UPLOAD_DIR = "../../../img";
        String applicationPath = new File("").getAbsolutePath() + UPLOAD_DIR;
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        // Obtener información sobre el archivo cargado
        String fileName = getFileName(origen);
        String contentType = origen.getContentType();
        long fileSize = origen.getSize();

        // Escribir el archivo en el directorio de destino
        InputStream fileContent = origen.getInputStream();
        File targetFile = new File(uploadFilePath + File.separator + fileName);
        // Para copiar los datos del archivo cargado al archivo en el servidor
        Files.copy(fileContent, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        PrintWriter out = response.getWriter();
        out.println("Archivo " + fileName + " subido correctamente al directorio " + uploadFilePath);
        
        return targetFile.toPath().toString();
    }
     */
 /*private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }*/
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Libro> libros = libroService.findAllLibro();
        System.out.println("libros: " + libros);
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    private void editarLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");

=======
        String isbn = request.getParameter("ISBN");
        
        Libro libroAnterior = libroService.findByIsbn(new Libro(isbn));
        String titulo = request.getParameter("Titulo");
        
>>>>>>> 598233af741d19e43aef5762d485f60ec0bc4798
        Part origen = (request.getPart("foto"));
        String or = getFilename(origen);
        File ar = new File(or);
        ar.renameTo(new File("/BibliotecaWeb/img/" + ar));
        String foto = ar.toPath().toString();
        //String foto = cargarImagen(request, response, origen);

        String f = request.getParameter("fecha");
        String fe[] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]), Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());
        
        String descripcion = request.getParameter("descripcion");
<<<<<<< HEAD
        short bestseller = Short.valueOf(request.getParameter("bestseller"));
        int u = Integer.valueOf(request.getParameter("Unidades"));
        List<Categoria> c = new ArrayList<>();
        List<Autor> a = new ArrayList<>();
        List<Unidad> unidad = new ArrayList<>();
        List<Libro> l = new ArrayList<>();
        Libro libro = new Libro(isbn, titulo, fecha, bestseller, foto, descripcion);
        l.add(libro);

        for (int i = 0; i < u; i++) {
            unidad.add(new Unidad((short) 1, "administración", libro));
        }
        libro.setUnidadList(unidad);
        libro.setAutorList(a);
        libro.setCategoriaList(c);
=======
        String e = request.getParameter("editorial");
        Editorial editorial = new Editorial(Integer.valueOf(e));
        List<Autor> autores = libroAnterior.getAutorList();
        List<Categoria> categorias = libroAnterior.getCategoriaList();
        List<Unidad> unidades = libroAnterior.getUnidadList();
        short bestseller = Short.valueOf(request.getParameter("bestseller"));
        
        Libro libro = new Libro(isbn, titulo, fecha, bestseller, foto, descripcion, editorial);
>>>>>>> 598233af741d19e43aef5762d485f60ec0bc4798
        libroService.updateLibro(libro);
        request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
    }
    
}
