<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="includes/head.jsp"/>
    <head>
        <title> Nuevo Autor
        </title>
    </head>
    <body style = "margin-top:8rem">
        <jsp:include page="includes/navbar.jsp"/>

        <div class="container-fluid bg-dark">
            <!--en esta linea se reparten los elementos-->


            <div class="row  d-flex justify-content-center">
                <div class="col-md-4 col-sm-12 mb-3 mt-4">
                    <h1 style="font-size: 30px;"><strong>REGISTRAR AUTOR</strong> <i class="fa-solid fa-feather"></i></h1>
                </div>
            </div>
            <div class="row d-flex justify-content-center">


                <div class="col-sm-12 col-md-4 mt-3 mb-3 text-light">

                    <form method="post" action="Autor?accion=insertar">

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" placeholder="Nombre del autor" required>
                        </div>

                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" name="apellido" placeholder="Apellido del autor" required>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Nacionalidad</label>
                            <input type="text" class="form-control" name="nacionalidad" placeholder="Nacionalidad">
                        </div>

                        <div class="mb-4">
                            <label for="exampleFormControlInput1" class="form-label">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" name="fecha" placeholder="Fecha de nacimiento">
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-outline-success Hadow rounded border" type="submit">REGISTRAR</button>

                        </div>
                    </form>

                </div>
            </div>
        </div>
        <jsp:include page="includes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>

</html>