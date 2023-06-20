/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
import com.maximo.Dominio.Usuario;
import com.maximo.Service.Interfaz.iLibroService;
import com.maximo.Service.Interfaz.iUnidadService;
import com.maximo.Service.Interfaz.iUsuarioHasUnidadService;
import com.maximo.Service.Interfaz.iUsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno Mañana
 */
@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {

    @Inject
    iUsuarioService usuarioService;
    @Inject
    iLibroService libroService;
    @Inject
    iUsuarioHasUnidadService usuarioHasUnidad;
    @Inject
    iUnidadService unidadService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "sesion":
                    this.iniciarSesion(request, response);
                    break;
                case "editar":
                    this.editarUsuario(request, response);
                    break;
                case "listar":
                    this.listarUsuario(request, response);
                    break;
                case "carrito":
                    this.verCarrito(request, response);
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
                    this.insertarUsuario(request, response);
                    break;
                case "sesion":
                    this.iniciarSesion(request, response);
                    break;
                case "editar":
                    this.editarUsuario(request, response);
                    break;
                case "eliminar":
                    //this.eliminarCliente(request, response);
                    break;
                case "listar":
                    this.listarUsuario(request, response);
                    break;
                case "sumarLibro":
                    this.sumarLibro(request, response);
                    break;
                case "carrito":
                    this.verCarrito(request, response);
                    break;
                default:
                //this.accionDefault(request, response);
                }
        } else {
            //this.accionDefault(request, response);
        }
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        if (sesion != null) {
            sesion.invalidate();
        }

        String user = request.getParameter("usuario");
        if (usuarioService.existUsuario(new Usuario(user))) {
            String msj = "Este nombre de usuario ya existe";
            request.setAttribute("msj", msj);
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");

        String f = request.getParameter("fechaNac");

        String fe[] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]), Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());

        Usuario usuario = new Usuario(user, clave, nombre, apellido, direccion, fecha);
        usuarioService.insertarUsuario(usuario);
        request.getRequestDispatcher("Libro?accion=listar").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");

        String f = request.getParameter("fechaNac");
        String fe[] = f.split("-");
        LocalDate fec = LocalDate.of(Integer.valueOf(fe[0]), Integer.valueOf(fe[1]), Integer.valueOf(fe[2]));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date fecha = Date.from(fec.atStartOfDay(defaultZoneId).toInstant());

        Usuario usuario = new Usuario(user, clave, nombre, apellido, direccion, fecha);
        usuarioService.updateUsuario(usuario);
        request.getRequestDispatcher("Libro?accion=default").forward(request, response);

    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msj = "";
        String user = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        HttpSession sesion = request.getSession();

        if (sesion.getAttribute("usuario") == null) {
            if (!user.equals("") && !clave.equals("")) {
                Usuario usuario = new Usuario(user);
                if (usuarioService.findByIdUsuario(usuario) != null) {
                    usuario = usuarioService.findByIdUsuario(usuario);
                    if (usuario.getClave().equals(clave)) {
                        sesion.setAttribute("usuario", usuario.getIdUsuario());
                        if (usuario.getIdUsuario().equals("admin")) {
                            request.getRequestDispatcher("Libro?accion=listar").forward(request, response);
                        } else {
                            request.getRequestDispatcher("Libro?accion=defaultaction").forward(request, response);

                        }

                    } else {
                        msj = "La contraseña no es correcta";
                        request.setAttribute("mensaje", msj);
                        request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
                    }
                } else {
                    msj = "El usuario no existe";
                    request.setAttribute("mensaje", msj);
                    request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
                }
            } else {
                msj = "Las credenciales no pueden estar vacías";
                request.setAttribute("mensaje", msj);
                request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
            }
        } else {
            msj = "La sesión ya está iniciada";
            request.setAttribute("mensaje", msj);
            request.getRequestDispatcher("Libro?accion=defaultaction").forward(request, response);
        }

    }

    private void listarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> usuarios = usuarioService.findAllUsuario();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("TablaUsuario.jsp").forward(request, response);

    }

    private void sumarLibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msj = "";
        HttpSession sesion = request.getSession();
        final int id = Integer.valueOf(request.getParameter("idUnidad"));

        final Unidad idUnidad = new Unidad(id);

        Unidad unidad = (unidadService.findByIdUnidad(idUnidad));
        List<Unidad> carrito = (List) sesion.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
            carrito.add(unidad);
            sesion.setAttribute("carrito", carrito);
        } else if (carrito.contains(unidad)) {
            request.getRequestDispatcher("Libro?accion=default").forward(request, response);
        } else if (carrito.size() < 6) {
            carrito.add(unidad);
        } else if (carrito.size() > 5) {
            msj = "No puedes alquilar más de 5 libros";
            request.getRequestDispatcher("miCarrito.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Libro?accion=default").forward(request, response);

    }

    private void verCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("miCarrito.jsp").forward(request, response);
    }

}
