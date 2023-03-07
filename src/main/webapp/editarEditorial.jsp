<%-- 
    Document   : registroEditorial
    Created on : 06-feb-2023, 10:51:40
    Author     : Alumno Mañana
--%>

<%@page import="com.maximo.Dominio.Editorial"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<% Editorial ed = (Editorial) request.getAttribute("editorial");%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Actualizar Editorial</title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/fontawesome-free-6.3.0-web/css/all.min.css">
    </head>
    <body class="bg-secondary" style="font-family:monospace;">


        <!--LA BARRA DE NAVEGACION-->
        <div class="container-fluid bg-secondary" style="padding:0;width:100%;">
            <nav class="navbar navbar-expand-lg navbar-light ">
                <div class="container-fluid">
                    <a class="navbar-brand" href="Libro?accion=listar"><img src="foto/bibliLogoRec.png" alt="" style="width:35% ;"></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <div class="bg-ligth">
                            <span class="navbar-toggler-icon"></span>
                        </div>

                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                            <li class="nav-item dropdown" style="margin-left:5px;">
                                <a class="nav-link text-light" href="#">
                                    ADMIN <i class="fa-sharp fa-solid fa-wrench"></i>
                                </a>
                            </li>
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
                                <a class="nav-link text-light" href="" id="navbarDropdown" role="button">
                                    Libros <i class="fa-solid fa-book-bookmark"></i>
                                </a>
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
                            <li class="nav-item dropdown" style="margin-left:5px;width:500px;">
                                <form action="Libro?accion=buscar" method="post" class="d-flex text-light">

                                    <div class="input-group mb-3">
                                        <input type="text" style="width:50%;" class="form-control" name="bus" placeholder="Término de búsqueda" aria-label="Recipient's username" aria-describedby="button-addon2">

                                        <select name="bestseller" class="form-select" style="width:30%;">
                                            <option selected>BESTSELLER</option>
                                            <option value=0>NO</option>
                                            <option value=1>SÍ</option>
                                        </select>

                                        <button class="btn btn-outline-info" style="width:20%;" type="submit" id="button-addon2">Buscar</button>
                                    </div>                                  
                                </form>
                            </li>
                        </ul>
                        <form method="post" action="CerrarSesion">
                            <input type="hidden" value="1" name="cerrar">
                            <button class="btn btn-danger" type="submit" value="1" id="button-addon2">CERRAR SESION</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>


        <!---->
        <div class="container-fluid bg-dark align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center">
                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">
                    <form method="POST" action="Editorial?accion=editar">
                        <h1 style="font-size: 30px; ;"><strong>REGISTRO EDITORIAL</strong></h1>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Editorial</label>
                            <input type="text" class="form-control" name="nombre" value="<%= ed.getNombre()%>">
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Dirección</label>
                            <input type="text" class="form-control" name="direccion" value="<%= ed.getDireccion()%>">
                        </div>
                        <input type="hidden" name="id" value="<%= request.getAttribute("id")%>">
                        <div class="mt-5 col-12 d-flex justify-content-center align-item-center">
                            <button class="btn btn-outline-success Hadow rounded border" type="submit">REGISTRARSE</button>

                        </div>

                    </form>
                </div>


            </div>
        </div>
        <script src="lb/js/bootstrap.min.js"></script>
    </body>
</html>
