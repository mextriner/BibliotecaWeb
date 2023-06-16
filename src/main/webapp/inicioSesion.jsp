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

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Iniciar Sesión
        </title>

    </head>

    <body class="container-fluid d-flex justify-content-center">


        <div style="margin: 10rem" class="container-fluid bg-dark align-item-center">
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

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>



    </body>



</html>