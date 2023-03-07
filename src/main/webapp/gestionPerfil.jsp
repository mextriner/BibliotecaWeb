
<%@page import="com.maximo.Dominio.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = "";
    HttpSession sesion = request.getSession();

    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    } else {
        response.sendRedirect("inicioSesion.jsp");
    }
    Usuario usuario = (Usuario) request.getAttribute("usuario");
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
                                <a class="nav-link text-light" href="cargarModifica?clase=usuario&usr=<%=user%>">
                                    Mi cuenta: <%=user%>
                                </a>

                            </li>

                            <li class="nav-item dropdown" style="margin-left:5px;">
                                <a class="nav-link text-light" href="accion?libros=deafult" id="navbarDropdown" role="button">
                                    Libros <i class="fa-solid fa-book-bookmark"></i>
                                </a>
                            </li>


                            <li class="nav-item dropdown" style="margin-left:5px;">
                                <a class="nav-link text-light" href="Libro?accion=carrito" id="navbarDropdown" role="button">
                                    Mi carrito <i class="fa-solid fa-cart-shopping"></i>
                                </a>
                            </li>
                            <li class="nav-item dropdown" style="margin-left:5px;width:500px;">
                                <form action="Libro?accion=buscarU" method="post" class="d-flex text-light">

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

        <!-- INFO DE MI CUENTA -->
        <!-- NOMBRE, APELLIDOS, CORREO, ETC. -->

        <div class="container-fluid align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center text-center" style="font-family:monospace; color: aliceblue;">
                <h5 style="font-family:monospace; font-size : 46px; color: #ffffff;"><strong>CUENTA: <%= usuario.getIdUsuario()%><i class="fa-solid fa-user"></i></strong></h5>
                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light bg-dark p-5" style="border-radius: 5%;">
                    <form class="mb-5" method="post" action="Usuario?accion=editar">
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" name="clave" placeholder="Contraseña" required>
                        </div>
                        <div>
                            <input type="hidden" class="form-control" name="usuario" value="<%= usuario.getIdUsuario()%>">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" value="<%= usuario.getNombre()%>">
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" name="apellido" value="<%= usuario.getApellido()%>">
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Direccion</label>
                            <input type="text" class="form-control" name="direccion" value="<%= usuario.getDireccion()%>" required>
                        </div>
                        <div class="mt-5 mb-5 pb-3">
                            <label for="exampleFormControlInput1" class="form-label">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" name="fechaNac" value="<%= usuario.getFechaNac()%>" required>
                        </div>

                        <div class="mt-5 col-12 d-flex justify-content-center align-item-center">
                            <button class="btn btn-outline-info Hadow rounded border" name="actualizar" type="submit">ACTUALIZAR
                                CUENTA</button>
                        </div>
                    </form>
                    <a class="mt-2 text-danger" href="eliminarUsuario.php?idUsuario=<?php echo $_SESSION['id'] ?>">ELIMINAR CUENTA</a>
                </div>
            </div>

        </div>








    </div>




    <!-- HISTORIAL DE LIBROS/ LIBROSD EN ALQUILER... -->


    <!--ACTUALIZAR MI CUENTA-->

    <!--en esta linea se reparten los elementos-->








</div>
<!--AQUÍ VAN LAS CARDS-->



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






<script src="lb/js/bootstrap.min.js"></script>
</body>

</html>