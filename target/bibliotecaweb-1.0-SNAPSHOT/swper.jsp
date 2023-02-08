<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>Swiper demo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
        <!-- Link Swiper's CSS -->
        <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" /> -->
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">

        <!-- Demo styles -->
        <style>
            html, body {
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
        </style>
    </head>

    <body>
        <div class="principal">
            <!-- Swiper -->
            <div class="container-fluid" style="height:50% ;">
                <div class="row" style="height:100% ;">
                    <div class="col-sm-12 col-md-12" style="height:100% ;">
                        <div class="swiper mySwiper">
                            <div class="swiper-wrapper">
                                
                                <c:forEach items="${libros}" var="libro">
                                    
                                    <div class="swiper-slide">
                                        <div class="card" style="width: 25em;">
                                            <img src="${libro.portada}" class="card-img-top" alt="...">
                                            <div class="card-body">
                                                <p class="card-text"><strong>${libro.titulo}</strong>${libro.descripcion}</p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>



                            </div>

                        </div>
                        <div class="swiper-pagination"></div>
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
    </body>



</html>