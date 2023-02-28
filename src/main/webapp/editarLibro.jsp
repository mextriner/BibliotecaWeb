
<%@page import="com.maximo.Dominio.Libro"%>
<%@page import="com.maximo.Dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = "";
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    }
%>
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>mi Cuenta
        </title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="fontawesome-free-6.3.0-web/css/all.min.css">
        <style>
            .navbar {
                border: solid white 1px;
                border-radius: 5%;
            }
        </style>
    </head>

    <body class="bg-secondary">
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
        <!---->

        <!-- INFO DE MI CUENTA -->
        <!-- NOMBRE, APELLIDOS, CORREO, ETC. -->
        <div class="container-fluid bg-dark" >
            <form method="POST" action="Libro?accion=editar" enctype="multipart/form-data">

                <div class="row d-flex justify-content-center">

                    <div class="col-md-4 col-sm-12 mb-3 mt-4">
                        <h1 class="text-light" style="font-size: 30px; ;"><strong>LIBRO: <%= libro.getIsbn()%></strong></h1>
                        <input type="hidden" name="isbn" value="<%= libro.getIsbn()%>">
                        <label for="exampleFormControlInput1" class="form-label">Libro</label>
                        <input type="text" class="form-control" name="titulo" value="<%= libro.getTitulo()%>">
                    </div>
                </div>
                <div class="row d-flex justify-content-center">


                    <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">


                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Fecha Publicación: <%= libro.getFechaPublicacion()%></label>
                            <input type="date" class="form-control" name="fecha" required>
                        </div>
                        <div class="mb-3">
                            <label for="formFile" class="form-label">Portada</label>
                            <input type="file" class="form-control" name="foto" placeholder="Ruta de imagen" id="formFile"> required
                        </div>
                        <div class="mb-5">
                            <label for="exampleFormControlInput1" class="form-label">Número de Unidades</label>
                            <input type="number" class="form-control" name="Unidades" placeholder="Unidades" required>
                        </div>                            
                    </div>
                    <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">
                        <label for="inputState" class="form-label">Bestseller</label>
                        <div class="form-floating mb-4">
                            <select name="bestseller" class="form-select" required>
                                <option value=0>NO</option>
                                <option value=1>SÍ</option>
                            </select>
                        </div>
                        <div class="mb-4">
                            <label for="exampleFormControlInput1" class="form-label">Descripción</label>
                            <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="3" required><%= libro.getDescripcion()%></textarea>
                        </div>
                    </div>


                </div>
                <div class="row d-flex justify-content-center">

                    <div class="col-md-4 col-sm-12 mb-3 mt-4 d-flex justify-content-center">
                        <div class="mb-3 col-sm-12 col-md-4">
                            <button class="btn btn-outline-info Hadow rounded border" type="submit">ACEPTAR CAMBIOS</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>







        <!-- HISTORIAL DE LIBROS/ LIBROSD EN ALQUILER... -->


        <!--ACTUALIZAR MI CUENTA-->

        <!--en esta linea se reparten los elementos-->








    </div>
    <!--AQUÍ VAN LAS CARDS-->

    <div class="container-fluid">
        <div class="row justify-content-center mt-3 pt-2 pb-2 bg-secondary">
            <h4 style="font-family:monospace; font-size : 46px; color: aliceblue;">MIS ÚLTIMOS LIBROS
            </h4>
            <div class="col-sm-12 col-md-2">

                <div class="card bg-dark text-light" style="width: 18rem;">
                    <img src="<?php echo $lib['portada']; ?>" alt="..." style="border-radius:5%;">
                    <div class="card-body">
                        <p class="card-text"><strong><?php echo $lib['titulo']; ?></strong>
                            <?php echo $lib['descripcion']; ?></p>
                    </div>
                </div>
                <button class="btn-info" name="devolver">DEVOLVER</button>
                <?php
                }
                ?>
            </div>

            <!--FOOTER-->

            <div class="container-fluid bg-secondary">
                <div class="row d-flex justify-content-center mb-3">

                    <div class="col-sm-12 col-md-6 mb-5 text-light text-center">
                        <a class="nav-link active text-light" aria-current="page" href="#">ACERCA DE NOSOTROS</a>
                        <a class="nav-link text-light" href="#">AYÚDANOS A MEJORAR</a>
                        <a class="nav-link disabled text-light" href="#" tabindex="-1" aria-disabled="true">ASISTENCIA</a>
                        <a class="nav-link disabled text-light" href="#" tabindex="-1" aria-disabled="true">ESTADO DEL SERVIDOR</a>
                    </div>
                    <div class="col-sm-12 col-md-6 text-center" style="font-size: 25px;">
                        <div class=""><i class="fa-brands fa-facebook"></i></div>
                        <div class=""> <i class="fa-brands fa-instagram"></i></div>
                        <div class=""><i class="fa-brands fa-twitter"></i></div>
                        <div class=""> <i class="fa-brands fa-youtube"></i></div>
                    </div>
                </div>
            </div>






        </div>
    </div>






    <script src="lb/js/bootstrap.min.js"></script>
</body>

</html>