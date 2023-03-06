<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro</title>
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">
        <link rel="stylesheet" href="swiper/swiper-bundle.min.css" />
        <link rel="stylesheet" href="lb/fontawesome-free-6.3.0-web/css/all.min.css">
    </head>

    <body class="bg-secondary text-light" style="font-family:monospace;">
        <div>

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
                                    <a class="nav-link dropdown-toggle text-light" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        ¿Tienes cuenta? <i class="fa-solid fa-user"></i>
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <li><a class="dropdown-item" href="registro.jsp">Registrarse</a></li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>
                                        <li><a class="dropdown-item" href="inicSesion.php">Iniciar Sesión</a></li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>
                                        <li><a class="dropdown-item" href="gestionPerfil.php">Mi cuenta</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown" style="margin-left:5px;">
                                    <a class="nav-link text-light" href="tablas.php" id="navbarDropdown" role="button">
                                        Tablas <i class="fa-sharp fa-solid fa-chart-simple"></i>
                                    </a>
                                </li>
                                <li class="nav-item dropdown" style="margin-left:5px;">
                                    <a class="nav-link text-light" href="listarLibros.php" id="navbarDropdown" role="button">
                                        Libros <i class="fa-solid fa-book-bookmark"></i>
                                    </a>
                                </li>
                                <li class="nav-item dropdown" style="margin-left:5px;">
                                    <a class="nav-link dropdown-toggle text-light" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        INSERTAR <i class="fa-solid fa-circle-plus"></i>
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <li><a class="dropdown-item" href="NuevoLibro">Registrar Libro</a></li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>
                                        <li><a class="dropdown-item" href="registroEditorial.jsp">Registrar Editorial</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown" style="margin-left:5px;">
                                    <form method="GET" class="d-flex text-light">

                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" name="bus" placeholder="Término de búsqueda" aria-label="Recipient's username" aria-describedby="button-addon2">

                                            <button class="btn btn-outline-info" name="buscar" value="yes" type="submit" id="button-addon2">Buscar</button>
                                        </div>


                                    </form>
                                </li>



                            </ul>
                            <form method="post" action="">
                                <input type="hidden" value="1" name="cerrar">
                                <button class="btn btn-danger" type="submit" value="1" id="button-addon2">CERAR SESION</button>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="container-fluid bg-dark">
                <!--en esta linea se reparten los elementos-->

                <form method="POST" action="Libro?accion=insertar" enctype="multipart/form-data">

                    <div class="row d-flex justify-content-center">

                        <div class="col-md-4 col-sm-12 mb-3 mt-4">
                            <h1 style="font-size: 30px; ;"><strong>REGISTRO</strong></h1>

                            <label for="exampleFormControlInput1" class="form-label">Libro</label>
                            <input type="text" class="form-control" name="Titulo" placeholder="Título">
                        </div>
                    </div>
                    <div class="row d-flex justify-content-center">


                        <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">


                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">ISBN</label>
                                <input type="text" class="form-control" name="ISBN" placeholder="00 0000 000 0" required>
                            </div>

                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Fecha Publicación</label>
                                <input type="date" class="form-control" name="Fecha" placeholder="Fecha" required>
                            </div>
                            <div class="mb-3">
                                <label for="formFile" class="form-label">Portada</label>
                                <input type="file" class="form-control" name="portada" placeholder="Ruta de imagen" id="formFile"> required
                            </div>
                            <div class="mb-5">
                                <label for="exampleFormControlInput1" class="form-label">Número de Unidades</label>
                                <input type="number" class="form-control" name="Unidades" placeholder="Unidades" required>
                            </div>

                            <div class="mb-3">
                                <a style="font-size:20px;" class="text-light" href="#" onclick="duplicarDiv2()"><i class="fa-solid fa-circle-plus"></i></a>

                                <label for="inputState" class="form-label">Categorías</label>
                                <div id="categoriaDuplica" class="form-floating">

                                    <select name="categoria" class="form-select" required>
                                        <option selected></option>
                                        <c:forEach items="${categorias}" var="categoria">
                                            <option value=${categoria.idCategoria}>${categoria.idCategoria} ${categoria.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-2"id="conten"></div>

                            <script>
                                var originalDiv = document.getElementById("categoriaDuplica");

                                function duplicarDiv2() {
                                    var divCopia = originalDiv.cloneNode(true);
                                    // Agrega cualquier modificación adicional que desees hacer a la copia del div
                                    var contenedor = document.getElementById("conten");
                                    contenedor.appendChild(divCopia); // Agrega la copia del div al contenedor
                                    var nuevoBoton = document.createElement("a");
                                    var nuevoIcono = document.createElement("i");
                                    nuevoIcono.className = "fa-solid fa-circle-minus";
                                    nuevoBoton.appendChild(nuevoIcono);
                                    nuevoBoton.onclick = function () {
                                        eliminarDiv(this);
                                    }
                                    divCopia.appendChild(nuevoBoton);
                                }

                                function eliminarDiv(btn) {
                                    var divAEliminar = btn.parentNode;
                                    divAEliminar.remove();
                                }
                            </script>
                        </div>
                        <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">
                            <label for="inputState" class="form-label">Bestseller</label>
                            <div class="form-floating mb-4">
                                <select name="bestseller" class="form-select" required>
                                    <option value=0>NO</option>
                                    <option value=1>SÍ</option>
                                </select>
                            </div>
                            <div class="mb-4">
                                <label for="exampleFormControlInput1" class="form-label">Descripción</label>
                                <textarea class="form-control" name="descripcion" id="exampleFormControlTextarea1" rows="3" required></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="inputState" class="form-label">Editorial</label>
                                <div class="form-floating">

                                    <select name="editorial" class="form-select" required>
                                        <option selected></option>
                                        <c:forEach items="${editoriales}" var="editorial">
                                            <option value=${editorial.idEditorial}>${editorial.idEditorial} ${editorial.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="mb-2">
                                <a style="font-size:20px;" class="text-light" href="#" onclick="duplicarDiv()"><i class="fa-solid fa-circle-plus"></i></a>
                                <label for="inputState" class="form-label">Autores</label>
                                <div id="duplica" class="form-floating">

                                    <select name="autor" class="form-select" required>
                                        <option selected></option>
                                        <c:forEach items="${autores}" var="autor">
                                            <option value=${autor.idAutor}>${autor.idAutor} ${autor.nombre} ${autor.apellido}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-2"id="contenedor"></div>

                            <script>
                                var divOrigina = document.getElementById("duplica");

                                function duplicarDiv() {
                                    var divCopiado = divOrigina.cloneNode(true);
                                    // Agrega cualquier modificación adicional que desees hacer a la copia del div
                                    var contenedor = document.getElementById("contenedor");
                                    contenedor.appendChild(divCopiado); // Agrega la copia del div al contenedor
                                    //var contenedor2 = document.createElement("div");
                                    var nuevoBoton = document.createElement("a");
                                    var nuevoIcono = document.createElement("i");
                                    nuevoIcono.className = "fa-solid fa-circle-minus";
                                    nuevoBoton.appendChild(nuevoIcono);
                                    nuevoBoton.onclick = function () {
                                        eliminarDiv(this);
                                    }
                                    divCopiado.appendChild(nuevoBoton);
                                }

                                function eliminarDiv(btn) {
                                    var divAEliminar = btn.parentNode;
                                    divAEliminar.remove();
                                }
                            </script>


                        </div>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <div class="mb-3 col-sm-12 col-md-1">
                            <button class="btn btn-outline-success Hadow rounded border" type="submit">REGISTRARSE</button>
                        </div>
                    </div>
                </form>


            </div>
        </div>
        <script src="lb/js/bootstrap.min.js"></script>
    </body>

</html>