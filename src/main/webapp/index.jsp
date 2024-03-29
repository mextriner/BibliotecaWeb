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

    } else {
        msj = "LOS MÁS SOLICITADOS";
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
    <jsp:include page="includes/head.jsp"/>
    <head>
        <title>Nueva Categoría
        </title>
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <style>
            html,

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
        </style>
    </head>



    <body style = "margin-top:8rem">

        <jsp:include page="includes/navbar.jsp" />

        <!---->
        <!--SLIDER-->
        <main>
            <!--AQUÍ VAN LAS CARDS-->
            <center>
                <div class="col-sm-12 col-md-12" style="width: 100%;">
                    <h1 style="color: #000 ; font-family:monospace; font-size : 46px;"><%= msj%>
                    </h1>
                    <div class="principal">
                        <!-- Swiper -->
                        <div class="container-fluid" style="height: 650px; width:100%;border-radius: 1rem;">
                            <div class="row" style="height:100% ;background-color: whitesmoke;">
                                <div class="col-sm-12 col-md-12" style="height:100% ;">
                                    <div class="swiper mySwiper">
                                        <div class="swiper-wrapper">
                                            <c:forEach items="${libros.keySet()}" var="libro">
                                                <div class="swiper-slide">
                                                    <div class="card" style="width: 25em; padding: 1rem">
                                                        <h5 class="card-title">${libro.titulo}</h5>
                                                        <img src="data:image/jpg;base64,${libro.portadabase64}" class="card-img-top"  style="padding:5%">
                                                        <div class="card-body">
                                                            <p>ISBN: ${libro.isbn} </p>
                                                            <p>${libro.unidadList.size()} unidades</p>
                                                            <form action="Libro?accion=detalleLibro" method="POST">
                                                                <input type="hidden" name="ISBN" value='${libro.getIsbn()}'>
                                                                <button class="btn btn-outline-info mt-3" type="submit" name="verDetalle" id="button-addon2">VER MÁS</button>
                                                            </form>
                                                        </div>
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
            <div style="margin:3rem;">
                <h3>Todos los libros</h3>
                <c:forEach items="${libros.keySet()}" var="libro">

                    <div class="row d-flex align-items-center" style="background-color: whitesmoke; margin: 3rem">
                        <div class="col-md-2 col-sm-12 d-flex justify-content-left mt-2 mb-3">
                            <img width="180rem" style="margin:0; padding: 0" src="data:image/jpg;base64,${libro.portadabase64}">
                        </div>
                        <div class="col-md-8 col-sm-12">
                            <article>
                                <h3>${libro.titulo}. ISBN: ${libro.isbn}</h3>
                                <p>${libro.descripcion}</p>
                            </article>
                        </div>
                        <div class="col-md-2 col-sm-12">
                            <form action="Libro?accion=detalleLibro" method="POST">
                                <input type="hidden" name="ISBN" value='${libro.getIsbn()}'>
                                <button class="btn btn-outline-success mt-3" type="submit" name="verDetalle" id="button-addon2">Ver más</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>

            </div>




        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
    <jsp:include page="includes/footer.jsp"/>

</html>