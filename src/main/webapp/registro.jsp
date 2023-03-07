<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String msj = "";
    if (request.getAttribute("msj") != null) {
        msj = (String) request.getAttribute("msj");

    }

%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro</title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/fontawesome-free-6.3.0-web/css/all.min.css">
    </head>

    <body class="bg-secondary" style="font-family:monospace;">
        <!---->
        <div class="container-fluid bg-dark align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center">
                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">
                    <form method="POST" action="Usuario?accion=insertar">
                        <h1 style="font-size: 30px; ;"><strong>REGISTRO </strong><i class="fa-solid fa-user"></i></h1>¿YA TIENES CUENTA? <a class="text-light" href="inicioSesion.jsp">INICIA SESEIÓN</a><br>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" name="usuario" placeholder="Usuario" required>
                            <p class="text-danger bg-grey"><%= msj%><p>
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Clave</label>
                            <input type="password" class="form-control" name="clave" placeholder="Contraseña" required>
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" placeholder="Nombre">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Apellido</label>
                            <input type="text" class="form-control" name="apellido" placeholder="Apellidos">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Direccion</label>
                            <input type="text" class="form-control" name="direccion" placeholder="Direccion de Residencia">
                        </div>

                        <div class="mb-5 pb-3">
                            <label for="exampleFormControlInput1" class="form-label">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" name="fechaNac" placeholder="Fecha de Nacimiento" required>
                        </div>
                        <input type="hidden" name="oculto" value="1">
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