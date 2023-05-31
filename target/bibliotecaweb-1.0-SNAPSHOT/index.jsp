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

    <jsp:include page="includes/head.jsp"/>
    <head>
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

        <div class="row">
            <div class="col-sm-12 com-md-12" >

                <jsp:include page="includes/navbar.jsp" />
            </div>
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

            <jsp:include page="includes/footer.jsp" />



        </main>
        <script src="lb/js/bootstrap.min.js"></script>
    </body>

</html>