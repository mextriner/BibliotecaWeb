
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

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Usuario: <%= usuario.getNombre()%>
        </title>

    </head>
    <body>
        <jsp:include page="includes/navbar.jsp"/>


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
        <div>
            <h2>Mis libros</h2>
        </div>

        <!-- HISTORIAL DE LIBROS/ LIBROSD EN ALQUILER... -->



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






    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>

</html>