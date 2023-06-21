/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximo.Web;

import com.maximo.Dominio.Categoria;
import com.maximo.Dominio.Libro;
import com.maximo.Dominio.Unidad;
import com.maximo.Dominio.UsuarioHasUnidad;
import com.maximo.Service.Interfaz.iCategoriaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
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
@WebServlet(name = "CategoriaServlet", urlPatterns = {"/Categoria"})
public class CategoriaServlet extends HttpServlet {

    @Inject
    iCategoriaService categoriaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCategoria(request, response);
                    break;

                case "eliminar":
                    //this.eliminarCliente(request, response);
                    break;
                case "listar":
                    this.litarCategorias(request, response);
                    break;
                case "grafico":
                    this.graficoCategoria(request, response);
                    break;
                default:
                //this.accionDefault(request, response);
                }
        } else {
            //this.accionDefault(request, response);
        }
    }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCategoria(request, response);
                    break;
                case "editar":
                    this.editarCategoria(request, response);
                    break;
                case "eliminar":
                    //this.eliminarCliente(request, response);
                    break;
                case "listar":
                    this.litarCategorias(request, response);
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

    private void insertarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Categoria categoria = new Categoria(nombre, descripcion);
        categoriaService.insertarCategoria(categoria);
        this.litarCategorias(request, response);
    }

    private void litarCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> categorias = categoriaService.findAllCategoria();
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/TablaCategoria.jsp").forward(request, response);
    }

    private void graficoCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> categorias = categoriaService.findAllCategoria();
        int prestamos[] = this.prestamos(categorias);
        LinkedHashMap<Categoria, Integer> categoriasOrdendas = this.categoriasOrdenados(categorias, prestamos);
        request.setAttribute("categorias", categoriasOrdendas);
        request.getRequestDispatcher("/graficoCategorias.jsp").forward(request, response);
    }

    private void editarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Categoria categoria = new Categoria(id, nombre, descripcion);
        categoriaService.updateCategoria(categoria);
        this.litarCategorias(request, response);
    }

    private LinkedHashMap<Categoria, Integer> categoriasOrdenados(List<Categoria> categorias, int[] num) {
        this.ordenDesc(categorias, num);
        LinkedHashMap<Categoria, Integer> numPrest = new LinkedHashMap<>();
        for (int i = 0; i < categorias.size(); i++) {
            numPrest.put(categorias.get(i), num[i]);
        }
        return numPrest;
    }

    private int[] prestamos(List<Categoria> categorias) {
        int[] numPrest = new int[categorias.size()];
        int index = 0;
        for (Categoria c : categorias) {
            int x = 0;
            for (Libro i : c.getLibroList()) {
                for (Unidad u : i.getUnidadList()) {
                    for (UsuarioHasUnidad p : u.getUsuarioHasUnidadList()) {
                        if (p.getFechaEntrega() != null) {
                            x += diferenciaFechasSegundos(p.getFecha(), p.getFechaEntrega());
                        }

                    }
                }
            }
            numPrest[index] = x;
            index++;
        }
        return numPrest;
    }

    private void ordenDesc(List<Categoria> categorias, int[] num) {
        int temp = 0;
        Categoria categoriaTemp = null;
        for (int i = 0; i < (num.length - 1); i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] < num[j + 1]) {
                    temp = num[j];
                    categoriaTemp = categorias.get(j);

                    num[j] = num[j + 1];
                    categorias.set(j, categorias.get(j + 1));

                    num[j + 1] = temp;
                    categorias.set(j + 1, categoriaTemp);
                }
            }
        }

    }

    private float diferenciaFechasSegundos(Date fecha1, Date fecha2) {
        long date = fecha1.getTime();
        long date2 = fecha2.getTime();
        float resul = Math.abs(date - date2);
        return resul / 3600000;
    }
}
