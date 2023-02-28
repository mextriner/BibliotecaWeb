<%@page import="com.maximo.Dominio.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.maximo.Service.Interfaz.iLibroService"%>
<%
    String user = "";
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("usuario") != null) {
        user =(String) sesion.getAttribute("usuario");
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Index
        </title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="fontawesome-free-6.3.0-web/css/all.min.css">
        <style>
            /* .carrusel {
                width: 60%;
                margin-bottom: 20px;
            } */

            main {
                /* margin-top: 160px; */
                width: 100%;
            }

            .navbar {
                border: solid white 1px;
                border-radius: 5%;
            }
        </style>
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
                                <a class="nav-link dropdown-toggle text-light" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    ¿Tienes cuenta? <i class="fa-solid fa-user"></i>
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="registro.jsp">Registrarse</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="inicioSesion.jsp">Iniciar Sesión</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="cargarModifica?clase=usuario&usr=<%=user%>">
                                            Mi cuenta: <%=user%>
                                        </a>
                                    </li>
                                </ul>
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
                                    <li><a class="dropdown-item" href="Libro?accion=listar">Libros</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="cargarModifica?clase=usuario&usr=<%=user%>">
                                           Autores
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
                                    <li><a class="dropdown-item" href="NuevoLibro">Registrar Libro</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="registroEditorial.jsp">Registrar Editorial</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown" style="margin-left:5px;">
                                <form method="GET" class="d-flex text-light">

                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" name="bus" placeholder="Término de búsqueda" aria-label="Recipient's username" aria-describedby="button-addon2">

                                        <button class="btn btn-outline-info" name="buscar" value="yes" type="submit" id="button-addon2">Buscar</button>
                                    </div>


                                </form>
                            </li>
                        </ul>
                        <form method="post" action="CerrarSesion">
                            <input type="hidden" value="1" name="cerrar">
                            <button class="btn btn-danger" type="submit" value="1" id="button-addon2">CERAR SESION</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>

        <div class="container-fluid">
            <div class="row" style="padding:100px;">
                <c:forEach items="${libros}" var="libro">
                    <div class="col-sm-12 col-md-3 text-light text-center bg-dark d-flex justify-content-center" style="border-radius:5%;border: solid 1px darkgray;">
                        <div style="padding:50px;">
                            <form action="cargarModifica?clase=libro" method="POST">
                                <p>Unidades: ${libro.getUnidadList().size()} </p>
                                <img src='${libro.getPortada()}' style="height:300px;width:198px;border-radius:5%;">
                                <div class="mb-3" style="height:120px;">
                                    <h1>${libro.getTitulo()}</h1>
                                    <p>ISBN:${libro.getIsbn()}</p>
                                </div>
                                <input type="hidden" name="idLibro" value='${libro.getIsbn()}'>
                                <button class="btn btn-outline-info" type="submit" name="editar" id="button-addon2">EDITAR</button>

                            </form>
                            <form action="" method="POST">
                                <input type="hidden" name="idLibro" value='${libro.getIsbn()}'>
                                <button class="btn btn-outline-danger mt-3" type="submit" name="eliminar" id="button-addon2">ELIMINAR</button>
                            </form>
                                
                        </div>
                    </div>
                </c:forEach>>
            </div>
        </div>