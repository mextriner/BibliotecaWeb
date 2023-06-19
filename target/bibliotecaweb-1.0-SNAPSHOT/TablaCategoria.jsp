<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="includes/head.jsp"/>
    <head>
        <title>Categorías
        </title>
    </head>
    <body style = "margin-top:8rem">
        <jsp:include page="includes/navbar.jsp"/>
        <section>
            <h1>BIENVENIDO: </h1>

            <div class="row d-flex justify-content-center px-5">
                <div class="col-md-4 col-sm-12" style="width:66%;">

                    <!--Comenzamos a mostrar los datos-->
                    <h2>Listado de CATEGORÍAS <a class="text-dark" href="usuarioPdf.php"><i class="fa-solid fa-file-circle-plus"></i></a></h2>
                    <table class="table" style="border: solid darkgray 1px;">

                        <tr>
                            <td>ID CATEGORIA</td>
                            <td>Nombre</td>
                            <td>Descripción</td>
                            <td>Eliminar</td>
                            <td>Editar</td>
                        </tr>
                        <c:forEach items="${categorias}" var="categoria">
                            <tr style="border: solid black 2px;">
                                <td style="border: solid black 2px;">${categoria.getIdCategoria()}</td>
                                <td style="border: solid black 2px;">${categoria.getNombre()}</td>
                                <td style="border: solid black 2px;">${categoria.getDescripcion()}</td>
                                <td style="border: solid black 2px;"><a class="text-danger" href=""><i class="fa-solid fa-trash"></i></a></td>
                                <td style="border: solid black 2px;"><a class="text-primary" href="cargarModifica?clase=categoria&categoriaId=${categoria.getIdCategoria()}"><i class="fa-solid fa-pen"></i></a></td>

                            </tr>
                        </c:forEach>

                    </table>
                </div>

        </section>
        <jsp:include page="includes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>

</html>