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

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Nueva Cuenta
        </title>
    </head>

    <body class="bg-secondary" style="font-family:monospace;">
        <jsp:include page="includes/navbar.jsp"/>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

    </body>

</html>