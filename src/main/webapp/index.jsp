<%-- 
    Document   : newjsp
    Created on : 01-feb-2023, 12:01:12
    Author     : Alumno Mañana
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index
    </title>
    <link rel="stylesheet" href="lb/css/bootstrap.min.css">
    <link rel="stylesheet" href="fuentes/css/all.min.css">
    <style>
        .carrusel {
            width: 60%;
            margin-bottom: 20px;
        }

        main {
            margin-top: 160px;
        }
    </style>
</head>

<body class="bg-secondary" style="font-family:monospace;">


    <!--LA BARRA DE NAVEGACION-->
    <div class="container-fluid bg-dark fixed-top" style="padding:0">
        <nav class="navbar navbar-expand-lg navbar-light " style="margin: 5px ; font-size: 40px;">
            <div class="container-fluid">

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <div class="bg-ligth">
                        <span class="navbar-toggler-icon"></span>
                    </div>

                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex justify-content-center">
                        <li class="nav-item">
                            <a class="nav-link active text-light" aria-current="page" href="#">Inicio</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                ¿Tienes cuenta?
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="font-size: 40px;">
                                <li><a class="dropdown-item" href="#">Registrarse</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Iniciar Sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                    <a class="navbar-brand" href="https://www.leagueoflegends.com/es-es/"><img
                            src="img/bibliLogoRec.png" alt="" style="width:50% ;"></a>

                    <form class="d-flex" style="width: 41.05%;">

                        <input type="text" class="form-control" placeholder="Término de búsqueda">
                        <button class="btn btn-lg btn-outline-success" type="submit">BUSCAR</button>
                    </form>
                </div>

            </div>
    </div>

    </div>


    </div>
    </nav>

    </div>


    <!---->
    <!--SLIDER-->
    <main>
        <div class="container-fluid carrusel bg-dark">
            <h4 style="font-family:monospace; font-size : 46px; color: aliceblue;">AUTORES DESTACADOS</h4>

            <div id="carouselExampleControls" class="carousel slide justify contetn-center text-center text-light"
                data-bs-ride="carousel" style="font-size:40px;">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/bardo.webp" class="d-block w-100" alt="...">
                        <strong>BARDO</strong>
                    </div>
                    <div class="carousel-item">
                        <img src="img/MissFortune_1.jpg" class="d-block w-100" alt="...">
                        <strong>MISS FORTUNE</strong>
                    </div>
                    <div class="carousel-item">
                        <img src="img/Mordekaiser_13.jpg" class="d-block w-100" alt="...">
                        <strong>MORDEKAISER</strong>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>

            </div>

        </div>







        <!--AQUÍ VAN LAS CARDS-->
        <center>
            <div class="col-sm-12 col-md-12 bg-dark" style="width: 60%;">
                <h1 style="font-family:monospace; font-size : 46px; color: aliceblue;">LOS FAVORITOS DE LOS LECTORES
                </h1>
                <iframe src="swper.jsp" style="height: 300px; width:40%;border-radius: 5%;"></iframe>
            </div>

        </center>



        <div class="container-fluid">
            <div class="row d-flex justify-content-center mt-3 pt-2 pb-2 bg-secondary text-center bg-dark">
                <h4 style="font-family:monospace; font-size : 46px; color: aliceblue;"><strong>AUTORES
                        POPULARES</strong></h4>
                <div class="col-sm-12 col-md-2">
                    <div class="card bg-success text-light" style="width: 18rem;">
                        <img src="img/teemo.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text"><strong>Teemo</strong> con su veneno y su cegado es, sin lugar a
                                dudas, el terror de la
                                toplane.</p>
                        </div>
                    </div>
                </div>


                <div class="col-sm-12 col-md-2">
                    <div class="card bg-success text-light " style="width: 18rem;">
                        <img src="img/bardo.webp" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text"><strong>Bardo</strong> es el compañero ideal para el adc ya que
                                gracias a la curaciión y
                                los portales es fácil escapar.</p>
                        </div>
                    </div>
                </div>


                <div class="col-sm-12 col-md-2">
                    <div class="card bg-success text-light" style="width: 18rem;">
                        <img src="img/MissFortune_1.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text"><strong>Miss Fortune</strong> la famosa pirata de Aguas
                                Estancadas derrite tanques, estructuras y adc's a
                                partes iguales.</p>
                        </div>
                    </div>
                </div>





                <div class="col-sm-12 col-md-2">
                    <div class="card bg-success text-light" style="width: 18rem;">
                        <img src="img/Mordekaiser_13.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text"><strong>Mordekaiser</strong> una divinidad menor dedicada a la
                                guerra te transporta a su mundo
                                para robarrte tu alma y ejecutarde ahí.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--FOOTER-->

        <div class="container-flid  bg-secondary">
            <nav class="navbar navbar-expand-lg navbar-light bg-secondary mt-3">
                <div class="container-fluid ">
                    <div class="row">
                        <div class="col-12 justify-content-center">
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            </button>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex">
                                    <li class="nav-item">
                                        <a class="nav-link active text-light" aria-current="page" href="#">ACERCA
                                            DEL
                                            LEAGUE
                                            OF LEGENDS</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link text-light" href="#">AYÚDANOS A MEJORAR</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link disabled text-light" href="#" tabindex="-1"
                                            aria-disabled="true">ASISTENCIA</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link disabled text-light" href="#" tabindex="-1"
                                            aria-disabled="true">ESTADO DEL SERVIDOR</a>
                                    </li>
                                </ul>
                            </div>
                        </div>


                    </div>


                </div>
            </nav>
            <div class="row d-flex align-items-center justify-content-center mb-3">

                <div class="col-sm-12 col-md-4  text-light">
                    <i class="copy fa-sharp fa-solid fa-copyright text-warning" style="font-size:30px ;"></i>opyRight.
                    Página propiedad de
                    RiotGmes
                </div>
                <div class="row col-sm-12 col-md-4 ">
                    <div class="col"><i class="fa-brands fa-facebook"></i></div>
                    <div class="col"> <i class="fa-brands fa-instagram"></i></div>
                    <div class="col"><i class="fa-brands fa-twitter"></i></div>
                    <div class="col"> <i class="fa-brands fa-youtube"></i></div>
                </div>
            </div>
        </div>


        <script src="lb/js/bootstrap.min.js"></script>
    </main>

</body>

</html>