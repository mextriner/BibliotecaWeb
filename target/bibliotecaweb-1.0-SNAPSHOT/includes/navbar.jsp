<%-- 
    Document   : navbar
    Created on : 27-may-2023, 16:12:05
    Author     : Maximo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String user = "";
    HttpSession sesion = request.getSession();
    String msj = "";
    if (request.getAttribute("msj") != null) {
        msj = "Resultado de: " + ((String) request.getAttribute("msj")).toUpperCase();

    }
    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    } else {
        response.sendRedirect("inicioSesion.jsp");
    }
    boolean isAdmin = user.equals("admin");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container-fluid bg-dark fixed-top" style="padding:0;width:100%;">
    <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="container-fluid" style="margin-left:5rem; margin-right:5rem">
            <a class="navbar-brand" href="Libro?accion=default"><img src="foto/bibliLogoRec.png" style="width:35% ;"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <div class="bg-ligth">
                    <span class="navbar-toggler-icon"></span>
                </div>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <li class="nav-item dropdown" style="margin-left:5px;">
                        <a class="nav-link text-light" href="cargarModifica?clase=usuario">
                            <%= user.toUpperCase()%> 
                            <c:choose>
                                <c:when test="<%= isAdmin%>">
                                    <i class="fa-sharp fa-solid fa-wrench"></i>
                                </c:when>
                                <c:otherwise>
                                    <i class="fa-solid fa-user"></i>
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </li>
                    <c:if test="<%=isAdmin%>">
                        <li class="nav-item dropdown" style="margin-left:5px;">
                            <a class="nav-link dropdown-toggle text-light" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"">
                                Tablas <i class="fa-sharp fa-solid fa-chart-simple"></i>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="Usuario?accion=listar">Usuarios</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="Editorial?accion=">Editoriales</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="Libro?accion=listar">Libros</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="Autor?accion=listar">
                                        Autores
                                    </a>
                                </li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="Categoria?accion=listar">
                                        Categorías
                                    </a>
                                </li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="Prestamo?accion=listar">
                                        Préstamos 
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown" style="margin-left:5px;">
                            <a class="nav-link dropdown-toggle text-light" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                INSERTAR <i class="fa-solid fa-circle-plus"></i>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="NuevoLibro?accion=insertar">Registrar Libro</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="registroEditorial.jsp">Registrar Editorial</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="registroCategoria.jsp">Registrar Categoria</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="registroAutor.jsp">Registrar Autor</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="<%=!isAdmin%>">
                        <li class="nav-item dropdown" style="margin-left:5px;">
                            <a class="nav-link text-light" href="Libro?accion=listar" id="navbarDropdown" role="button">
                                Libros <i class="fa-solid fa-book-bookmark"></i>
                            </a>
                        </li>
                        <li class="nav-item dropdown" style="margin-left:5px;">
                            <a class="nav-link text-light" href="Usuario?accion=carrito" id="navbarDropdown" role="button">
                                Mi carrito <i class="fa-solid fa-cart-shopping"></i>
                            </a>
                        </li>
                    </c:if>
                    <li class="nav-item dropdown" style="margin-left:5px;width:500px;">
                        <form action="Libro?accion=buscar" method="post" class="d-flex text-light">

                            <div class="input-group mb-3">
                                <input type="text" style="width:50%;" class="form-control" name="bus" placeholder="Término de búsqueda" aria-label="Recipient's username" aria-describedby="button-addon2">

                                <select name="bestseller" class="form-select" style="width:30%;">
                                    <option selected>BESTSELLER</option>
                                    <option value=0>NO</option>
                                    <option value=1>SÍ</option>
                                </select>

                                <button class="btn btn-outline-info" style="width:20%;" type="submit" id="button-addon2"><i class="fa-solid fa-magnifying-glass"></i>Buscar</button>
                            </div>                                  
                        </form>
                    </li>

                </ul>
                <form method="post" action="CerrarSesion">
                    <input type="hidden" value="1" name="cerrar">
                    <button class="btn btn-danger" type="submit" value="1" id="button-addon2"><i class="fa-solid fa-right-from-bracket"></i> CERRAR SESION</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<hr style="border-top: 1px ivory">


