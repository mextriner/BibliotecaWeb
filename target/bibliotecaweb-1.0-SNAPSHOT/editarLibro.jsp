
<%@page import="com.maximo.Dominio.Libro"%>
<%@page import="com.maximo.Dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Libro
        </title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/fontawesome-free-6.3.0-web/css/all.min.css">
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
                                            Categor??as
                                        </a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="Prestamo?accion=listar">
                                            Pr??stamos 
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
                                        <input type="text" style="width:50%;" class="form-control" name="bus" placeholder="T??rmino de b??squeda" aria-label="Recipient's username" aria-describedby="button-addon2">

                                        <select name="bestseller" class="form-select" style="width:30%;">
                                            <option selected>BESTSELLER</option>
                                            <option value=0>NO</option>
                                            <option value=1>S??</option>
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

        <!-- INFO DE MI CUENTA -->
        <!-- NOMBRE, APELLIDOS, CORREO, ETC. -->

        <div class="container-fluid align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center text-center" style="font-family:monospace; color: aliceblue;">
                <h5 style="font-family:monospace; font-size : 46px; color: #ffffff;"><strong>LIBRO: <%= libro.getIsbn()%> <i class="fa-solid fa-book"></i></strong></h5>
                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light bg-dark p-5" style="border-radius: 5%;">
                    <form method="POST" action="Libro?accion=editar" enctype="multipart/form-data">



                        <div class="col-md-12 col-sm-12 mb-3 mt-4">
                            <h1 style="font-size: 30px; ;"><strong>EDITAR LIBRO</strong></h1>
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Libro</label>
                                <input type="text" class="form-control" name="titulo" value="<%= libro.getTitulo()%>">
                                <input type="hidden" name="isbn" value="<%= libro.getIsbn()%>">

                            </div>


                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Fecha Publicaci??n: <%= libro.getFechaPublicacion()%></label>
                                <input type="date" class="form-control" name="fecha" placeholder="Fecha" required>
                            </div>
                            <div class="mb-3">
                                <label for="formFile" class="form-label">Portada</label>
                                <input type="file" class="form-control" name="portada" placeholder="Ruta de imagen" id="formFile" required> 
                            </div>
                            <div class="mb-5">
                                <label for="exampleFormControlInput1" class="form-label">N??mero de Unidades</label>
                                <input type="numeric" class="form-control" name="unidades" placeholder="Unidades" required>
                            </div>                            

                            <label for="inputState" class="form-label">Bestseller</label>
                            <div class="form-floating mb-4">
                                <select name="bestseller" class="form-select" required>
                                    <option value=0>NO</option>
                                    <option value=1>S??</option>
                                </select>
                            </div>
                            <div class="mb-4">
                                <label for="exampleFormControlInput1" class="form-label">Descripci??n</label>
                                <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="3" required><%= libro.getDescripcion()%></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="inputState" class="form-label">Editorial</label>
                                <div class="form-floating">

                                    <select name="editorial" class="form-select" required>
                                        <option selected></option>
                                        <c:forEach items="${editoriales}" var="editorial">
                                            <option value=${editorial.idEditorial}>${editorial.idEditorial} ${editorial.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 col-sm-12 col-md-1">
                            <button class="btn btn-outline-info Hadow rounded border" type="submit">ACTUALIZAR</button>
                        </div>
                    </form>
                    <a class="mt-2 text-danger" href="">ELIMINAR LIBRO</a>
                </div>
            </div>

        </div>








    </div>




    <!-- HISTORIAL DE LIBROS/ LIBROSD EN ALQUILER... -->


    <!--ACTUALIZAR MI CUENTA-->

    <!--en esta linea se reparten los elementos-->








</div>
<!--AQU?? VAN LAS CARDS-->

<div class="container-fluid">
    <div class="row justify-content-center mt-3 pt-2 pb-2 bg-secondary">
        <h4 style="font-family:monospace; font-size : 46px; color: aliceblue;">MIS ??LTIMOS LIBROS
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
                    <a class="nav-link text-light" href="#">AY??DANOS A MEJORAR</a>
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