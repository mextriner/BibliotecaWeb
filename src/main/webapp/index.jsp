<%-- 
    Document   : newjsp
    Created on : 01-feb-2023, 12:01:12
    Author     : Alumno Mañana
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página Principal
        </title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/fontawesome-free-6.3.0-web/css/all.min.css">
        <style>
            html,
            body {
                background: rgb(52, 52, 52);
                border-radius: 5%;
            }

            .principal {
                height: 100%;
            }

            .principal {
                font-family: monospace;
                font-size: 14px;
                color: #000;
                margin: 0;
                padding: 0;
            }

            .swiper {
                width: 100%;
                height: 100%;
            }

            .swiper-slide {
                text-align: center;
                font-size: 18px;
                /* Center slide text vertically */
                display: -webkit-box;
                display: -ms-flexbox;
                display: -webkit-flex;
                display: flex;
                -webkit-box-pack: center;
                -ms-flex-pack: center;
                -webkit-justify-content: center;
                justify-content: center;
                -webkit-box-align: center;
                -ms-flex-align: center;
                -webkit-align-items: center;
                align-items: center;
                padding: 15px;
                margin-top: 10px;
            }

            .swiper-slide img {
                display: block;
                width: 100%;
                height: 100%;
                object-fit: cover;


            }



            .card {
                border-radius: 5%;
                background: black;
                color: aliceblue;
            }

            .card:hover {
                background: rgb(199, 191, 191);
                color: black;
            }

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
        <!--SLIDER-->
        <main>
            <!--AQUÍ VAN LAS CARDS-->
            <center>
                <div class="col-sm-12 col-md-12 bg-dark" style="width: 100%;">
                    <h1 style="font-family:monospace; font-size : 46px; color: aliceblue;"><%= msj%>
                    </h1>
                    <div class="principal">
                        <!-- Swiper -->
                        <div class="container-fluid" style="height: 650px; width:100%;border-radius: 5%;">
                            <div class="row" style="height:100% ;">
                                <div class="col-sm-12 col-md-12" style="height:100% ;">
                                    <div class="swiper mySwiper">
                                        <div class="swiper-wrapper">
                                            <c:forEach items="${libros}" var="libro">
                                                <div class="swiper-slide">
                                                    <div class="card" style="width: 25em;">

                                                        <img src="data:image/jpg;base64,${libro.portadabase64}" class="card-img-top" alt="..." style="padding:5%">
                                                        <div class="card-body">
                                                            <p class="card-text"><strong>${libro.titulo}</strong><br>
                                                                ${libro.descripcion}</p>
                                                        </div>
                                                        <form method="post" action="Usuario?accion=sumar">
                                                            <input type="hidden" value="${libro.getIsbn()}" name="isbn">
                                                            <button class="btn btn-info" type="submit">AÑADIR AL CARRO</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>




                        <!-- Swiper JS -->
                        <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>

                        <!-- Initialize Swiper -->
                        <script>
                            var swiper = new Swiper(".mySwiper", {
                                slidesPerView: 1,
                                spaceBetween: 10,
                                pagination: {
                                    el: ".swiper-pagination",
                                    clickable: true,
                                },
                                breakpoints: {
                                    640: {
                                        slidesPerView: 2,
                                        spaceBetween: 20,
                                    },
                                    768: {
                                        slidesPerView: 4,
                                        spaceBetween: 40,
                                    },
                                    1024: {
                                        slidesPerView: 5,
                                        spaceBetween: 50,
                                    },
                                },
                            });
                        </script>
                    </div>
                </div>

            </center>

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



        </main>
        <script src="lb/js/bootstrap.min.js"></script>
    </body>

</html>