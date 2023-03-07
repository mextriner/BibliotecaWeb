<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = "";
    if (request.getAttribute("mensaje") != null) {
        mensaje = "*" + (String) request.getAttribute("mensaje") + "*";
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio Sesión</title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/fontawesome-free-6.3.0-web/css/all.min.css">
    </head>

    <body class="bg-secondary" style="font-family:monospace;">


        <div class="container-fluid bg-dark align-item-center">
            <!--en esta linea se reparten los elementos-->
            <div class="row d-flex justify-content-center">
                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">
                    <form method="POST" action="Usuario?accion=sesion">
                        <h1 style="font-size: 30px; margin-top:27px;"><strong>INICIAR SESIÓN</strong></h1>¿NO TIENES CUENTA? <a class="text-light" href="registro.jsp">REGÍSTRATE</a><br>
                        <div class="mt-3 mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" name="usuario" placeholder="Usuario">
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Clave</label>
                            <input type="password" class="form-control" name="clave" placeholder="Contraseña">
                        </div>
                        <div class="mb-3 bg-secondary text-light">
                            <p><%= mensaje%></p>
                        </div>
                        <div class="mt-5 col-12 d-flex justify-content-center align-item-center">
                            <button class="btn btn-outline-success Hadow rounded border" type="submit">INICIAR SESIÓN</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script src="lb/js/bootstrap.min.js"></script>
    </body>

</html>