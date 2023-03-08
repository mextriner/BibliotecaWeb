<%@page import="com.maximo.Dominio.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.maximo.Service.Interfaz.iLibroService"%>
<%
    String user = "";
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("usuario") != null) {
        user = (String) sesion.getAttribute("usuario");
    } else {
        response.sendRedirect("inicioSesion.jsp");
    }
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
        <title>mi Carrito
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

    <body class="bg-secondary" style="font-family:monospace;">
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

        <div class="container-fluid">
            <div class="row" style="padding:100px;">
                <p class="text-danger bg-light" style="font-size:50px"><strong><%= msj%></strong></p>
                        <c:forEach items="${libros}" var="libro">
                    <div class="col-sm-12 col-md-3 text-light text-center bg-dark d-flex justify-content-center" style="border-radius:5%;border: solid 1px darkgray;">
                        <div style="padding:50px;">
                            <form action="Unidad?accion=procesar" method="POST">
                                <p>UNIDADES: ${libro.getUnidadList().size()}</p>
                                <img src="data:image/jpg;base64,${libro.portadabase64}" class="card-img-top" alt="..." style="padding:5%">
                                <div class="mb-3" style="height:120px;">
                                    <h1>${libro.getTitulo()}</h1>
                                    <p>ISBN:${libro.getIsbn()}</p>
                                </div>
                                <input type="hidden" name="isbn" value='${libro.getIsbn()}'>
                                <button class="btn btn-outline-info" type="submit"  id="button-addon2">PROCESAR</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>