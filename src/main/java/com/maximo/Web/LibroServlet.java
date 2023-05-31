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
import com.maximo.Service.Interfaz.iAutorService;
import com.maximo.Service.Interfaz.iCategoriaService;
import com.maximo.Service.Interfaz.iLibroService;
import com.maximo.Service.Interfaz.iUnidadService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Alumno Mañana
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
@WebServlet("/Libro")
public class LibroServlet extends HttpServlet {

    @Inject
    iLibroService libroService;

    @Inject
    iAutorService autorService;

    @Inject
    iCategoriaService categoriaService;

    @Inject
    iUnidadService unidadService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "alquilar":
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
                case "carrito":
                    this.carrito(request, response);
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
                case "buscarU":
                    this.buscarLibroUsuario(request, response);
                    break;
                case "carrito":
                    this.carrito(request, response);
                    break;
                case "detalleLibro":
                    this.verDetalleLibro(request, response);
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
        for (Libro i : libros) {
            byte[] imagen = i.getPortada();
            if (imagen != null) {
                String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                i.setPortadabase64(portadaBase64);
                System.out.println(i.getPortadabase64());
            }
        }
        System.out.println("libros: " + libros);
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);

    }

    private void carrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msj = "";
        HttpSession sesion = request.getSession();
        List<Libro> libros = (List) sesion.getAttribute("carrito");
        for (Libro i : libros) {
            byte[] imagen = i.getPortada();
            if (imagen != null) {
                String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                i.setPortadabase64(portadaBase64);
                System.out.println(i.getPortadabase64());
            }
        }
        if (sesion.getAttribute("carrito") == null) {
            msj = "No se han añadido libros al carrito";
            request.setAttribute("vacio", msj);
            request.getRequestDispatcher("/miCarrito.jsp").forward(request, response);
        } else {
            System.out.println("libros: " + libros);
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("/miCarrito.jsp").forward(request, response);
        }

    }

    private void buscarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bus = request.getParameter("bus");
        String p = request.getParameter("bestseller");
        List<Libro> libros = new ArrayList<>();

        if (!bus.equals("") && p.equals("BESTSELLER")) {
            libros = libroService.buscadorLibro(bus);
            if (libros.isEmpty()) {
                request.setAttribute("msj", "NO HAY RESULTADOS");
                request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
            }
            for (Libro i : libros) {
                byte[] imagen = i.getPortada();
                if (imagen != null) {
                    String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                    i.setPortadabase64(portadaBase64);
                    System.out.println(i.getPortadabase64());
                }
            }
            System.out.println("libros: " + libros);
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
        } else if (bus.equals("") && !p.equals("BESTSELLER")) {
            short bestseller = Short.valueOf(request.getParameter("bestseller"));
            Libro l = new Libro(bestseller);
            libros = libroService.findByBestSeller(l);
            if (libros.isEmpty()) {
                request.setAttribute("msj", "NO HAY RESULTADOS");
                request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
            }
            for (Libro i : libros) {
                byte[] imagen = i.getPortada();
                if (imagen != null) {
                    String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                    i.setPortadabase64(portadaBase64);
                    System.out.println(i.getPortadabase64());
                }
            }
            System.out.println("libros: " + libros);
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
        } else if (!bus.equals("") && !p.equals("BESTSELLER")) {
            short bestseller = Short.valueOf(request.getParameter("bestseller"));
            libros = libroService.buscadorLibroBestseller(bus, bestseller);
            if (libros.isEmpty()) {
                request.setAttribute("msj", "NO HAY RESULTADOS");
                request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
            }
            for (Libro i : libros) {
                byte[] imagen = i.getPortada();
                if (imagen != null) {
                    String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                    i.setPortadabase64(portadaBase64);
                    System.out.println(i.getPortadabase64());
                }
            }
            System.out.println("libros: " + libros);
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("/TablaLibro.jsp").forward(request, response);
        } else if (bus.equals("") && p.equals("BESTSELLER")) {
            this.listarLibro(request, response);
        }

    }

    private void buscarLibroUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bus = request.getParameter("bus");
        String p = request.getParameter("bestseller");
        List<Libro> libros = new ArrayList<>();
        if (!bus.equals("") && p.equals("BESTSELLER")) {
            libros = libroService.buscadorLibro(bus);
            if (libros.isEmpty()) {
                request.setAttribute("msj", "NO HAY RESULTADOS");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            for (Libro i : libros) {
                byte[] imagen = i.getPortada();
                if (imagen != null) {
                    String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                    i.setPortadabase64(portadaBase64);
                    System.out.println(i.getPortadabase64());
                }
            }
            System.out.println("libros: " + libros);
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (bus.equals("") && !p.equals("BESTSELLER")) {
            short bestseller = Short.valueOf(request.getParameter("bestseller"));
            Libro l = new Libro(bestseller);
            libros = libroService.findByBestSeller(l);
            if (libros.isEmpty()) {
                request.setAttribute("msj", "NO HAY RESULTADOS");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            for (Libro i : libros) {
                byte[] imagen = i.getPortada();
                if (imagen != null) {
                    String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                    i.setPortadabase64(portadaBase64);
                    System.out.println(i.getPortadabase64());
                }
            }
            System.out.println("libros: " + libros);
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (!bus.equals("") && !p.equals("BESTSELLER")) {
            short bestseller = Short.valueOf(request.getParameter("bestseller"));
            libros = libroService.buscadorLibroBestseller(bus, bestseller);
            if (libros.isEmpty()) {
                request.setAttribute("msj", "NO HAY RESULTADOS");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            for (Libro i : libros) {
                byte[] imagen = i.getPortada();
                if (imagen != null) {
                    String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                    i.setPortadabase64(portadaBase64);
                    System.out.println(i.getPortadabase64());
                }
            }
            System.out.println("libros: " + libros);
            request.setAttribute("libros", libros);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (bus.equals("") && p.equals("BESTSELLER")) {
            this.listarLibro(request, response);
        }

    }

    private void insertarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Categoria> c = new ArrayList<>();
        List<Autor> a = new ArrayList<>();
        List<Unidad> unidad = new ArrayList<>();
        String isbn = request.getParameter("ISBN");
        String titulo = request.getParameter("Titulo");

        Part filePart = request.getPart("portada");
        byte[] portada = null;
        if (filePart != null) {
            InputStream fileContent = filePart.getInputStream();
            portada = leerBytesDeInputStream(fileContent);
        }

        String f = request.getParameter("Fecha");
        String fe[] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]), Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());

        String descripcion = request.getParameter("descripcion");
        String editorial = request.getParameter("editorial");

        short bestseller = Short.valueOf(request.getParameter("bestseller"));

        Editorial ed = new Editorial(Integer.valueOf(editorial));
        Libro libro = new Libro(isbn, titulo, fecha, bestseller, portada, descripcion, ed);

        int unidades = Integer.valueOf(request.getParameter("Unidades"));
        for (int i = 0; i < unidades; i++) {
            unidad.add(new Unidad((short) 1, "administración", libro));
        }

        String[] categorias = request.getParameterValues("categoria");
        for (String i : categorias) {
            c.add(new Categoria(Integer.valueOf(i)));
            Categoria cat = categoriaService.findByIdCategoria((new Categoria(Integer.valueOf(i))));
            cat.getLibroList().add(libro);
            categoriaService.updateCategoria(cat);
        }

        String[] autores = request.getParameterValues("autor");
        for (String i : autores) {
            a.add(new Autor(Integer.valueOf(i)));
            Autor au = autorService.findByIdAutor(new Autor(Integer.valueOf(i)));
            au.getLibroList().add(libro);
            autorService.updateAutor(au);
        }

        libro.setUnidadList(unidad);
        libro.setAutorList(a);
        libro.setCategoriaList(c);

        /*for (int i = 0; i < unidades; i++) {
            unidadService.insertarUnidad(new Unidad("disponible", "administración", libro));
        }*/
        libroService.updateLibro(libro);
        this.listarLibro(request, response);

    }

    private byte[] leerBytesDeInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();

        return buffer.toByteArray();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void portadaToBase64(Libro libro){
        byte[] imagen = libro.getPortada();
            if (imagen != null) {
                String portadaBase64 = Base64.getEncoder().encodeToString(imagen);
                libro.setPortadabase64(portadaBase64);
                System.out.println(libro.getPortadabase64());
            }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Libro> libros = libroService.findAllLibro();
        for (Libro i : libros) {
            byte[] imagen = i.getPortada();
            if (imagen != null) {
                portadaToBase64(i);
            }
        }
        System.out.println("libros: " + libros);
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void editarLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");

        Libro libroAnterior = libroService.findByIsbn(new Libro(isbn));

        Part filePart = request.getPart("portada");
        byte[] portada = null;
        if (filePart != null) {
            InputStream fileContent = filePart.getInputStream();
            portada = leerBytesDeInputStream(fileContent);
        }
        //String foto = cargarImagen(request, response, origen);

        String f = request.getParameter("fecha");
        String fe[] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]), Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());

        String descripcion = request.getParameter("descripcion");

        short bestseller = Short.valueOf(request.getParameter("bestseller"));
        int u = Integer.valueOf(request.getParameter("unidades"));
        String e = request.getParameter("editorial");
        Editorial editorial = new Editorial(Integer.valueOf(e));
        Libro libro = new Libro(isbn, titulo, fecha, bestseller, portada, descripcion, editorial);
        List<Unidad> unidad = new ArrayList<>();
        for (int i = 0; i < u; i++) {
            unidad.add(new Unidad((short) 1, "administración", libro));
        }

        List<Autor> autores = libroAnterior.getAutorList();
        List<Categoria> categorias = libroAnterior.getCategoriaList();

        libro.setUnidadList(unidad);
        libro.setAutorList(autores);
        libro.setCategoriaList(categorias);
        libroService.updateLibro(libro);
        this.listarLibro(request, response);
    }

    private void verDetalleLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Libro isbn = new Libro(request.getParameter("ISBN"));
        Libro libro = libroService.findByIsbn(isbn);
        portadaToBase64(libro);
        System.out.println("libro: " + libro);
        request.setAttribute("libro", libro);
        request.getRequestDispatcher("/detalleLibro.jsp").forward(request, response);
    }

}
