<%@page import="com.maximo.Dominio.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.maximo.Service.Interfaz.iLibroService"%>

<%
    String user = "";
    HttpSession sesion = request.getSession();
    String msj = "";
    if (request.getAttribute("msj") != null) {
        msj = "Resultado de: " + ((String) request.getAttribute("msj")).toUpperCase();

    }
    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    } else {
        response.sendRedirect("inicioSesion.jsp");
    }
    boolean isAdmin = user.equals("admin");
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Libros
        </title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/fontawesome-free-6.3.0-web/css/all.min.css">
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
    <jsp:include page="includes/head.jsp"/>

    <body class="bg-secondary" style="font-family:monospace;">
        <jsp:include page="includes/navbar.jsp"/>
        <div class="container-fluid">
            <div class="row" style="padding:100px;">
                <c:forEach items="${libros}" var="libro">
                    <div class="col-sm-12 col-md-3 text-light text-center bg-dark d-flex justify-content-center" style="border-radius:5%;border: solid 1px darkgray;">
                        <div style="padding:50px;">
                            <form action="NuevoLibro?accion=editar" method="POST">
                                <p>UNIDADES: ${libro.getUnidadList().size()}</p>
                                <img src="data:image/jpg;base64,${libro.portadabase64}" class="card-img-top" alt="..." style="padding:5%">
                                <div class="mb-3" style="height:120px;">
                                    <h1>${libro.getTitulo()}</h1>
                                    <p>ISBN:${libro.getIsbn()}</p>
                                </div>
                                <input type="hidden" name="idLibro" value='${libro.getIsbn()}'>
                                <c:if test="<%= isAdmin%>">
                                    <button class="btn btn-outline-info" type="submit" name="editar" id="button-addon2">EDITAR</button>

                                </c:if>

                            </form>
                            <c:if test="<%= isAdmin%>">
                                <form action="" method="POST">
                                    <input type="hidden" name="idLibro" value='${libro.getIsbn()}'>
                                    <button class="btn btn-outline-danger mt-3" type="submit" name="eliminar" id="button-addon2">ELIMINAR</button>
                                </form>
                            </c:if>
                            <form action="Libro?accion=detalleLibro" method="POST">
                                <input type="hidden" name="ISBN" value='${libro.getIsbn()}'>
                                <button class="btn btn-outline-info mt-3" type="submit" name="verDetalle" id="button-addon2">VER MÁS</button>
                            </form>

                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>

</html>