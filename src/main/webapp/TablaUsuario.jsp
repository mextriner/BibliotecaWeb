<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title>Usuarios
        </title>
    </head>
    <jsp:include page="includes/navbar.jsp"/>
    <body>
        <h1>BIENVENIDO: </h1>

        <div class="row d-flex justify-content-center px-5">
            <div class="col-md-4 col-sm-12" style="width:66%;">

                <!--Comenzamos a mostrar los datos-->
                <h2>Listado de USUARIOS <a class="text-dark" href="usuarioPdf.php"><i class="fa-solid fa-file-circle-plus"></i></a></h2>
                <table class="table" style="border: solid darkgray 1px;">

                    <tr>
                        <td>Nombre de Usuario</td>
                        <td>Nombre</td>
                        <td>Apellido</td>
                        <td>Dirección</td>
                        <td>Fecha de nacimiento</td>
                    </tr>
                    <c:forEach items="${usuarios}" var="usuario">
                        <tr style="border: solid black 2px;">
                            <td style="border: solid black 2px;">${usuario.getIdUsuario()}</td>
                            <td style="border: solid black 2px;">${usuario.getNombre()}</td>
                            <td style="border: solid black 2px;">${usuario.getApellido()}</td>
                            <td style="border: solid black 2px;">${usuario.getDireccion()}</td>
                            <td style="border: solid black 2px;">${usuario.getFechaNac().getYear()}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>        
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

        </div>
    </body>

</html>