<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Nuevo libro
        </title>
    </head>
    <body style = "margin-top:8rem">
        <!--LA BARRA DE NAVEGACION-->
        <jsp:include page="includes/navbar.jsp" />


        <!---->
        <div class="container-fluid bg-dark text-light">
            <!--en esta linea se reparten los elementos-->

            <form method="POST" action="Libro?accion=insertar" enctype="multipart/form-data">

                <div class="row d-flex justify-content-center">

                    <div class="col-md-4 col-sm-12 mb-3 mt-4">
                        <h1 style="font-size: 30px; ;"><strong>REGISTRO LIBRO <i class="fa-solid fa-book"></i></strong></h1>

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
                            <input type="file" class="form-control" name="portada" placeholder="Ruta de imagen" id="formFile">
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
                        <button class="btn btn-outline-success Hadow rounded border" type="submit">REGISTRAR</button>
                    </div>
                </div>
            </form>


        </div>
        <jsp:include page="includes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>

</html>